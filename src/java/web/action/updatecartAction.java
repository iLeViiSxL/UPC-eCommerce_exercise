/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import cart.ShoppingCart;
import entity.Product;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductModel;
import web.ViewManager;

/**
 *
 * @author user
 */
public class updatecartAction extends Action {

    ShoppingCart shoppingCart;
    ProductModel productModel;

    public updatecartAction(ProductModel productModel, ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        this.productModel = productModel;
    }

    @Override
    public void perform(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        System.out.println("productid : " + req.getParameter("productid"));
        System.out.println("quantity : " + req.getParameter("quantity"));
        Product product = productModel.find(Integer.valueOf(req.getParameter("productid")));
        shoppingCart.update(product,req.getParameter("quantity"));
        req.setAttribute("shoppingCart", shoppingCart);
        ViewManager.nextView(req, resp, "/view/cart.jsp");
        System.out.println("HELLO neworderAction");
    }

}
