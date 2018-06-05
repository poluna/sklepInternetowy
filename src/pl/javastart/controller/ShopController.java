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
import java.util.Arrays;
import java.util.List;

@WebServlet("/shop")
public class ShopController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String product1 = request.getParameter("product1");
        String product2 = request.getParameter("product2");
        String product3 = request.getParameter("product3");
        String product4 = request.getParameter("product4");
        String price1 = request.getParameter("price1");
        String price2 = request.getParameter("price2");
        String price3 = request.getParameter("price3");
        String price4 = request.getParameter("price4");

        if (product1.isEmpty() && product2.isEmpty() && product3.isEmpty() && product4.isEmpty()) {
            request.getRequestDispatcher("empty.jsp").forward(request, response);
        } else {
            List<String> products = Arrays.asList(product1, product2, product3, product4);
            List<String> prices = Arrays.asList(price1, price2, price3, price4);

            ArrayList<Product> productsList = new ArrayList<>();

            for (int i = 0; i < prices.size(); i++) {
                if (products.get(i) != null && products.get(i) != "" && prices.get(i) != null && products.get(i) != "") {
                    try {
                        double price = Double.parseDouble(prices.get(i));
                        Product product = new Product(products.get(i), price);
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

}
