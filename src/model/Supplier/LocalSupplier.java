package model.Supplier;

public class LocalSupplier extends Supplier {
    private String regionalCode;

    public LocalSupplier(int idSupplier, String nameSupplier, String supplierDescription, String supplierDirection,
            String supplierCity, String supplierCountry, String supplierContact, String regionalCode) {
        super(idSupplier, nameSupplier, supplierDescription, supplierDirection, supplierCity, supplierCountry,
                supplierContact);
        this.regionalCode = regionalCode;
    }

    @Override
    public String getDetails() {
        return super.toString() +
                ", Tipo: Local" +
                ", Codigo regional: " + regionalCode;
    }

    public String getRegionalCode() {
        return regionalCode;
    }

    public void setRegionalCode(String regionalCode) {
        this.regionalCode = regionalCode;
    }
}