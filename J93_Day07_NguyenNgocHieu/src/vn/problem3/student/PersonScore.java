package vn.problem3.student;

import java.util.Scanner;

public class PersonScore {
    private Student student;
    private Course[] courses;
    public PersonScore() {
    }
    public PersonScore(Student student, Course[] courses) {
        this.student = student;
        this.courses = courses;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Course[] getCourses() {
        return courses;
    }
    public void setCourses(Course[] courses) {
        this.courses = courses;
    }
    public void display(){
        System.out.println("BANG DIEM CA NHAN");
        System.out.println(student.toString());
        int stt = 0;
        System.out.printf("%4s%-25s%-25s%10s%10s\n", 
        "STT","codeCourse", "nameCourse","credit","score");
        
        sortByCoure();
        for(Course x : courses){
            stt++;
            System.out.printf("%4d",stt);
            System.out.println(x.toString());
        }
        System.out.println("Diem tong ket: " + getTotalScore());
    }
    public void sortByCoure(){

        for(int i=0 ; i<courses.length - 1 ; i++){
            for(int j=i+1 ; j<courses.length ; j++){
                if(courses[i].getNameCourse().compareToIgnoreCase(courses[j].getNameCourse()) > 0){
                    Course tmp = courses[i];
                    courses[i] = courses[j];
                    courses[j] = tmp;
                }
            }
        }
    }
    public double getTotalScore(){
        double totalScore = 0;
        double totalCredit = 0;
        for(Course x : courses){
            totalScore += x.getScore() * x.getCredit();
            totalCredit += x.getCredit();
        }
        return totalScore / totalCredit;
    }
    public void display6Score(){
         System.out.printf("%4s%-25s%-25s%10s%10s\n", 
        "STT","codeCourse", "nameCourse","credit","score");
        int stt = 0;
        for(Course x : courses){
            if(x.getScore() < 6.0){     
            System.out.printf("%4d",++stt);
            System.out.println(x.toString());
            }
        }
    }
    public void editStudent(){
        student.edit();
    }
    public void editCouse(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap ten mon hoc muon sua: ");
        String nameEdit = sc.nextLine();
        for(Course x : courses){
            if(nameEdit.equalsIgnoreCase(x.getNameCourse())){
                x.edit();
            }
        }
    }
}
