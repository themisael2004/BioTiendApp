package model.Product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fruit extends OrganicProduct {
    // Atributos específicos de las frutas
    /** Tipo de fruta (Tropicales, Cítrico, Drupas) que determina el incremento de precio */
    private String fruitType;

    /** Días de frescura de la fruta, usado para aplicar descuentos */
    private int freshnessDays;

    public Fruit(int idProduct, String nameProduct, int idSupplier,
                 LocalDateTime dateAdmission, String type, double price, String fruitType, int freshnessDays) {
        // Llamada al constructor de la clase padre
        super(idProduct, nameProduct, idSupplier, dateAdmission, type, price);
        this.fruitType = fruitType;
        this.freshnessDays = freshnessDays;
    }

    @Override
    public double calculateSalePrice() {
        double incrementPercentage = 0.0;

        // Determinar incremento según el tipo de fruta
        if (fruitType.equalsIgnoreCase("Tropicales")) {
            incrementPercentage = 0.10; // 10% de incremento para frutas tropicales
        } else if (fruitType.equalsIgnoreCase("Citrico")) {
            incrementPercentage = 0.05; // 5% de incremento para frutas cítricas
        } else if (fruitType.equalsIgnoreCase("Drupas")) {
            incrementPercentage = 0.15;  // 15% de incremento para drupas (frutas con hueso)
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

    public String getFruitType() {
        return fruitType;
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
                 Tipo de fruta: %s
                 Categoría: Fruta
                 Días de frescura: %d
                 Tipo: %s
                 Proveedor ID: %d
                 Fecha de admisión: %s
                 Precio base: %.2f
                 Precio de venta (con IVA): %.2f
                 Precio con descuento (con IVA): %.2f
                 """.formatted(super.toString(),nameProduct,fruitType, freshnessDays, type, idSupplier, formattedDateAdmission,
                price, salePrice, priceWithDiscount);
    }
}