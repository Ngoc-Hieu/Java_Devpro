package VD2;

public class Rectangle extends  Shape{
    private double len;
    private double width;
    
    public Rectangle(double len, double width) {
        this.len = len;
        this.width = width;
    }

    public Rectangle() {
    }

    @Override
    public double perimeter() {
        return 2 * (len + width);
    }

    @Override
    public double area() {
       return len * width;
    }

}
