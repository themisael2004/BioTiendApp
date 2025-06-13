package model.Product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un producto vegetal (subtipo de OrganicProduct)
 */
public class Vegetable extends OrganicProduct {

    // Tipo de vegetal (Raíz, Hoja, Tallo)
    private String vegetableType;

    // Días desde la admisión, usados para calcular descuentos
    private int freshnessDays;

    public Vegetable(int idProduct, String nameProduct, int idSupplier,
            LocalDateTime dateAdmission, String type, double price,
            String vegetableType, int freshnessDays) {
        super(idProduct, nameProduct, idSupplier, dateAdmission, type, price);
        this.vegetableType = vegetableType;
        this.freshnessDays = freshnessDays;
    }

    /**
     * Calcula el precio de venta con incremento según el tipo de vegetal y aplica
     * IVA
     */
    @Override
    public double calculateSalePrice() {
        double incrementPercentage = 0.0;

        // Incrementos personalizados según tipo
        if (vegetableType.equalsIgnoreCase("Raiz")) {
            incrementPercentage = 0.10;
        } else if (vegetableType.equalsIgnoreCase("Hoja")) {
            incrementPercentage = 0.05;
        } else if (vegetableType.equalsIgnoreCase("Tallo")) {
            incrementPercentage = 0.15;
        }

        double priceWithIncrement = this.price * (1 + incrementPercentage);
        return priceWithIncrement * IVA;
    }

    /**
     * Aplica descuentos según la frescura
     */
    @Override
    public double applyDiscount(double currentPrice) {
        if (freshnessDays <= 3) {
            return currentPrice;
        } else if (freshnessDays <= 7) {
            return currentPrice * PAY_85_PERCENT;
        } else {
            return currentPrice * PAY_70_PERCENT;
        }
    }

    public String getVegetableType() {
        return vegetableType;
    }

    public int getFreshnessDays() {
        return freshnessDays;
    }

    /**
     * Muestra todos los detalles relevantes del vegetal, incluyendo precios y
     * descuentos
     */
    @Override
    public String getDetails() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        String formattedDate = dateAdmission.format(formatter);

        double salePrice = calculateSalePrice();
        double priceWithDiscount = applyDiscount(salePrice);

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
                 """.formatted(
                super.toString(), nameProduct, vegetableType, freshnessDays,
                type, idSupplier, formattedDate, price, salePrice, priceWithDiscount);
    }
}
