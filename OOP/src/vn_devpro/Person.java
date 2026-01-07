package vn_devpro;

import java.util.Scanner;

public class Person {
    private String name;
    private int age;
    private String gender;

   
    public void fillInfor(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Nhap your age: ");
        age = Integer.parseInt(sc.nextLine());
        System.out.println("Enter your gender: ");
        gender = sc.nextLine();
    }
    public void display(){
        System.out.println("You have just enter your information, including: ");
        System.out.println("\tYour name: " + this.name);
        System.out.println("\tYour age: " + this.age);
        System.out.println("\tYour gender: " + this.gender);
        System.out.println("Thank you.");
    }
    public int getAge(){
        return this.age;
    }
}
