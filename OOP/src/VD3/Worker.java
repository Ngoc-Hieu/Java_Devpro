package VD3;

public class Worker extends Employee{
    private int product;
    public void input(){
        super.input();
        System.out.printf("\tNhap san pham: ");
        product = Integer.parseInt(sc.nextLine());
    }
    public void display(){
        super.display();
        System.out.printf("%18d %,15.2f%n" , product, salary());
    }
    @Override
    public double salary() {
       return product * 50000 + allowance();
    }

}
