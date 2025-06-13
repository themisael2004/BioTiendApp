package model.Supplier;

/**
 * Representa un proveedor internacional con un código ISO de país.
 */
public class InternationalSupplier extends Supplier {
    private String isoCountryCode;

    /**
     * Constructor con todos los datos del proveedor internacional.
     */
    public InternationalSupplier(int idSupplier, String nameSupplier, String supplierProductType,
                                 String supplierDirection, String supplierCity, String supplierCountry,
                                 String supplierContact, String isoCountryCode) {
        super(idSupplier, nameSupplier, supplierProductType, supplierDirection, supplierCity, supplierCountry, supplierContact);
        this.isoCountryCode = isoCountryCode;
    }

    public String getisoCountryCode() {
        return isoCountryCode;
    }

    public void setIsoCountryCode(String isoCountryCode) {
        this.isoCountryCode = isoCountryCode;
    }

    /**
     * Devuelve una descripción detallada del proveedor internacional.
     */
    @Override
    public String getDetails() {
        return """
                -------------------------------------
                        Detalle del Proveedor
                -------------------------------------
                %s
                Nombre proveedor: %s
                Tipo: Internacional
                País: %s
                Código de país: %s
                Ciudad: %s
                Producto suministrado: %s
                Contacto: %s
                """.formatted(super.toString(), nameSupplier, supplierCountry, isoCountryCode, supplierCity,
                supplierProductType, supplierContact);
    
    }
}