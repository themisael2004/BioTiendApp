package model.Supplier;

public abstract class Supplier {
    protected int idSupplier;
    protected String nameSupplier;
    protected String supplierDescription;
    protected String supplierDirection;
    protected String supplierCity;
    protected String supplierCountry;
    protected String supplierContact;

    public Supplier(int idSupplier, String nameSupplier, String supplierDescription, String supplierDirection,
            String supplierCity, String supplierCountry, String supplierContact) {
        this.idSupplier = idSupplier;
        this.nameSupplier = nameSupplier;
        this.supplierDescription = supplierDescription;
        this.supplierDirection = supplierDirection;
        this.supplierCity = supplierCity;
        this.supplierCountry = supplierCountry;
        this.supplierContact = supplierContact;
    }

    public abstract String getDetails();

    public int getIdSupplier() {
        return idSupplier;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public String getSupplierDirection() {
        return supplierDirection;
    }

    public String getSupplierCity() {
        return supplierCity;
    }

    public String getSupplierCountry() {
        return supplierCountry;
    }

    public String getSupplierContact() {
        return supplierContact;
    }

    @Override
    public String toString() {
        return "ID: " + idSupplier +
                ", Nombre: " + nameSupplier +
                ", Ciudad: " + supplierCity +
                ", País: " + supplierCountry +
                ", Contacto: " + supplierContact;
    }
}