package vn_devpro_lession7;

public class Electronic extends Product{
    private double power;
    private double price;
    public void input(){
        super.input();
        System.out.print("\tNhap cong suat: ");
        power = Double.parseDouble(sc.nextLine());
        System.out.print("\tNhap gia tien: ");
        price = Double.parseDouble(sc.nextLine());
    }
    public void display(){
        super.display();
        System.out.printf("%9.1f %,15.2f%n",power, price);
    }
    public double getPrice(){
        return price;
    }
}
