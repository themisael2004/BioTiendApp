package services;

import model.Supplier.Supplier;
import model.Supplier.LocalSupplier;
import model.Supplier.InternationalSupplier;

import java.util.ArrayList;
import java.util.List;

public class SupplierService {
     private List<Supplier> suppliers; 
    private int nextId; 

    public SupplierService() {
        this.suppliers = new ArrayList<>();
        this.nextId = 1; 
    }

    public void createLocalSupplier(String name, String supplierProductType, String direction, String city,
            String country, String contact, String regionalCode) {
        LocalSupplier local = new LocalSupplier(nextId++, name, supplierProductType, direction, city, country, contact, regionalCode);
        suppliers.add(local);
    }

    public void createInternacionalSupplier(String name, String supplierProductType, String city, String country,
            String contact, String isoCode) {
        InternationalSupplier intl = new InternationalSupplier(nextId++, name, supplierProductType, city, country, contact, contact,
                isoCode);
        suppliers.add(intl);
    }

    public List<Supplier> getALLSuppliers() {
       return new ArrayList<>(suppliers);
    }
}
