package car;

import java.util.Scanner;

public class Car {
    private String code;
    private String brand;
    private String style;
    private double price;
    private String manufacturer;
    private String origin;

    public Car() {
    }

    public Car(String code, String brand, String style, double price, String manufacturer, String origin) {
        this.code = code;
        this.brand = brand;
        this.style = style;
        this.price = price;
        this.manufacturer = manufacturer;
        this.origin = origin;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Car [code=" + code + ", brand=" + brand + ", style=" + style + ", price=" + price + ", manufacturer="
                + manufacturer + ", origin=" + origin + "]";
    }

    public void display() {
        System.out.printf("%-12s %-20s %-10s %,10.2f %-15s %-15s",
                code, brand, style, price, manufacturer, origin);
    }

    public void fillInfor() {
        Scanner sc = new Scanner(System.in);

    }

    public void edit() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n\t\tSUA THONG TIN XE HOI");
            System.out.println("Chon thong tin can sua");
            System.out.println("\t1. Sua nhan hieu");
            System.out.println("\t2. Sua kieu dang");
            System.out.println("\t3. Sua gia ban");
            System.out.println("\t4. Sua ten nha san xuat");
            System.out.println("\t5. Sua xuat xu");
            System.out.println("\t0. Quay lai");

            System.out.println("Lua chon cua ban bang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.printf("Nhap nhan hieu moi: ");
                    brand = sc.nextLine();
                    break;
                case 2:
                    System.out.printf("Nhap kieu dang moi: ");
                    style = sc.nextLine();
                    break;
                case 3:
                    System.out.printf("Nhap gia ban moi: ");
                    price = Double.parseDouble(sc.nextLine());
                    break;
                case 4:
                    System.out.printf("Nhap ten nha san xuat moi: ");
                    manufacturer = sc.nextLine();
                    break;
                case 5:
                    System.out.printf("Nhap xuat xu moi: ");
                    origin = sc.nextLine();
                    break;
                case 0:
                    return;

                default:
                    System.out.println("Lua chon khong hop le, xin chon lai");

            }
        } while (true);
    }

}
