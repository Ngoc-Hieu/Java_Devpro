package VD3;

public class Staff extends Employee{
    private double basic;
    private double dayOff;
    public void input(){
        super.input();
        System.out.print("\tNhap muc luong: ");
        basic = Double.parseDouble(sc.nextLine());
        System.out.print("\tNhap so ngay nghi: ");
        dayOff = Double.parseDouble(sc.nextLine());
    }
    @Override
    public double salary() {
        return basic - dayOff * 35000;
    }
    public void display(){
        super.display();
        System.out.printf("%18.1f %,15.2f%n",dayOff,salary());
    }
}
