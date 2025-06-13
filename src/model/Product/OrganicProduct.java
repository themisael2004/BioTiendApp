package model.Product;

import java.time.LocalDateTime;

/**
 * Clase abstracta base para productos orgánicos como frutas y verduras.
 * Define atributos y métodos comunes, así como constantes de IVA y descuentos.
 */
public abstract class OrganicProduct {
    // Constante para el IVA del 12%
    protected static final double IVA = 1.12;

    // Constantes de descuento (se paga el 85% o 70% del precio)
    protected static final double PAY_85_PERCENT = 0.85;
    protected static final double PAY_70_PERCENT = 0.70;

    // Atributos comunes de cualquier producto orgánico
    protected int idProduct;
    protected String nameProduct;
    protected int idSupplier;
    protected LocalDateTime dateAdmission;
    protected double price;
    protected String type;

    /**
     * Constructor de la clase base
     */
    public OrganicProduct(int idProduct, String nameProduct, int idSupplier,
            LocalDateTime dateAdmission, String type, double price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.idSupplier = idSupplier;
        this.dateAdmission = dateAdmission;
        this.type = type;
        this.price = price;
    }

    // Métodos abstractos que deben implementar las subclases
    public abstract String getDetails();

    public abstract double calculateSalePrice();

    public abstract double applyDiscount(double currentPrice);

    // Getters 
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

    // Representación básica del objeto
    @Override
    public String toString() {
        return "ID Producto: " + idProduct;
    }
}
