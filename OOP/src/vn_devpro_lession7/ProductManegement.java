package vn_devpro_lession7;

import java.util.Scanner;

public class ProductManegement {
    //Hàm nhập danh sách sản phăm
    public static void input(Electronic[] e){
        for(int i=0 ; i<e.length ; i++){
            e[i] = new Electronic();
            e[i].input();
        }
    }
    //hàm hiển thị danh sách sản phẩm
    public static void display(Electronic[] e){
        System.out.println("Danh sach san pham");
        for(Electronic item : e){
            item.display();
        }
    }
    //In ra màn hình hàm điện tử có giá tiền thấp nhất
    public static void displayMinPrice(Electronic[] e){
        double min = e[0].getPrice();
        for(Electronic item : e){
            if(item.getPrice() < min) min =item.getPrice(); 
        }
        System.out.println("Danh sach san pham co gia tien nho nhat");
        for(Electronic item : e){
            if(item.getPrice() == min){
                item.display();
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Cho so luong danh sach san pham n = ");
        int n = Integer.parseInt(sc.nextLine());
        Electronic[] e = new  Electronic[n];
        System.out.println("Nhap danh sach san pham");
        input(e);
        display(e);
        displayMinPrice(e);
    }
}
