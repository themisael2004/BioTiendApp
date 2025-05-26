package services;

import model.Supplier.Supplier;
import model.Supplier.LocalSupplier;
import model.Supplier.InternationalSupplier;

import java.util.ArrayList;
import java.util.List;

public class SupplierService {
    private List<Supplier> suppliers = new ArrayList<>();

    public void createLocalSupplier(int id, String name, String description, String direction, String city, String country, String contact, String regionalCode) {
        LocalSupplier local = new LocalSupplier(id, name, description, direction, city, country, contact, regionalCode);
        suppliers.add(local);
    }
}
