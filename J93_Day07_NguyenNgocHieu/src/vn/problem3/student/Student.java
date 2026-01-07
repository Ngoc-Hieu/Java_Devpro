package vn.problem3.student;

import java.util.Scanner;

public class Student {
 private String code;
    private String Name;
    private String birthday;
    private String major;
    public Student() {
    }
    public Student(String code, String name, String birthday, String major) {
        this.code = code;
        Name = name;
        this.birthday = birthday;
        this.major = major;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-20s\n", code, Name, birthday, major);
    }
    public void edit(){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n\t\tSUA THONG TIN SINH VIEN");
            System.out.println("Chon thong tin can sua");
            System.out.println("\t1. Sua ten sinh vien");
            System.out.println("\t2. Sua ngay thang nam sinh");
            System.out.println("\t3. Sua nganh");
            System.out.println("\t0. Quay lai");

            System.out.println("Lua chon cua ban bang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.printf("Nhap ten moi: ");
                    Name = sc.nextLine();
                    break;
                case 2:
                    System.out.println("Nhap ngay thang nam sinh moi: ");
                    System.out.printf("\tNhap ngay: ");
                    int day = Integer.parseInt(sc.nextLine());
                    System.out.printf("\tNhap thang: ");
                    int month = Integer.parseInt(sc.nextLine());
                    System.out.printf("\tNhap nam: ");
                    int year = Integer.parseInt(sc.nextLine());
                    birthday = day + "/" + month + "/" + year;
                    break;
                case 3:
                    System.out.printf("Nhap nganh moi: ");
                    major = sc.nextLine();
                    break;
                case 0:
                    return;

                default:
                    System.out.println("Lua chon khong hop le, xin chon lai");

            }
        } while (true);
    }
}
