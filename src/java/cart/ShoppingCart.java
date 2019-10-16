package cart;

import entity.Product;
import java.text.NumberFormat;
import java.util.*;

/**
 *
 * @author juanluis
 */
public class ShoppingCart {

    public ArrayList<ShoppingCartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<ShoppingCartItem>();
    }

    public synchronized void addItem(Product product) {
        boolean changed = false;
        for (ShoppingCartItem s : items) {
            if (s.product.getId() == product.getId()) {
                s.quantity = s.quantity + 1;
                changed = true;
            }
        }
        if (changed == false) {
            items.add(new ShoppingCartItem(product));
        }
    }

    public synchronized void update(Product product, String quantity) {
        if (Integer.valueOf(quantity) > 0) {
            for (ShoppingCartItem s : items) {
                if (s.product.getId() == product.getId()) {
                    s.quantity = Integer.valueOf(quantity);
                }
            }
        } else {
            remove(product);
        }
    }

    public synchronized boolean remove(Product product) {
        for (ShoppingCartItem s : items) {
            if (s.product.getId() == product.getId()) {
                return items.remove(s);
            }
        }
        return false;
    }

    public synchronized int getNumberOfItems() {
        int totalItems = 0;
        for (ShoppingCartItem s : items) {
            totalItems = totalItems + s.quantity;
        }
        return totalItems;
    }

    public synchronized double getTotal() {
        double totalPrice = 0;
        for (ShoppingCartItem s : items) {
            totalPrice = totalPrice + (s.quantity * s.product.getPrice());
        }
        return totalPrice;
    }

    public synchronized void clear() {
        this.items = new ArrayList<ShoppingCartItem>();
    }

}
