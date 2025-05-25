package services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Product.OrganicProduct;
import model.Product.Vegetables;
import model.Product.Fruit;

public class OrganicProductServices {
    private List<OrganicProduct> _organicProduct;
    private int nextId;

    public OrganicProductServices() {
        this._organicProduct = new ArrayList<>();
        this.nextId = 1;
    }

    // ?Metodo para crear un producto de tipo vegetal
    public void createVegetableProduct(String nameProduct, String descriptionProduct, int idSupplier,
            LocalDateTime dateAdmission, String type, double price, String vegetableType, int freshnessDays) {
        Vegetables newVegetables = new Vegetables(nextId++, nameProduct, descriptionProduct, idSupplier, dateAdmission,
                type, price, vegetableType, freshnessDays);
        _organicProduct.add(newVegetables);
    }
    //? Metodo para crear un producto de tipo  fruta
    public void createFruitProduct(String nameProduct, String descriptionProduct, int idSupplier,
                                   LocalDateTime dateAdmission, String type, double price, String fruitType, int freshnessDays) {
        Fruit newFruit = new Fruit(nextId++, nameProduct, descriptionProduct, idSupplier, dateAdmission,
                type, price, fruitType, freshnessDays);
        _organicProduct.add(newFruit);

    }


    // ?Metodo para obtener todo los productos
    public List<OrganicProduct> getAllOrganicProducts() {
        return new ArrayList<>(_organicProduct);
    }
}
