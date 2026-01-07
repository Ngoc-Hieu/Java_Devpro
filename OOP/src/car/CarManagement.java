package car;

import java.util.Scanner;

public class CarManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Car car = new Car("1528","Vios","Sedan",21000,"Toyota","Viet Nam");

        do{
            System.out.println("\n\t\tCHUONG TRNH QUAN LY XE HOI");
            System.out.println("Chon 1 chuc nang quan ly");
            System.out.println("\t1. Hien thi thong tin xe hoi");
            System.out.println("\t2. Sua thong tin xe hoi");
            System.out.println("\t0. Thoat chuong trinh");
            System.out.println("Lua chon cua ban bang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    car.display();
                    break;
                case 2:
                    car.edit();
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
