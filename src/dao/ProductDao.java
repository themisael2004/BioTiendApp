package dao;

import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ProductDao {

    // ? Lista privada para almacenar objetos de tipo "Product" en memoria
    private ArrayList<Product> productList = new ArrayList<>();

    // ? Método para agregar un producto a la lista
    public void addProduct(Product product) {
        productList.add(product);
    }

    // ? Método para obtener la lista de productos
    public List<Product> getProduct() {
        return productList;
    }
}
