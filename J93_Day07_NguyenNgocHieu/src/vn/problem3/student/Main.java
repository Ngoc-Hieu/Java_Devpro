package vn.problem3.student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PersonScore ps = new PersonScore(new Student("1001222", "Nguyen Van B", "21/08/1998", "Khoa hoc may tinh"),
         new Course[] {
            new Course("0503127", "OOP", 3, 7.5),
            new Course("0503126", "Co so du lieu", 4, 5.5),
            new Course("0503125", "Lap trinh Java", 3, 4.5),
            new Course("0503124", "Lap trinh Python", 2, 8.5),
            new Course("0503123", "He dieu hanh", 3, 7.5)
         });
         do{
            System.out.println("\n\t\tCHUONG TRNH QUAN LY DIEM");
            System.out.println("Chon 1 chuc nang quan ly");
            System.out.println("\t1. Hien thi thong tin bang diem");
            System.out.println("\t2. Hien thi hoc phan co diem duoi 6.0");
            System.out.println("\t3. Sua thong tin sinh vien");
            System.out.println("\t4. Sua thong tin khoa hoc");
            System.out.println("\t0. Thoat chuong trinh");
            System.out.println("Lua chon cua ban bang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    ps.display();
                    break;
                case 2:
                    ps.display6Score();;
                    break;
                
                case 3:
                    ps.editStudent();;
                    break;
                case 4:
                    ps.editCouse();
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
