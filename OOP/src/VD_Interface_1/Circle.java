package VD_Interface_1;

import java.util.Scanner;

public class Circle implements IO, Shape{
    private double radius;
    @Override
    public double area() {
      return Math.PI * radius * radius;
    }
    @Override
    public double perimeter() {
       return 2 * Math.PI *radius;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap ban kinh: ");
        radius = Double.parseDouble(sc.nextLine());
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", area()=" + area() + ", perimeter()=" + perimeter() + "]";
    }
    @Override
    public void ouput() {
        System.out.println(toString());
    }

}
