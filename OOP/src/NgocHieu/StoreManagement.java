package NgocHieu;

import java.util.Date;
import java.util.Scanner;

public class StoreManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Order order = new Order("Or-" + new Date().getTime(), 
        new Customer("Anh Cong","0987654321","147 - Mai Dich - Cau Giay"), 
        new Product[] {
            new Product("p-1001", "Bim bim khoai tay", 5, 10000),
            new Product("p-1002", "Keo khoai mon", 2, 20000),
            new Product("p-1003", "Chuoi say 200g", 5, 25000),
            new Product("p-1004", "Ngo nep chien 200g", 5, 19000),
            new Product("p-1005", "Coca cola 300ml", 2, 10000),
        } );

        do{
            System.out.println("\n\t\tCHUONG TRNH QUAN LY BAN HANG");
            System.out.println("Chon 1 chuc nang quan ly");
            System.out.println("\t1. Hien thi thong tin don hang");
            System.out.println("\t2. Sua thong tin khach");
            System.out.println("\t3. Sua thong tin hang");
            System.out.println("\t0. Thoat chuong trinh");
            System.out.println("Lua chon cua ban bang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    order.display();
                    break;
                case 2:
                    order.editCustomer();
                    break;
                
                case 3:
                    order.editProduct();
                    break;
                
                case 0:
                    System.out.println("Da thoat khoi ung dung");
                    System.exit(0);

                default:
                    System.out.println("Lua chon khong hop le, xin chon lai");

            }
        } while (true);
       
    }
}
