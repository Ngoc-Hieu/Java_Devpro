package NgocHieu;

import java.util.Scanner;

public class Order {
    private String code;
    private Customer customer;
    private Product[] products;


    public Order() {
        this.code = "";
        this.customer = null;
        this.products = new Product[0]; // tránh null
    }

    public Order(String code, Customer customer, Product[] products) {
        this.code = code;
        this.customer = customer;
        this.products = (products != null) ? products : new Product[0];
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product[] getProducts() {
        return products;
    }
    public void setProducts(Product[] products) {
        this.products = (products != null) ? products : new Product[0];
    }

    public void display() {
        System.out.println("\n\t\tDON DAT HANG");
        System.out.println("\tMa don hang: " + this.code);

        if (customer != null) {
            customer.display();
        } else {
            System.out.println("\tKhach hang: [Chua co thong tin]");
        }

        System.out.println("Danh sach hang hoa");
        System.out.printf("%12s %-35s %10s %15s %15s%n",
                "Ma hang", "Ten hang", "So luong", "Don gia", "Thanh tien");

        if (products != null && products.length > 0) {
            for (Product p : products) {
                if (p != null) {
                    p.display();
                }
            }
        } else {
            System.out.println("\t[Chua co san pham]");
        }

        System.out.printf("\tCong thanh tien: %,.2f%n", grandTotal());
    }


    public double grandTotal() {
        double total = 0;
        if (products != null) {
            for (Product p : products) {
                if (p != null) {
                    total += p.total();
                }
            }
        }
        return total;
    }


    public void editCustomer() {
        if (customer != null) {
            customer.edit();
        } else {
            System.out.println("\tKhong co khach hang de sua");
        }
    }

    public void editProduct() {
        if (products == null || products.length == 0) {
            System.out.println("\tDon hang khong co san pham nao");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("\tNhap ten san pham can sua: ");
        String name = sc.nextLine();

        int index = findByName(name);
        if (index == -1) {
            System.out.println("\tTrong don hang khong ton tai san pham nay");
            return;
        }
        products[index].edit();
    }

    
    public int findByName(String name) {
        if (products == null) return -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null &&
                products[i].getName().trim().equalsIgnoreCase(name.trim())) {
                return i;
            }
        }
        return -1;
    }
}
