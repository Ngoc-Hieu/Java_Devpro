package vn_devpro_store.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn_devpro_store.database.CustomerDB;
import vn_devpro_store.model.Customer;

public class CustomerController {
    static Scanner sc = new Scanner(System.in);

    public static void Menu() {
        do {
            System.out.println("\n\t\tQUAN LY DANH SACH KHACH HANG");
            System.out.println("Chon mot chuc nang quan ly");
            System.out.println("\t1. Xem danh sach khach hang");
            System.out.println("\t2. Them khach hang moi");
            System.out.println("\t3. Sua thong tin khach hang");
            System.out.println("\t4. Xoa thong tin khach hang");
            System.out.println("\t5. Sap xep danh sach");
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

    private static void display() {
        System.out.println("\n\t\tDANH SACH KHACH HANG");
        System.out.printf("%-5s %-12s %-30s%n", "ID", "Code", "Name");
        for (Customer customer : CustomerDB.getCustomers()) {
            customer.display();
        }
    }

    private static void create() {
        System.out.println("\n\t\tTHEM MOI KHACH HANG");
        System.out.printf("\tNhap ten khach hang: ");
        String name = sc.nextLine();
        if (name != null && !name.isBlank()) {
            Customer customer = new Customer();
            customer.setId(CustomerDB.getAutoId());
            customer.setCode("KH_" + (100 + customer.getId()));
            customer.setName(name);
            CustomerDB.getCustomers().add(customer);

            CustomerDB.setAutoId(CustomerDB.getAutoId() + 1);
            System.out.println("\tThem moi khach hang thanh cong");
        } else {
            System.out.println("\tTen khach hang khong duoc de trong");
        }
    }

    private static void update() {
        System.out.println("\n\t\tSUA THONG TIN KHACH HANG");
        System.out.printf("\tNhap ma khach hang: ");
        String code = sc.nextLine();
        int index = CustomerDB.findByCode(code);
        if (index == -1) {
            System.out.println("\tKhach hang chua ton tai");
            return;
        }
        CustomerDB.getCustomers().get(index).edit();
    }

    private static void remove() {
        System.out.println("\n\t\tXOA THONG TIN KHACH HANG");
        System.out.printf("\tNhap ma khach hang: ");
        String code = sc.nextLine();
        int index = CustomerDB.findByCode(code);
        if (index == -1) {
            System.out.println("\tKhach hang chua ton tai");
            return;
        }
        CustomerDB.getCustomers().remove(index);
        System.out.println("\tXoa khach hang thanh cong");
    }

    private static void sort() {
        Collections.sort(CustomerDB.getCustomers(), new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        System.out.println("\tSap xep danh sach khach hang theo ten thanh cong");
    }
}
