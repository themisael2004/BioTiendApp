package model.Product;

import java.time.LocalDateTime;

public class Fruit extends OrganicProduct {
    private String fruitType;
    private int freshnessDays;


    public Fruit(int idProduct, String nameProduct, String descriptionProduct, int idSupplier,
                 LocalDateTime dateAdmission, String type, double price, String fruitType, int freshnessDays) {
        super(idProduct, nameProduct, descriptionProduct, idSupplier, dateAdmission, type, price);
        this.fruitType = fruitType;
        this.freshnessDays = freshnessDays;
    }

    public double calculateSalePrice() {

        double salePrice = this.getPrice() * 1.15;
        if (freshnessDays >= 1 && freshnessDays <= 5) {
            salePrice *= 0.95;
        }
        return salePrice;
    }

    public double applyDiscount() {
        double currentPrice = this.calculateSalePrice();

        if (freshnessDays > 5) {
            return currentPrice * 0.70;
        }
        return currentPrice;

    }

    @Override
    public String getDetails() {
        return super.toString() +
                "| Tipo: Fruta" +
                "| Fruta: " + fruitType +
                "| Dias frescura: " + freshnessDays;
    }

    public String getFruitType() {
        return fruitType;
    }

    public int getFreshnessDays() {
        return freshnessDays;
    }
}
