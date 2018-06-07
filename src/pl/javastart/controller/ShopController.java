package pl.javastart.controller;


import pl.javastart.businesslogic.PriceCalculator;
import pl.javastart.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/shop")
public class ShopController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        ArrayList<Product> productsList = new ArrayList<>();

        for (int i = 1; i < 5; i++) {
            String productStr = request.getParameter("product" + i);
            String priceStr = request.getParameter("price" + i);
            if (!productStr.equals("")) {
                try {
                    double price = Double.parseDouble(priceStr);
                    Product product = new Product(productStr, price);
                    productsList.add(product);
                } catch (NumberFormatException e) {
                    e.getMessage();
                }
            }
        }
        if (productsList.isEmpty()) {
            request.getRequestDispatcher("empty.jsp").forward(request, response);
        }


        PriceCalculator priceCalculator = new PriceCalculator();
        double totalPrice = priceCalculator.getTotalPrice(productsList);
        double averagePrice = priceCalculator.getAveragePrice(productsList);

        request.setAttribute("productsList", productsList);
        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("averagePrice", averagePrice);

        request.getRequestDispatcher("buy.jsp").forward(request, response);

    }

}
