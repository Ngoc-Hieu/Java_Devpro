package vn_devpro_store.controller;

import java.util.Scanner;

import vn_devpro_store.database.OrderDB;
import vn_devpro_store.dto.Cart;

public class CartController {
    static Scanner sc = new Scanner(System.in);
    public static void Menu() {
        Cart cart = new Cart();
        do {
            System.out.println("\n\t\tQUAN LY GIO HANG");
            System.out.println("Chon mot chuc nang quan ly");
            System.out.println("\t1. Xem danh sach san pham");
            System.out.println("\t2. Xem thong tin gio hang");
            System.out.println("\t3. Sua thong tin san pham gio hang");
            System.out.println("\t4. Sua thong tin san pham gio hang");
            System.out.println("\t5. Thanh toan san pham gio hang");
            System.out.println("\t6. Xoa san pham gio hang");
            System.out.println("\t7. Xoa toan bo san pham");
            System.out.println("\t0. Quay lai");

            System.out.printf("Lua chon cua ban: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    ProductController.display();
                    break;
                case 2:
                    cart.display();
                    break;
                case 3:
                    //update();
                    cart.create();
                    break;
                case 4:
                    //remove();
                    cart.update();
                    break;
                case 5:
                    //sort();
                    cart.checkOut();
                    cart.display();
                    OrderDB.getOrders().add(cart);
                    cart = new Cart();
                    break;
                case 6:
                    //sort();
                    cart.delete();
                    break;
                case 7:
                    //sort();
                    cart = new Cart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le, xin chon lai");
                    break;
            }
        } while (true);
    }
}
