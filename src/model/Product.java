package model;

import java.time.LocalDateTime;
//! Representación de la información de un producto con sus atriburtos
public class Product { 
    protected int idProduct; 
    protected String nameProduct;
    protected String descriptionProduct;
    protected int idCategory;
    protected int idSupplier;
    protected LocalDateTime dateAdmission;
    protected static int contadorIdProduct = 1; //?Atributo estatico para generar IDs únicos 

//!Constructor de la clase products
    public Product(int idProduct, String nameProduct, String descriptionProduct, int idCategory, int idSupplier) {
        this.idProduct = contadorIdProduct++; //?Asigna el ID automáticamente y lo incrementa para el sigueinte producto
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.idCategory = idCategory;
        this.idSupplier = idSupplier;
        this.dateAdmission = LocalDateTime.now(); //?Establece la fecha de admision de la creacion de objeto.
    }

    //! Controladores de acceso, getter and setter 
    public int getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public LocalDateTime getDateAdmission() {
        return dateAdmission;
    }

    //!Sobreescitura del metodo toString()
    @Override
    public String toString() {
        return "ID: " + idProduct + "| Producto: " + nameProduct + "| Descripcion: " + descriptionProduct
                + "| Categoria: " + idCategory + "| Proveedor: " + idSupplier + "| Creacion: " + dateAdmission;
    }
}
