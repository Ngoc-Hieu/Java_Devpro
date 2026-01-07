package vn_devpro_store.controller;

import vn_devpro_store.database.OrderDB;
import vn_devpro_store.dto.Cart;

public class OrderController {
    public static void display(){
        System.out.println("\n\t\tDANH SACH CAC GIO HANG");
        for(Cart cart : OrderDB.getOrders()){
            cart.display();
            System.out.println("---------------------------------------------------");
        }
    }
}
