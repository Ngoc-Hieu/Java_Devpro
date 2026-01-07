package vn_devpro_store.model;

import java.math.BigDecimal;
import java.util.Scanner;

import vn_devpro_store.database.ProviderDB;

public class Product {
    private int id;
    private int providerId;
    private String code;
    private String name;
    private BigDecimal price;

    public void display() {
        Provider provider = ProviderDB.findById(providerId);
        System.out.printf("%5d %12s %-30s %-35s %,15.2f%n",
                id, code, provider.getName(), name, price);
    }

    public void edit() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n\t\tSUA THONG TIN SAN PHAM");
            System.out.println("Chon thong tin can sua");
            System.out.println("\t1.Sua nha cung cap");
            System.out.println("\t2.Sua ten san pham");
            System.out.println("\t3.Sua gia san pham");
            System.out.println("\t0.Quay lai");

            System.out.println("Lua chon phuong an cua ban");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    editProvider();
                    break;
                case 2:
                    editName();
                    break;
                case 3:
                    editPrice();
                    break;
                case 0:
                    
                    return;
                default:
                    break;
            }
        } while (true);
    }
    Scanner sc = new Scanner(System.in);
    public void editProvider(){
        System.out.printf("Nhap ten nha cung cap moi: ");
        String  providerName = sc.nextLine();
        //Tìm nhà cung cấp này có trong DB nhà cung cấp ko
        Provider provider = ProviderDB.findByName(providerName);
        if(provider == null){
            System.out.println("\tNha cung cap nay chua co trong danh sach");return;
        }
        this.setProviderId(provider.getId());
        System.out.println("\tSua nha cung cap thanh cong");
    }
    public void editName() {
        
        System.out.printf("\tNhap ten moi: ");
        String name = sc.nextLine();
        if (name == null || name.isBlank()) {
            System.out.println("\tTen khong duoc bỏ trong");
            return;
        }
        this.setName(name);
        System.out.println("\tSua ten san pham thanh cong");
    }
    public void editPrice(){
        System.out.println("\tNhap gia moi");
        BigDecimal price = new BigDecimal(sc.nextLine());
        if(price.doubleValue() < 0){
            System.out.println("Gia tien khong duoc là so am"); return;
        }
        setPrice(price);
        System.out.println("\tSua gia tien thanh cong");
    }
    public Product() {
    }

    public Product(int id, int providerId, String code, String name, BigDecimal price) {
        this.id = id;
        this.providerId = providerId;
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
