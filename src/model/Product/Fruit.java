package model.Product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un producto de tipo fruta
 */
public class Fruit extends OrganicProduct {

    // Tipo de fruta (Tropicales, Cítrico, Drupas)
    private String fruitType;

    // Días desde la admisión, usados para calcular descuentos
    private int freshnessDays;

    public Fruit(int idProduct, String nameProduct, int idSupplier,
                 LocalDateTime dateAdmission, String type, double price,
                 String fruitType, int freshnessDays) {
        super(idProduct, nameProduct, idSupplier, dateAdmission, type, price);
        this.fruitType = fruitType;
        this.freshnessDays = freshnessDays;
    }

    /**
     * Calcula el precio de venta con incremento según el tipo de fruta y aplica IVA
     */
    @Override
    public double calculateSalePrice() {
        double incrementPercentage = 0.0;

        if (fruitType.equalsIgnoreCase("Tropicales")) {
            incrementPercentage = 0.10;
        } else if (fruitType.equalsIgnoreCase("Citrico")) {
            incrementPercentage = 0.05;
        } else if (fruitType.equalsIgnoreCase("Drupas")) {
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

    public String getFruitType() { return fruitType; }
    public int getFreshnessDays() { return freshnessDays; }

    /**
     * Muestra todos los detalles relevantes de la fruta, incluyendo precios y descuentos
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
                 Tipo de fruta: %s
                 Categoría: Fruta
                 Días de frescura: %d
                 Tipo: %s
                 Proveedor ID: %d
                 Fecha de admisión: %s
                 Precio base: %.2f
                 Precio de venta (con IVA): %.2f
                 Precio con descuento (con IVA): %.2f
                 """.formatted(
                super.toString(), nameProduct, fruitType, freshnessDays,
                type, idSupplier, formattedDate, price, salePrice, priceWithDiscount
        );
    }
}
