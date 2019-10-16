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

    <h1>Products of meats</h1>
    
    <%
        String numberItem = (String) request.getAttribute("numberItem");
        if (numberItem != null) {

    %>

    <img src="img/cart.gif">
    <h3><%=numberItem%>: items</h3>
    <a href="viewcart.do">View cart</a>
    <br>
    <a href="checkout.do">Proceed to checkout</a>

    <%
        }
    %>

    <br>

    <table width="50%" border="1" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">

        <tr> <font size="2" face="Verdana">
        
        <th>

        <%
            List<Category> categories = (List<Category>) request.getAttribute("categories");

            for (Category category : categories) {

        %>

        <a href="category.do?categoryid=<%=category.getId()%>">
            <%=category.getName()%>
        </a>

        <% } %>

        </th>

        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            String categoryid = (String) request.getAttribute("categoryid");

            for (Product p : products) {

        %>


        <tr width="25%" valign="center" align="middle">
            <th><img src="img/products/<%=p.getName()%>.png"
                     alt="<%=p.getName()%>" ></th>
            <th><%=p.getName()%> <br />
                <%=p.getDescription()%>
            </th>
            <th><%=p.getPrice()%></th>
            <th>

                <form name="update" method="get" action="neworder.do">
                    <input type="hidden" value="<%=p.getId()%>" name="productid">
                    <input type="hidden" value="<%=categoryid%>" name="categoryid">
                    <br><input type="submit" name="Submit" value="Add to cart">
                </form>

            </th>
        </tr>


        <% }%>

        </font> </tr>

</table>

</body>