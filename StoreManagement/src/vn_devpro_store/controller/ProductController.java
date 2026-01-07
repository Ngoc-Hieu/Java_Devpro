package vn_devpro_store.controller;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn_devpro_store.database.ProductDB;
import vn_devpro_store.database.ProviderDB;
import vn_devpro_store.model.Product;
import vn_devpro_store.model.Provider;

public class ProductController {
    static Scanner sc = new Scanner(System.in);

    public static void Menu() {
        do {
            System.out.println("\n\t\tQUAN LY DANH SACH SAN PHAM");
            System.out.println("Chon mot chuc nang quan ly");
            System.out.println("\t1. Xem danh sach san pham");
            System.out.println("\t2. Them san pham moi");
            System.out.println("\t3. Sua thong tin san pham");
            System.out.println("\t4. Xoa san pham");
            System.out.println("\t5. Sap xep danh sach theo ten");
            System.out.println("\t0. Quay lai");

            System.out.printf("Lua chon cua ban: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    display();
                    break;
                case 2:
                    create();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    sort();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le, xin chon lai");
                    break;
            }
        } while (true);
    }

    public static void display() {
        System.out.println("\n\t\tDANH SACH SAN PHAM");
        System.out.printf("%-5s %-12s %-30s %-30s %-15s%n",
                "ID", "Code", "Provider", "Name", "Price");
        for (Product product : ProductDB.getProducts()) {
            product.display();
        }
    }

    private static void create() {
        System.out.println("\n\t\tTHEM MOI SAN PHAM");
        System.out.printf("\tNhap ten nha cung cap: ");
        String ProviderName = sc.nextLine();
        Provider provider = ProviderDB.findByName(ProviderName);
        if(provider == null){
            System.out.println("\tNha cung cap chua ton tai, xin them moi");
            return;
        }
        System.out.printf("\tNhap ten san pham: ");
        String name = sc.nextLine();
        if(name == null || name.isBlank()){
            System.out.println("Ten san pham khong duoc de trong");
            return;
        }
        System.out.printf("\tNhap gia ban san pham: ");
        double price = Double.parseDouble(sc.nextLine());
        if(price < 0){
            System.out.println("\tGia ban khong duoc la so am");return;
        }
        Product product = new Product();
        product.setId(ProductDB.getAutoId());
        product.setProviderId(provider.getId());
        product.setCode("SP_"+(100+product.getId()));
        product.setName(name);
        product.setPrice(new BigDecimal(price));

        ProductDB.getProducts().add(product);
        ProductDB.setAutoId(ProductDB.getAutoId()+1);
        System.out.println("\tThem moi san pham thanh cong");
    }

    private static void update() {
        System.out.println("\n\t\tSUA THONG TIN SAN PHAM");
        System.out.printf("\tNhap ma san pham: ");
        String code = sc.nextLine();
        int index = ProductDB.findByCode(code);
        if (index == -1) {
            System.out.println("\tSan pham khong ton tai");
            return;
        }
        ProductDB.getProducts().get(index).edit();
    }

    private static void remove() {
        System.out.println("\n\t\tXOA SAN PHAM");
        System.out.printf("\tNhap ma san pham: ");
        String code = sc.nextLine();
        int index = ProductDB.findByCode(code);
        if (index == -1) {
            System.out.println("\tSan pham khong ton tai");
            return;
        }
        ProductDB.getProducts().remove(index);
        System.out.println("\tXoa san pham thanh cong");
    }

    private static void sort() {
        Collections.sort(ProductDB.getProducts(), new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        System.out.println("\tSap xep danh sach san pham theo ten thanh cong");
    }
}
