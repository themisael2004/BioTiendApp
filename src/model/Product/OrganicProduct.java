package model.Product;

import java.time.LocalDateTime;

public abstract class OrganicProduct {
    protected static final double IVA = 1.12; /** Constante para aplicar IVA del 12% (1.00 + 0.12) */
    protected static final double PAY_85_PERCENT = 0.85; /** Constante para aplicar descuento del 15% (pagar 85%) */
    protected static final double PAY_70_PERCENT = 0.70; /** Constante para aplicar descuento del 30% (pagar 70%) */

    protected int idProduct;
    protected String nameProduct;
    protected int idSupplier;
    protected LocalDateTime dateAdmission;
    protected double price;
    protected String type;

    public OrganicProduct(int idProduct, String nameProduct, int idSupplier,
                          LocalDateTime dateAdmission, String type, double price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.idSupplier = idSupplier;
        this.dateAdmission = dateAdmission;
        this.type = type;
        this.price = price;
    }

    public abstract String getDetails();
    public abstract double calculateSalePrice();
    public abstract double applyDiscount(double currentPrice);

    public int getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public LocalDateTime getDateAdmission() {
        return dateAdmission;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ID Producto: " + idProduct;
    }

}
