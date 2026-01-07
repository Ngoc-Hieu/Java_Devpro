package Example2;

public class CarDemo {

    public static void main(String[] args) {

        Car toyCar = new Car();
        Car mazCar = new Car(2, "CX5", 31000, "Mazda");
        System.out.println(toyCar.toString());
        System.out.println(mazCar.toString());

        Car suzCar = new Car();
        suzCar.setId(3);
        suzCar.setBrand("Vitara");
        suzCar.setPrice(29000);
        suzCar.setManufacturer("Suzuki");
        System.out.println(suzCar.toString());

        System.out.println("The information of suzuki car");
        System.out.println("\tID: " + suzCar.getId());
        System.out.println("\tBrand: "  + suzCar.getBrand());
        System.out.println("\tPrice: "+suzCar.getPrice());
        System.out.println("\tManufacturer: "+suzCar.getManufacturer());
    }
}
