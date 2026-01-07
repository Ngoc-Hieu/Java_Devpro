package VD3;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Employee {
    protected String Code;
    protected String name;
    protected int year;

    Scanner sc  = new Scanner(System.in);
    public void input(){
        System.out.print("\tNhap ma NV: ");
        Code = sc.nextLine();
        System.out.print("\tNhap ho ten: ");
        name = sc.nextLine();
        System.out.print("\tNhap nam vao lam: ");
        year = Integer.parseInt(sc.nextLine());
    }
    public abstract double salary();
    public double allowance(){
        LocalDate date = LocalDate.now();
        return 200000 + (date.getYear() - year) * 75000;
    }
    public void display(){
        System.out.printf("%-10s %-25s %11d", Code, name, year);
    }
}
