package model.Supplier;

/**
 * Representa un proveedor local con un código regional.
 */
public class LocalSupplier extends Supplier {
    private String regionalCode;

    /**
     * Constructor con todos los datos del proveedor local.
     */
    public LocalSupplier(int idSupplier, String nameSupplier, String supplierProductType, String supplierDirection,
                         String supplierCity, String supplierCountry, String supplierContact, String regionalCode) {
        super(idSupplier, nameSupplier, supplierProductType, supplierDirection, supplierCity, supplierCountry, supplierContact);
        this.regionalCode = regionalCode;
    }

    public String getRegionalCode() {
        return regionalCode;
    }

    /**
     * Devuelve una descripción detallada del proveedor local.
     */
    @Override
    public String getDetails() {
        return """
                -------------------------------------
                        Detalle del Proveedor
                -------------------------------------
                %s
                Nombre proveedor: %s
                Tipo: Local
                País: %s
                Código de país: %s
                Ciudad: %s
                Producto suministrado: %s
                Contacto: %s
                """.formatted(super.toString(), nameSupplier, supplierCountry, regionalCode, supplierCity,
                supplierProductType, supplierContact);
    }
}