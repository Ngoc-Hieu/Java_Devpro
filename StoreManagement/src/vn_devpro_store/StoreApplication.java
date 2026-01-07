package vn_devpro_store;

import java.util.Scanner;

import vn_devpro_store.controller.CartController;
import vn_devpro_store.controller.CustomerController;
import vn_devpro_store.controller.OrderController;
import vn_devpro_store.controller.ProductController;
import vn_devpro_store.controller.ProviderController;

public class StoreApplication {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("\n\t\tCHUONG TRINH QUAN LY CUA HANG");
            System.out.println("Chon mot chuc nang quan ly");
            System.out.println("\t1.Danh cho nguoi quan tri");
            System.out.println("\t2.Danh cho khach hang");

            System.out.println("\t0.Thoat");

            System.out.printf("Lua chon cua ban: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    administrator();
                    break;
                case 2:
                    customer();
                    break;

                case 0:
                    System.out.println("Da thoat chuong trinh");
                    return;

                default:
                    System.out.println("Lua chon khong hop le, xin chon lai");
                    break;
            }

        } while (true);

    }

    private static void administrator() {
        do {
            System.out.println("\n\t\tCAP NHAT THONG TIN HE THONG");
            System.out.println("Chon mot chuc nang cap nhat");
            System.out.println("\t1.Cap nhat danh sach nha cung cap");
            System.out.println("\t2.Cap nhat thong tin san pham");
            System.out.println("\t3.Cap nhat thong tin khach hang");
            System.out.println("\t4.Xem danh sach cac gio hang cua khach hang");
            System.out.println("\t0.Quay lai");

            System.out.printf("Lua chon cua ban: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    ProviderController.Menu();
                    break;
                case 2:
                    ProductController.Menu();
                    break;
                case 3:
                    CustomerController.Menu();
                    break;
               case 4:
                    OrderController.display();
                    break;
                case 0:

                    return;

                default:
                    System.out.println("Lua chon khong hop le, xin chon lai");
                    break;
            }
        } while (true);

    }

    private static void customer() {
        CartController.Menu();
    }

}
