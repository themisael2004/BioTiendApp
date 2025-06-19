package services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import model.Product.OrganicProduct;
import model.Product.Vegetable;
import model.Product.Fruit;

public class OrganicStoreServices {
    // Atributos de la clase
    // Lista que almacena todos los productos orgánicos en el inventario */
    private List<OrganicProduct> inventory;
    // Contador para generar IDs únicos y secuenciales para nuevos productos */
    private int nextId;

    /**
     * Constructor que inicializa el servicio de la tienda orgánica.
     * Crea una lista vacía para el inventario y establece el primer ID en 1.
     */
    public OrganicStoreServices() {
        inventory = new ArrayList<>();
        nextId = 1; // Inicia la secuencia de IDs desde 1
    }

    // ?Metodo para crear un producto
    public void createProduct(String typeProduct, String nameProduct, int idSupplier,
            LocalDateTime dateAdmission, String type, double price, String specificType, int freshnessDays) {

        // Crear vegetal si el tipo corresponde
        if (typeProduct.equalsIgnoreCase("Vegetal")) {
            Vegetable newVegetable = new Vegetable(nextId++, nameProduct, idSupplier,
                    dateAdmission,
                    type, price, specificType, freshnessDays);
            inventory.add(newVegetable);
            System.out.println("Producto vegetal creado con ID " + newVegetable.getIdProduct());

            // Crear fruta si el tipo corresponde
        } else if (typeProduct.equalsIgnoreCase("Fruta")) {
            Fruit newFruit = new Fruit(nextId++, nameProduct, idSupplier, dateAdmission,
                    type, price, specificType, freshnessDays);
            inventory.add(newFruit);
            System.out.println("Producto fruta creado con ID " + newFruit.getIdProduct());

            // Manejar tipos de producto no válidos
        } else {
            System.out.println("Tipo de producto no válido: " + typeProduct);
        }
    }

    // Metodo para obtener todo los productos
    public List<OrganicProduct> getAllOrganicProducts() {
        // Retorna una nueva lista para evitar modificaciones externas del inventario
        return new ArrayList<>(inventory);
    }

    // Metodo para buscar un producto por su ID
    public OrganicProduct getOrganicProductById(int id) {
        // Búsqueda lineal por ID
        for (OrganicProduct o : inventory) {
            if (o.getIdProduct() == id) {
                return o; // Producto encontrado
            }
        }
        return null; // Producto no encontrado
    }

    // Método para eliminar un producto por su nombre
    public OrganicProduct deleteOrganicProduct(String name) {
        // Usar Iterator para eliminación segura durante iteración
        Iterator<OrganicProduct> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            OrganicProduct p = iterator.next();
            // Comparación insensible a mayúsculas/minúsculas
            if (p.getNameProduct().equalsIgnoreCase(name)) {
                iterator.remove(); // Eliminación segura
                return p; // Retornar el producto eliminado
            }

        }
        return null; // Producto no encontrado
    }

}
