package vn_devpro;

public class DemoPersonManagement {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("Please enter your information");
        person.fillInfor();
        person.display();

        System.out.println("your age: " + person.getAge());
    }
}
