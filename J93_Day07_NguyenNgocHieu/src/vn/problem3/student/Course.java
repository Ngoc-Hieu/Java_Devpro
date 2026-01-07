package vn.problem3.student;

import java.util.Scanner;

public class Course {
    private String codeCourse;
    private String nameCourse;
    private int credit;
    private double score;
    public Course() {
    }
    public Course(String codeCourse, String nameCourse, int credit, double score) {
        this.codeCourse = codeCourse;
        this.nameCourse = nameCourse;
        this.credit = credit;
        this.score = score;
    }
    public String getCodeCourse() {
        return codeCourse;
    }
    public void setCodeCourse(String codeCourse) {
        this.codeCourse = codeCourse;
    }
    public String getNameCourse() {
        return nameCourse;
    }
    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    @Override
    public String toString() {
        return String.format("%-25s%-25s%10d%,10.2f\n", 
        codeCourse, nameCourse,credit,score);
    }
    public void edit(){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n\t\tSUA THONG TIN KHOA HOC");
            System.out.println("Chon thong tin can sua");
            System.out.println("\t1. Sua ten khoa hoc");
            System.out.println("\t2. Sua so tin chi");
            System.out.println("\t3. Sua diem hoc phan");
            System.out.println("\t0. Quay lai");

            System.out.println("Lua chon cua ban bang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.printf("Nhap ten moi: ");
                    nameCourse = sc.nextLine();
                    break;
                case 2:
                    System.out.println("Nhap so tin chi moi");
                    credit = Integer.parseInt(sc.nextLine());
                    break;
                case 3:
                    System.out.printf("Nhap diem tong ket moi: ");
                    score = Double.parseDouble(sc.nextLine());
                    break;
                case 0:
                    return;

                default:
                    System.out.println("Lua chon khong hop le, xin chon lai");

            }
        } while (true);
    }
}
