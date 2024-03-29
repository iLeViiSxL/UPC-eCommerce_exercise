/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package cart;

import entity.Product;

/**
 *
 * @author juanluis
 */
public class ShoppingCartItem {
    
    public Product product;
    public int quantity;

    public ShoppingCartItem(Product product) {
       this.product = product;
       quantity = 1;
    }

    public Product getProduct() {
         return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return quantity*product.getPrice();
    }

}
