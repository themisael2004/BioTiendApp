package model.Supplier;

public class InternationalSupplier extends Supplier {
    private String isoCountryCode;

    public InternationalSupplier(int idSupplier, String nameSupplier, String supplierProductType,
            String supplierDirection, String supplierCity, String supplierCountry, String supplierContact,
            String isoCountryCode) {
        super(idSupplier, nameSupplier, supplierProductType, supplierDirection, supplierCity, supplierCountry,
                supplierContact);
        this.isoCountryCode = isoCountryCode;
    }

    public String getisoCountryCode() {
        return isoCountryCode;
    }

    public void SetisoCountryCode(String isoCountryCode) {
        this.isoCountryCode = isoCountryCode;
    }

    @Override
    public String getDetails() {
        return """
                -------------------------------------
                        Detalle del Proveedor
                -------------------------------------
                %s
                Nombre proveedor: %s
                Tipo: Internacional
                Pais: %s
                Codigo de pais: %s
                Ciudad: %s
                Producto suministrado: %s
                Contacto: %s
                """.formatted(super.toString(), nameSupplier, supplierCountry, isoCountryCode, supplierCity,
                supplierProductType, supplierContact);
    }
}
