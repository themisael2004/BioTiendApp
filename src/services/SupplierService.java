package services;

import model.Supplier.Supplier;
import model.Supplier.LocalSupplier;
import model.Supplier.InternationalSupplier;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para gestionar la creación y consulta de proveedores.
 */
public class SupplierService {
    // Lista donde se almacenan todos los proveedores registrados
    private List<Supplier> suppliers;

    // ID autoincremental para asignar identificadores únicos a los proveedores
    private int nextId;

    /**
     * Constructor que inicializa la lista de proveedores y el contador de ID.
     */
    public SupplierService() {
        this.suppliers = new ArrayList<>();
        this.nextId = 1;
    }

    /**
     * Crea y registra un proveedor local en la lista.
     */
    public void createLocalSupplier(String name, String supplierProductType, String direction, String city,
            String country, String contact, String regionalCode) {
        LocalSupplier local = new LocalSupplier(nextId++, name, supplierProductType, direction, city, country, contact,
                regionalCode);
        suppliers.add(local);
    }

    /**
     * Crea y registra un proveedor internacional en la lista.
     */
    public void createInternacionalSupplier(String name, String supplierProductType, String direction, String city,
            String country, String contact, String isoCode) {
        InternationalSupplier intl = new InternationalSupplier(nextId++, name, supplierProductType, direction, city,
                country, contact, isoCode);
        suppliers.add(intl);
    }

    /**
     * Busca y devuelve un proveedor por su ID. Retorna null si no se encuentra.
     */
    public Supplier getSupplierById(int id) {
        for (Supplier o : suppliers) {
            if (o.getIdSupplier() == id) {
                return o;
            }
        }
        return null;
    }

    /**
     * Devuelve una copia de la lista de todos los proveedores registrados.
     */
    public List<Supplier> getALLSuppliers() {
        return new ArrayList<>(suppliers);
    }
}
