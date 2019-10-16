/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import cart.ShoppingCart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.ViewManager;

/**
 *
 * @author user
 */
public class checkoutAction extends Action {

    ShoppingCart shoppingCart;

    public checkoutAction(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void perform(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setAttribute("shoppingCart", shoppingCart);
        ViewManager.nextView(req, resp, "/view/checkout.jsp");
    }

}
