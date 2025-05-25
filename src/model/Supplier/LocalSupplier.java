package model.Supplier;

public class LocalSupplier extends Supplier {
    private final String supplierType = "Local";

    public LocalSupplier (int idSupplier, String nameSupplier, String supplierDescription, String supplierDirection, String supplierCity, String supplierCountry, String supplierContact) {
        super(idSupplier, nameSupplier, supplierDescription, supplierDirection, supplierCity, supplierCountry, supplierContact);
    }

@Override
public void createSupplier() {
    System.out.println("Proveedor locarl creado");
}

@Override
public void readSupplier() {
    System.out.println("Datos del Proveedor Local: ");
    System.out.println(this.toString());
    System.out.println("Tipo: " + supplierType);
}
}