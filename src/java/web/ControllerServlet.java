package web;

import cart.ShoppingCart;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import model.CategoryModel;
import model.ProductModel;
import web.action.*;

public class ControllerServlet extends HttpServlet {

    private HashMap actionMap;

    @Override
    public void init() throws ServletException {

        actionMap = new HashMap();
        ServletContext context = getServletContext();

        actionMap.put("/init.do", new initAction((CategoryModel) context.getAttribute("categoryModel")));
        actionMap.put("/category.do", new categoryAction((CategoryModel) context.getAttribute("categoryModel"), (ProductModel) context.getAttribute("productModel")));
        actionMap.put("/neworder.do", new neworderAction((CategoryModel) context.getAttribute("categoryModel"), (ProductModel) context.getAttribute("productModel"), (ShoppingCart) context.getAttribute("shoppingCart")));
        actionMap.put("/viewcart.do", new viewcartAction((ShoppingCart) context.getAttribute("shoppingCart")));
        actionMap.put("/updatecart.do", new updatecartAction((ProductModel) context.getAttribute("productModel"), (ShoppingCart) context.getAttribute("shoppingCart")));
        actionMap.put("/clearcart.do", new clearcartAction((ShoppingCart) context.getAttribute("shoppingCart")));
        actionMap.put("/checkout.do", new checkoutAction((ShoppingCart) context.getAttribute("shoppingCart")));

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String op = req.getServletPath();
        Action action = (Action) actionMap.get(op);

        try {
            action.perform(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
            if (dispatcher != null) {
                dispatcher.forward(req, resp);
            }
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        doPost(req, resp);
    }
}
