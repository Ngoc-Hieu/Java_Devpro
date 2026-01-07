package vn_devpro_store.dto;

import java.math.BigDecimal;
import java.util.Scanner;

import vn_devpro_store.database.ProductDB;
import vn_devpro_store.model.Product;

public class CartItem {
    private int productId;
    private int quantity;

    public  BigDecimal totalPrice(){
        Product product = ProductDB.findById(productId);
        if(product == null){
            return BigDecimal.ZERO;
        }
         return product.getPrice().multiply(new BigDecimal(this.quantity));
    }

    public void display(){
        Product product = ProductDB.findById(productId);
        System.out.printf("%-30s %,8d %,15.2f %,15.2f%n",
        product.getName(),quantity,product.getPrice(),totalPrice());
    }

     public void edit() {
        System.out.println("\n\t\tSUA SO LUONG SAN PHAM");
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhap so luong moi: ");
        int quantity = Integer.parseInt(sc.nextLine());
        if (quantity < 1) {
            System.out.println("\tSo luong khong hop le");
            return;
        }
        setQuantity(quantity);
        System.out.println("\tSua so luong thanh cong");
    }

    public CartItem() {        
    }
    public CartItem(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
