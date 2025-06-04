package model.Supplier;

public class InternationalSupplier extends Supplier {
    private String isoCountryCode;

    public InternationalSupplier(int idSupplier, String nameSupplier, String supplierDescription,
            String supplierDirection, String supplierCity, String supplierCountry, String supplierContact,
            String isoCountryCode) {
        super(idSupplier, nameSupplier, supplierDescription, supplierDirection, supplierCity, supplierCountry,
                supplierContact);
        this.isoCountryCode = isoCountryCode;
    }

    @Override
    public String getDetails() {
        return super.toString() +
                ", Tipo: Local" +
                ", Codigo regional: " + isoCountryCode;
    }

    public String getisoCountryCode() {
        return isoCountryCode;
    }

    public void SetisoCountryCode(String isoCountryCode) {
        this.isoCountryCode = isoCountryCode;
    }

}
