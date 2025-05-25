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

    public abstract void createSupplier();
    public abstract void readSupplier();

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
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