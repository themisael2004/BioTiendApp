package model.Supplier;

/**
 * Clase base abstracta para representar un proveedor genérico.
 */
public abstract class Supplier {
    // Atributos protegidos: accesibles desde clases hijas

    protected int idSupplier;
    protected String nameSupplier;
    protected String supplierProductType;
    protected String supplierDirection;
    protected String supplierCity;
    protected String supplierCountry;
    protected String supplierContact;

    /**
     * Constructor completo del proveedor.
     */
    public Supplier(int idSupplier, String nameSupplier, String supplierProductType, String supplierDirection,
            String supplierCity, String supplierCountry, String supplierContact) {
        this.idSupplier = idSupplier;
        this.nameSupplier = nameSupplier;
        this.supplierProductType = supplierProductType;
        this.supplierDirection = supplierDirection;
        this.supplierCity = supplierCity;
        this.supplierCountry = supplierCountry;
        this.supplierContact = supplierContact;
    }

    /**
     * Método que deben implementar las subclases para mostrar detalles del
     * proveedor.
     */
    public abstract String getDetails();

    // Getters
    public int getIdSupplier() {
        return idSupplier;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public String getSupplierProductType() {
        return supplierProductType;
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

    /**
     * Representación básica del proveedor.
     */
    @Override
    public String toString() {
        return "ID proveedor: " + idSupplier;
    }
}
