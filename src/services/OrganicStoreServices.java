package services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Product.OrganicProduct;
import model.Product.Vegetables;
import model.Product.Fruit;

public class OrganicStoreServices {
    private List<OrganicProduct> inventory;
    private int nextId;

    public OrganicStoreServices() {
        inventory = new ArrayList<>();
        nextId = 1;
    }

    // ?Metodo para crear un producto
    public void createProduct(String typeProduct, String nameProduct, String descriptionProduct, int idSupplier,
            LocalDateTime dateAdmission, String type, double price, String specificType, int freshnessDays) {

        if (typeProduct.equalsIgnoreCase("Vegetal")) {
            Vegetables newVegetable = new Vegetables(nextId++, nameProduct, descriptionProduct, idSupplier,
                    dateAdmission,
                    type, price, specificType, freshnessDays);
            inventory.add(newVegetable);
            System.out.println("Producto vegetal creado con ID " + newVegetable.getIdProduct());

        } else if (typeProduct.equalsIgnoreCase("Fruta")) {
            Fruit newFruit = new Fruit(nextId++, nameProduct, descriptionProduct, idSupplier, dateAdmission,
                    type, price, specificType, freshnessDays);
            inventory.add(newFruit);
            System.out.println("Producto fruta creado con ID " + newFruit.getIdProduct());

        } else {
            System.out.println("Tipo de producto no válido: " + typeProduct);
        }
    }

    // ?Metodo para obtener todo los productos
    public List<OrganicProduct> getAllOrganicProducts() {
        return new ArrayList<>(inventory);
    }

    // ? Metodo para buscar un producto por su ID
    public OrganicProduct getOrganicProductById(int id) {
        for (OrganicProduct o : inventory) {
            if (o.getIdProduct() == id) {
                return o;
            }
        }
        return null;
    }

    // ? Método para eliminar un producto por su nombre
    public OrganicProduct deleteOrganicProduct(String name) {
        for (OrganicProduct n : inventory) {
            if (n.getNameProduct().equalsIgnoreCase(name)) {
                inventory.remove(n);
                return n;
            }
        }
        return null;
    }

}
