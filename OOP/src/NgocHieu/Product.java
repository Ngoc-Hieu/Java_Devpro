package NgocHieu;

import java.util.Scanner;

public class Product {
    private String code;
    private String name;
    private int quantity;
    private double price;
    public Product() {
    }
    public Product(String code, String name, int quantity, double price) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void display(){
        System.out.printf("%12s %-35s %,10d %,15.2f %,15.2f\n",
            code, name, quantity, price, total()
        );
    }
    public double total(){
        return quantity * price;
    }
    public void edit() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n\t\tSUA THONG TIN MAT HANG");
            System.out.println("Chon thong tin can sua");
            System.out.println("\t1. Sua ten hang");
            System.out.println("\t2. Sua so luong");
            System.out.println("\t3. Sua don gia");
            System.out.println("\t0. Quay lai");

            System.out.println("Lua chon cua ban bang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.printf("Nhap ten moi: ");
                    name = sc.nextLine();
                    break;
                case 2:
                    System.out.printf("Nhap so luong moi: ");
                    quantity = Integer.parseInt(sc.nextLine());
                    break;
                case 3:
                    System.out.printf("Nhap don gia moi: ");
                    price = Double.parseDouble(sc.nextLine());
                    break;
                case 0:
                    return;

                default:
                    System.out.println("Lua chon khong hop le, xin chon lai");

            }
        } while (true);
    }

}
