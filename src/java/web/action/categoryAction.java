/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import entity.Product;
import java.util.ArrayList;
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
public class categoryAction extends Action {

    CategoryModel categoryModel;
    ProductModel productModel;

    public categoryAction(CategoryModel categoryModel, ProductModel productModel) {
        this.categoryModel = categoryModel;
        this.productModel = productModel;
    }

    @Override
    public void perform(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String categoryid = req.getParameter("categoryid"); 
        req.setAttribute("categories", categoryModel.retrieveAll());
//        System.out.println("CATEGORYID : " + req.getParameter("categoryid"));
        List<Product> productsList = productModel.retrieveAllWithCategorieId(Integer.valueOf(categoryid));
//        for(Product p : productsList) System.out.println("Product : " + p.toString());
        req.setAttribute("products", productsList);
        req.setAttribute("categoryid", categoryid);
        ViewManager.nextView(req, resp, "/view/category.jsp");
        System.out.println("HELLO category.jsp");
    }

}
