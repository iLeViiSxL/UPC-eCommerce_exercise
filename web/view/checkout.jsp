<%-- 
    Document   : checkout.jsp
    Created on : 16 oct. 2019, 14:22:31
    Author     : user
--%>

<%@page import="cart.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Proceed to checkout</h1>
        <br>

        <%
            ShoppingCart shoppingCart = (ShoppingCart) request.getAttribute("shoppingCart");
        %>

        <form action="https://www.paypal.com/cgi-bin/webscr" method="post">
            <input type="hidden" name="cmd" value="_cart">
            <input type="hidden" name="upload" value="1">
            <input type="hidden" name="business" value="jgestin@ensssat.fr">
            <input type="hidden" name="item_name" value="ShoppingCart">
            <input type="hidden" name="currency_code" value="EUR">
            <input type="hidden" name="amount" value="<%=shoppingCart.getTotal()%>">
            <input type="hidden" name="quantity" value="<%=shoppingCart.getNumberOfItems()%>">
            <%
                for (int i = 0; i < shoppingCart.items.size(); i++) {
            %>
            <input type="hidden" name="item_name_<%=i + 1%>" value="<%=shoppingCart.items.get(i).getQuantity()%> x <%=shoppingCart.items.get(i).getProduct().getName()%>">
            <input type="hidden" name="amount_<%=i + 1%>" value="<%=shoppingCart.items.get(i).getTotal()%>">
            <%
                }
            %>
            <input type="image" src="http://www.paypal.com/fr_XC/i/btn/x-click-but01.gif" name="submit" alt="Make payments with PayPal - it's fast, free and secure!">
        </form>

    </body>
</html>
