package NgocHieu;

import java.util.Scanner;

public class Customer {
    private String name;
    private String mobile;
    private String address;
    public Customer() {
    }
    public Customer(String name, String mobile, String address) {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
    }
    public void display(){
        System.out.println("\tHo ten khach hang: " + name);
        System.out.println("\tSo dien thoat: " + mobile);
        System.out.println("\tDia chi: " + address);
    }
    public void edit() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n\t\tSUA THONG TIN KHACH HANG");
            System.out.println("Chon thong tin can sua");
            System.out.println("\t1. Sua ten khach hang");
            System.out.println("\t2. Sua so dien thoai");
            System.out.println("\t3. Sua dia chi");
            System.out.println("\t0. Quay lai");

            System.out.println("Lua chon cua ban bang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.printf("Nhap ten moi: ");
                    name = sc.nextLine();
                    break;
                case 2:
                    System.out.printf("Nhap so dien thoai moi: ");
                    mobile = sc.nextLine();
                    break;
                case 3:
                    System.out.printf("Nhap dia chi moi: ");
                    address = sc.nextLine();
                    break;
                case 0:
                    return;

                default:
                    System.out.println("Lua chon khong hop le, xin chon lai");

            }
        } while (true);
    }
    
}
