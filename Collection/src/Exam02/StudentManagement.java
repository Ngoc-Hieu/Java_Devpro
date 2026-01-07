package Exam02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManagement {
    public static List<Student>  init(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("101", "Nguyen Van", "Hung", "Nam", 
        LocalDate.of(2000, 3, 21), "Java spring boot"));
        students.add(new Student("102", "Nguyen Van", "Nam", "Nam", 
        LocalDate.of(2001, 4, 22), "Java spring boot"));
        students.add(new Student("103", "Nguyen Thi", "Huong", "Nu", 
        LocalDate.of(2002, 5, 23), "Tester"));
        students.add(new Student("104", "Nguyen Thi", "Bich", "Nu", 
        LocalDate.of(2003, 6, 24), "PHP"));
        students.add(new Student("105", "Nguyen Van", "Cao", "Nam", 
        LocalDate.of(2004, 7, 25), "Mobile Programming"));
        return students;
    }

    public static void main(String[] args) {
        List<Student> students = init();
        //chèn
        students.add(1,new Student("106", "Nguyen Thi", "Dung", "Nu", 
        LocalDate.of(2005, 8, 29), "Game Development") );

        //Hiển thị
        for(Student student : students){
            System.out.println(student.toString());
        }
        //Sửa học viên vị trí có chỉ số 3 với tên mới là trang , khoá học tester
        students.get(3).setLastName("Trang");
        students.get(3).setCourse("Tester");
        System.out.println(students.get(3).toString());

        //Xoá học viên 
        students.remove(1);
        //Hiển thị
        System.out.println("sau khi xoa");
        for(Student student : students){
            System.out.println(student.toString());
        }
        System.out.println("Tra ve vi tri: " + indexOf(students, "101"));
        System.out.println("Tra ve doi tuong: "+ findByCode(students, "101").toString());

        //Sắp xếp
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // TODO Auto-generated method stub
                return o1.getCode().compareToIgnoreCase(o2.getCourse());
            }
        } );
        System.out.println("sau khi sap xep");
        for(Student student : students){
            System.out.println(student.toString());
        }
    }
    //Tìm kiếm trả về vị trí
    public static int indexOf(List<Student> students, String code){
        for(int i=0 ; i< students.size() ; i++){
            if(students.get(i).getCode().equalsIgnoreCase(code)){
                return i;
            }
        }
        return -1;
    }
    //Tìm kiếm trả về đối tượng
    public static Student findByCode(List<Student> students, String code){
        for(Student student : students){
            if(student.getCode().equalsIgnoreCase(code)){
                return student;
            }
        }
        return null;
    }
}
