<%@page import="cart.ShoppingCartItem"%>
<%@page import="cart.ShoppingCart"%>
<%@page import="entity.Product"%>
<%@ page import="entity.Category" %>
<%@ page import="java.util.List" %>

<head>
    <meta http-equiv="Expires" CONTENT="0">
    <meta http-equiv="Cache-Control" CONTENT="no-cache">
    <meta http-equiv="Pragma" CONTENT="no-cache">
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>eCommerce Sample</title>
</head>

<body>


    <%
        ShoppingCart shoppingCart = (ShoppingCart) request.getAttribute("shoppingCart");
    %>

    <img src="img/cart.gif">
    <h3><%=shoppingCart.getNumberOfItems()%>: items</h3>

    <h2>Your shopping cart contains <%=shoppingCart.getNumberOfItems()%> items</h2>


    <a href="clearcart.do">Clear cart</a>
    <br><a href="init.do">Continue shopping</a>
    <br>
    <a href="checkout.do">Proceed to checkout</a><br>

    <br>

    <table width="50%" border="1" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">

        <tr> <font size="2" face="Verdana">

        <%
            for (ShoppingCartItem i : shoppingCart.items) {

        %>


        <tr width="25%" valign="center" align="middle">
            <th><img src="img/products/<%=i.product.getName()%>.png"
                     alt="<%=i.product.getName()%>" ></th>
            <th><%=i.product.getName()%> <br />
                <%=i.product.getDescription()%>
            </th>
            <th><%=i.product.getPrice()%></th>
            <th>

                <form name="update" method="get" action="updatecart.do">
                    <input type="text" value="<%=i.quantity%>" name="quantity">
                    <input type="hidden" value="<%=i.product.getId()%>" name="productid">
                    <br><input type="submit" name="Submit">
                </form>

            </th>
        </tr>


        <% }%>
        </font> </tr>

</table>


<h2>Total amount : <%=shoppingCart.getTotal()%></h2>


</body>