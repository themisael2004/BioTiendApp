package model.Supplier;

public abstract class Supplier {
    protected int idSupplier;
    protected String nameSupplier;
    protected String supplierDescription;
    protected String supplierDirection;
    protected String supplierCity;
    protected String supplierCountry;
    protected String supplierContact;

    public Supplier (int idSupplier, String nameSupplier, String supplierDescription, String supplierDirection, String supplierCity, String supplierCountry, String supplierContact) {
        this.idSupplier = idSupplier;
        this.nameSupplier = nameSupplier;
        this.supplierDescription = supplierDescription;
        this.supplierDirection = supplierDirection;
        this.supplierCity = supplierCity;
        this.supplierCountry = supplierCountry;
        this.supplierContact = supplierContact;
    }

    public abstract String getDetails();

    public int getIdSupplier() { return idSupplier; }
    public void setIdSupplier(int idSupplier) { this.idSupplier = idSupplier; }

    public String getNameSupplier() { return nameSupplier; }
    public void setNameSupplier(String nameSupplier) { this.nameSupplier = nameSupplier; }   
    
    public String getSupplierDirection() { return supplierDirection; }
    public void setSupplierDirection(String supplierDirection) { this.supplierDirection = supplierDirection; }

    public String getSupplierCity() { return supplierCity; }
    public void setSupplierCity(String supplierCity) { this.supplierCity = supplierCity; }
    
    public String getSupplierCountry() { return supplierCountry; }
    public void setSupplierCountry(String supplierCountry) { this.supplierCountry = supplierCountry; }

    public String getSupplierContact() { return supplierContact; }
    public void setSupplierContact(String supplierContact) { this.supplierContact = supplierContact; }

    @Override
    public String toString() {
        return "ID: " + idSupplier +
                ", Nombre: " + nameSupplier +
                ", Ciudad: " + supplierCity +
                ", País: " + supplierCountry +
                ", Contacto: " + supplierContact;
    }
}