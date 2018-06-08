<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="pl.javastart.model.Product" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body style="margin:10px">

<h1>Podsumowanie Twoich zakupów:</h1>
<h2>Zakupione produkty</h2>


<table class="table table-striped">

    <thead>
    <tr class="bg-primary">
        <th>#</th>
        <th>Nazwa</th>
        <th>Cena</th>
    </tr>
    </thead>

    <c:forEach var="product" items="${requestScope.productsList}" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
        </tr>
    </c:forEach>

</table>


<h2><c:out value="Suma: ${requestScope.totalPrice}zł"/></h2>
<h2><c:out value="Średnia cena produktu: ${requestScope.averagePrice}zł"/></h2>

<%--<%--%>
<%--List<Product> products = (List<Product>) request.getAttribute("productsList");--%>
<%--int counter = 1;--%>
<%--double totalPrice = (double) request.getAttribute("totalPrice");--%>
<%--double averagePrice = (double) request.getAttribute("averagePrice");--%>
<%--%>--%>

<%--<table class="table table-striped">--%>


<%--<thead>--%>
<%--<tr class="bg-primary">--%>
<%--<th>#</th>--%>
<%--<th>Nazwa</th>--%>
<%--<th>Cena</th>--%>
<%--</tr>--%>
<%--</thead>--%>

<%--<%--%>
<%--for (Product product : products) {--%>
<%--%>--%>
<%--<tr>--%>
<%--<td><%out.print(counter++);%></td>--%>
<%--<td><%out.print(product.getName());%></td>--%>
<%--<td><%out.print(product.getPrice());%>zł</td>--%>
<%--</tr>--%>

<%--<% } %>--%>

<%--</table>--%>

<%--<h2>Suma: <%out.print(totalPrice);%>zł</h2>--%>
<%--<h2>Średnia cena produktu: <%out.print(averagePrice);%>zł</h2>--%>


</body>
</html>




