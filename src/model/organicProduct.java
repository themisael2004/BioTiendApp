package model;

import java.time.LocalDateTime;

public abstract class organicProduct {
    protected int idProduct;
    protected String nameProduct;
    protected String descriptionProduct;
    protected int idSupplier;
    protected LocalDateTime dateAdmission;
    protected double price;
    protected String type;

    public organicProduct(int idProduct, String nameProduct, String descriptionProduct, int idSupplier,
            LocalDateTime dateAdmission, String type, double price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.idSupplier = idSupplier;
        this.dateAdmission = dateAdmission;
        this.type = type;
        this.price = price;
    }

    public abstract String getDetails();


    public int getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
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
        return "Product [idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", descriptionProduct="
                + descriptionProduct + ", idSupplier=" + idSupplier + ", dateAdmission=" + dateAdmission + ", price="
                + price + ", type=" + type + "]";
    }

}
