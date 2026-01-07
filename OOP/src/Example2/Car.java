package Example2;

public class Car {
    private int id;
    private String brand;
    private double price;
    private String manufacturer;

    public Car(int id, String brand, double price, String manufacturer) {
        this.id = id;
        this.brand = brand;
        this.price = price;
        this.manufacturer = manufacturer;
    }
    public Car() {
        id = 1;
        brand = "vios";
        price = 25000;
        manufacturer = "toyota";
    }
    
    @Override
    public String toString() {
        return "Car [id=" + id + ", brand=" + brand + ", price=" + price + ", manufacturer=" + manufacturer + "]";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    
}
