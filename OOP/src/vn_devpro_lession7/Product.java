package vn_devpro_lession7;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Product { //super class
    protected String code;
    protected String name;
    protected LocalDate date;
    Scanner sc = new Scanner(System.in);
    
    public void input(){
        System.out.print("\tNhap ma san pham: ");
        code = sc.nextLine();
        System.out.print("\tNhap ten san pham: ");
        name = sc.nextLine();
        System.out.print("\tNhap ngay san xuat (dd/mm/yyyy): ");
        String str = sc.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        date = LocalDate.parse(str,dtf);
    }
    public void display(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("%-10s %-35s %10s" , 
        code, name, date.format(dtf));
    }
    
}
