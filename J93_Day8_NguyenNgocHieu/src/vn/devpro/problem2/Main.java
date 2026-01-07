package vn.devpro.problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static List<NhanSu> list = new ArrayList<>();

    public static void Demo() {
        CanBo cb1 = new CanBo("NS01", "Nguyen Ngoc", "Hieu", 2005, "Nam", "Kinh te", "Truong phong", 0.5, "A");
        CanBo cb2 = new CanBo("NS03", "Tran Van", "Minh", 2000, "Nam", "Cong nghe thong tin", "Nhan vien", 0.3, "B");
        CanBo cb3 = new CanBo("NS05", "Le Thi", "Hoa", 1998, "Nu", "Tai chinh", "Pho phong", 0.4, "A");
        CanBo cb4 = new CanBo("NS07", "Pham Quang", "Anh", 1995, "Nam", "Nhan su", "Chuyen vien", 0.6, "C");
        CanBo cb5 = new CanBo("NS09", "Nguyen Thi", "Lan", 1992, "Nu", "Marketing", "Giam doc", 0.7, "A");

        CongNhan cn1 = new CongNhan("NS02", "Nguyen Van", "An", 1990, "Nam", "Xuong Co khi", "Han", 24);
        CongNhan cn2 = new CongNhan("NS04", "Tran Thi", "Bich", 1992, "Nu", "Xuong May", "May cong nghiep", 21);
        CongNhan cn3 = new CongNhan("NS06", "Le Van", "Cuong", 1988, "Nam", "Xuong Dien", "Lap rap mach dien", 19);
        CongNhan cn4 = new CongNhan("NS08", "Pham Thi", "Dung", 1995, "Nu", "Xuong Thuc pham", "Dong goi", 17);
        list.add(cb1);
        list.add(cn1);
        list.add(cb2);
        list.add(cn2);
        list.add(cb3);
        list.add(cn3);
        list.add(cb4);
        list.add(cn4);
        list.add(cb5);
    }

    public static void display() {
        System.out.println("DANH SACH NHAN SU ");
        System.out.printf("%-10s %-20s %-10s %10s %-8s %-15s\n",
                "Ma NS", "Ho dem", "Ten", "Nam sinh", "Gioi tinh", "Luong");
        for (NhanSu x : list) {
            System.out.println(x.toString());
        }
    }

    public static void displayMaleWorker() {
        System.out.println("DANH SACH CONG NHAN NAM");
        System.out.printf("%-10s %-20s %-10s %10s %-8s %-15s\n",
                "Ma NS", "Ho dem", "Ten", "Nam sinh", "Gioi tinh", "Luong");
        for (NhanSu x : list) {
            if ((x instanceof CongNhan) && x.gioiTinh.trim().equalsIgnoreCase("Nam"))
                System.out.println(x.toString());
        }
    }

    public static void displayFemaleOfficer() {
        System.out.println("DANH SACH CAN BO NU");
        System.out.printf("%-10s %-20s %-10s %10s %-8s %-15s\n",
                "Ma NS", "Ho dem", "Ten", "Nam sinh", "Gioi tinh", "Luong");
        for (NhanSu x : list) {
            if ((x instanceof CanBo) && x.gioiTinh.trim().equalsIgnoreCase("Nu"))
                System.out.println(x.toString());
        }
    }

    public static void displayHighestOfficer() {
        System.out.println("DANH SACH CAN BO LUONG CAO NHAT");
        NhanSu max = null;
        for (NhanSu x : list) {
            if (x instanceof CanBo) {
                if (max == null || x.salary() > max.salary()) {
                    max = x;
                }
            }
        }
        if (max != null) {
            System.out.printf("%-10s %-20s %-10s %10s %-8s %-15s\n",
                    "Ma NS", "Ho dem", "Ten", "Nam sinh", "Gioi tinh", "Luong");
            System.out.println(max.toString());
        } else {
            System.out.println("Khong co CanBo trong danh sach!");
        }
    }

    public static void displayLowestWorker() {
        System.out.println("DANH SACH CONG NHAN LUONG THAP NHAT");
        NhanSu min = null;
        for (NhanSu x : list) {
            if (x instanceof CongNhan) {
                if (min == null || x.salary() < min.salary()) {
                    min = x;
                }
            }
        }
        if (min != null) {
            System.out.printf("%-10s %-20s %-10s %10s %-8s %-15s\n",
                    "Ma NS", "Ho dem", "Ten", "Nam sinh", "Gioi tinh", "Luong");
            System.out.println(min.toString());
        } else {
            System.out.println("Khong co CongNhan trong danh sach!");
        }
    }

    public static double totalSalaryOfficer() {
        double total = 0;
        for (NhanSu x : list) {
            if (x instanceof CanBo) {
                total += x.salary();
            }
        }
        return total;
    }

    public static double totalSalaryWorker() {
        double total = 0;
        for (NhanSu x : list) {
            if (x instanceof NhanSu) {
                total += x.salary();
            }
        }
        return total;
    }

    public static void move() {
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if ((list.get(i) instanceof CongNhan) && (list.get(j) instanceof CanBo)) {
                NhanSu tmp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, tmp);
                i++;
                j--;
            } 
            else {
                if (!(list.get(i) instanceof CongNhan)) {
                    i++;
                }
                if (!(list.get(j) instanceof CanBo)) {
                    j--;
                }
            }

        }
    }

    public static void sortByName() {
        Collections.sort(list, new Comparator<NhanSu>() {
            @Override
            public int compare(NhanSu o1, NhanSu o2) {
                return o1.ten.compareToIgnoreCase(o2.ten);
            }
        });
    }

    public static void main(String[] args) {
        Demo();

        display();
        System.out.println("HIEN THI CONG NHAN NAM");
        displayMaleWorker();
        System.out.println("HIEN THI CAN BO NU");
        displayFemaleOfficer();
        System.out.println("HIEN THI CAN BO LUONG CAO NHAT");
        displayHighestOfficer();
        System.out.println("HIEN THI CONG NHAN LUONG THAP NHAT");
        displayLowestWorker();
        System.out.printf("Tong luong can bo la: %,15.2f%n", totalSalaryOfficer());
        System.out.printf("Tong luong cong nhan la: %,15.2f%n", totalSalaryWorker());
        System.out.println("CHUYEN CONG NHAN XUONG CUOI");
        move();
        display();
        System.out.println("SAP XEP THEO TEN");
        sortByName();
        display();
    }
}
