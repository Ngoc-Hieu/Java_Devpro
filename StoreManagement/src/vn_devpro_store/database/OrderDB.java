package vn_devpro_store.database;

import java.util.ArrayList;
import java.util.List;

import vn_devpro_store.dto.Cart;

public class OrderDB {
    public static List<Cart> getOrders() {
        return orders;
    }

    public static void setOrders(List<Cart> orders) {
        OrderDB.orders = orders;
    }

    private static List<Cart> orders = new ArrayList<>();
    
}
