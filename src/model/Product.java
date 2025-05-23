package model;

import java.time.LocalDateTime;

// ? Representación de la información de un producto con sus atriburtos
public abstract class Product {
    protected int idProduct;
    protected String nameProduct;
    protected String descriptionProduct;
    protected int idSupplier;
    protected LocalDateTime dateAdmission;
    protected double price;
    protected String type;
    protected static int contadorIdProduct = 1; // * Atributo estatico para generar IDs únicos

    public Product(String nameProduct, String descriptionProduct, int idSupplier,
            LocalDateTime dateAdmission, String type, double price) {
        this.idProduct = contadorIdProduct++; // *  se asigna automáticamente
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.idSupplier = idSupplier;
        this.dateAdmission = dateAdmission;
        this.type = type;
        this.price = price;
    }

    public abstract double calculatePrice();

    public abstract double applyDiscount();

    @Override
    public String toString() {
        return "Product [idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", descriptionProduct="
                + descriptionProduct + ", idSupplier=" + idSupplier + ", dateAdmission=" + dateAdmission + ", price="
                + price + ", type=" + type + "]";
    }

}
