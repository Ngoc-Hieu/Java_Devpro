package vn_devpro_store.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vn_devpro_store.controller.CustomerController;
import vn_devpro_store.database.CustomerDB;
import vn_devpro_store.database.ProductDB;
import vn_devpro_store.model.Customer;
import vn_devpro_store.model.Product;

public class Cart {
    private int id;
    private int customerId;
    private List<CartItem> items = new ArrayList<>();
    public static int autoId = 1;

    public int totalQuality() {
        int total = 0;
        for (CartItem c : items) {
            total += c.getQuantity();
        }
        return total;
    }

    public BigDecimal grandTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem c : items) {
            total = total.add(c.totalPrice());
        }
        return total;
    }

    public void display() {
        System.out.println("\n\t\tGIO HANG CUA BAN");
        System.out.println("\tCo " + totalQuality() + " san pham trong gio hang");
        Customer customer = CustomerDB.findById(customerId);
        if (customer != null)
            System.out.println("\tTen khach hang: " + customer.getName());
        System.out.println("Danh sach san pham");
        System.out.printf("%-30s %8s %-15s %-15s%n",
                "Ten san pham", "So luong", "Don gia", "Thanh tien");
        for (CartItem c : items) {
            c.display();
        }
        System.out.printf("\tCong thanh tien: %,15.2f%n", grandTotal());
    }

    Scanner sc = new Scanner(System.in);

    public void create() {
        System.out.println("\n\tTHEM SAN PHAM MOI VAO GIO HANG");

        System.out.printf("\tXin nhap ten san pham: ");
        String name = sc.nextLine();

        Product product = ProductDB.findByName(name);
        if (product == null) {
            System.out.println("\tSan pham khong ton tai, chon san pham khac");
            return;
        }
        System.out.printf("\tNhap so luong can mua: ");
        int quantity = Integer.parseInt(sc.nextLine());
        if (quantity < 1) {
            System.out.println("\tSo luong khong hop le, xin nhap lai");
            return;
        }
        int index = indexOf(product.getId());
        if (index == -1) {

            CartItem item = new CartItem(product.getId(), quantity);
            items.add(item);
        } else {
            items.get(index).setQuantity(quantity);
            items.get(index).getQuantity();
        }
        System.out.println("\tThem san pham vao gio hang thanh cong");
    }

    public void update() {
        System.out.println("\n\tCAP NHAT SO LUONG SAN PHAM TRONG GIO HANG");
        System.out.printf("\tNhap ten san pham can cap nhat: ");
        String name = sc.nextLine();

        Product product = ProductDB.findByName(name);
        if (product == null) {
            System.out.println("\tSan pham khong ton tai");
            return;
        }

        int index = indexOf(product.getId());
        if (index == -1) {
            System.out.println("\tSan pham nay chua co trong gio hang");
            return;
        }

        System.out.printf("\tNhap so luong moi: ");
        int quantity = Integer.parseInt(sc.nextLine());
        if (quantity < 1) {
            System.out.println("\tSo luong khong hop le");
            return;
        }

        items.get(index).setQuantity(quantity);
        System.out.println("\tCap nhat so luong thanh cong");
    }

    public void delete() {
        System.out.println("\n\tXOA SAN PHAM KHOI GIO HANG");
        System.out.printf("\tNhap ten san pham can xoa: ");
        String name = sc.nextLine();

        Product product = ProductDB.findByName(name);
        if (product == null) {
            System.out.println("\tSan pham khong ton tai");
            return;
        }

        int index = indexOf(product.getId());
        if (index == -1) {
            System.out.println("\tSan pham nay khong co trong gio hang");
            return;
        }

        items.remove(index);
        System.out.println("\tXoa san pham khoi gio hang thanh cong");
    }
    public void checkOut(){
        System.out.println("\t\tTHANH TOAN GIO HANG");
        System.out.printf("\tNhap ten khach hang: ");
        String customerName = sc.nextLine();
        if(customerName == null || customerName.isBlank()){
            System.out.println("\tXin nhap ten khach hang hop le"); return;
        }
        Customer customer = CustomerDB.findByName(customerName);
        if(customer == null){
            customer = new Customer();
            customer.setId(CustomerDB.getAutoId());
            customer.setName(customerName);
            customer.setCode("KH_"+(100+customer.getId()));
            CustomerDB.getCustomers().add(customer);
            CustomerDB.setAutoId(CustomerDB.getAutoId()+1);

        }
        customerId = customer.getId();
        id = autoId++;

    }
    public int indexOf(int productId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProductId() == productId) {
                return i;
            }
        }
        return -1;
    }

    public Cart() {
    }

    public Cart(int id, int customerId, List<CartItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

}
