/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import cart.ShoppingCart;
import entity.Product;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryModel;
import model.ProductModel;
import web.ViewManager;

/**
 *
 * @author user
 */
public class neworderAction extends Action {

    CategoryModel categoryModel;
    ProductModel productModel;
    ShoppingCart shoppingCart;

    public neworderAction(CategoryModel categoryModel, ProductModel productModel, ShoppingCart shoppingCart) {
        this.categoryModel = categoryModel;
        this.productModel = productModel;
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void perform(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String categoryid = req.getParameter("categoryid");
        System.out.println("categoryid : " + categoryid);
        List<Product> productsList = productModel.retrieveAllWithCategorieId(Integer.valueOf(categoryid));
        req.setAttribute("products", productsList);
        req.setAttribute("categoryid", categoryid);
        req.setAttribute("categories", categoryModel.retrieveAll());
        Product product = productModel.find(Integer.valueOf(req.getParameter("productid")));
        shoppingCart.addItem(product);
        req.setAttribute("numberItem", String.valueOf(shoppingCart.getNumberOfItems()));
        ViewManager.nextView(req, resp, "/view/category.jsp");
        System.out.println("HELLO neworderAction");
    }

}
