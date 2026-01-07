package VD3;

import java.util.Scanner;

public class EmployeeManagement {
    static Scanner sc=  new Scanner(System.in);
    public static void  getList(Employee[] employees){
        System.out.println("Nhap danh sach nhan vien");
        for(int i=0 ; i<employees.length ; i++){
            System.out.println("Chon loai NV(1-NVSX, 2-NVVP):");
            int choose = Integer.parseInt(sc.nextLine());
            if(choose == 1){
                employees[i] = new Worker();
            }
            else if(choose == 2){
                employees[i] = new Staff();
            }
            else{
                System.out.println("Lua chon ko hop le");
                i--;
                continue;
            }
            employees[i].input();
        }

    }
    public static void display(Employee[] employees){
        System.out.printf("%-10s %-25s %11s %18s %-15s%n",
        "Ma NV","Ho va ten","Nam vao lam","San pham/Ngay nghi",
            "Luong thang");
        for(Employee e : employees){
            e.display();
        }
    }
    public static double totalSalary(Employee[] employees){
        double total = 0;
        for(Employee x : employees){
            total += x.salary();
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println("nhap so luong nhan vien");
        int n = Integer.parseInt(sc.nextLine());
        Employee[] e = new Employee[n];
        getList(e);
        System.out.println("DANH SACH NHAN VIEN");
        display(e);
        System.out.printf("So tien cong ty phai tra: %,.2f%n", totalSalary(e) );
    }
}
