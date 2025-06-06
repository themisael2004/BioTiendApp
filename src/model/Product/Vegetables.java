package model.Product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Vegetable extends OrganicProduct {

    // Atributos específicos de los vegetales
    /** Tipo de vegetal (Raíz, Hoja, Tallo) que determina el incremento de precio */
    private String vegetableType;
    /** Días de frescura del vegetal, usado para aplicar descuentos */
    private int freshnessDays;

    public Vegetable(int idProduct, String nameProduct, int idSupplier,
                     LocalDateTime dateAdmission, String type, double price, String vegetableType, int freshnessDays) {
        // Llamada al constructor de la clase padre
        super(idProduct, nameProduct, idSupplier, dateAdmission, type, price);
        this.vegetableType = vegetableType;
        this.freshnessDays = freshnessDays;
    }

    @Override
    public double calculateSalePrice() {
        double incrementPercentage = 0.0;

        // Determinar incremento según el tipo de vegetal
        if (vegetableType.equalsIgnoreCase("Raiz")) {
            incrementPercentage = 0.10; // 10% de incremento para vegetales de raíz
        } else if (vegetableType.equalsIgnoreCase("Hoja")) {
            incrementPercentage = 0.05; // 5% de incremento para vegetales de hoja
        } else if (vegetableType.equalsIgnoreCase("Tallo")) {
            incrementPercentage = 0.15; // 15% de incremento para vegetales de tallo
        }

        // Aplicar incremento al precio base
        double priceWithIncrement = this.price * (1 + incrementPercentage);

        // Aplicar IVA al precio con incremento
        double finalPrice = priceWithIncrement * IVA;

        return finalPrice;
    }

    @Override
    public double applyDiscount(double currentPrice) {
        if (freshnessDays <= 3) {
            // Producto muy fresco, sin descuento
            return currentPrice;
        } else if (freshnessDays <= 7) {
            // Descuento del 15% para productos moderadamente frescos
            return currentPrice * PAY_85_PERCENT;
        } else {
            // Descuento del 30% para productos menos frescos
            return currentPrice * PAY_70_PERCENT;
        }
    }

    public String getVegetableType() {
        return vegetableType;
    }

    public int getFreshnessDays() {
        return freshnessDays;
    }

    @Override
    public String getDetails() {
        // Formateador para mostrar fecha en formato legible
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        String formattedDateAdmission = dateAdmission.format(formatter);

        // Calcular precios para mostrar en el reporte
        double salePrice = calculateSalePrice();
        double priceWithDiscount = applyDiscount(salePrice);

        // Retornar reporte detallado formateado
        return """

                -------------------------------------
                        Detalle del producto
                -------------------------------------
                 %s
                 Nombre producto: %s
                 Tipo de verdura: %s
                 Categoría: Verdura
                 Días de frescura: %d
                 Tipo: %s
                 Proveedor ID: %d
                 Fecha de admisión: %s
                 Precio base: %.2f
                 Precio de venta (con IVA): %.2f
                 Precio con descuento (con IVA): %.2f
                 """.formatted(super.toString(),nameProduct,vegetableType, freshnessDays, type, idSupplier, formattedDateAdmission,
                price, salePrice, priceWithDiscount);
    }
}