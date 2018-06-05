package pl.javastart.businesslogic;

import pl.javastart.model.Product;

import java.util.ArrayList;

public class PriceCalculator {

    private double totalPrice;

    public double getTotalPrice(ArrayList<Product> products) {
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public double getAveragePrice(ArrayList<Product> products) {
        return Math.round((totalPrice / products.size()) * 100) / 100.0;
    }
}
