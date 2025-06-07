package model.Supplier;

public class LocalSupplier extends Supplier {
    private String regionalCode;

    public LocalSupplier(int idSupplier, String nameSupplier, String supplierProductType, String supplierDirection,
            String supplierCity, String supplierCountry, String supplierContact, String regionalCode) {
        super(idSupplier, nameSupplier, supplierProductType, supplierDirection, supplierCity, supplierCountry,
                supplierContact);
        this.regionalCode = regionalCode;
    }

    public String getRegionalCode() {
        return regionalCode;
    }

    @Override
    public String getDetails() {
        return """
                -------------------------------------
                        Detalle del Proveedor
                -------------------------------------
                %s
                Nombre proveedor: %s
                Tipo: Local
                Pais: %s
                Codigo de pais: %s
                Ciudad: %s
                Producto suministrado: %s
                Contacto: %s
                """.formatted(super.toString(), nameSupplier, supplierCountry, regionalCode, supplierCity,
                supplierProductType, supplierContact);
    }
}