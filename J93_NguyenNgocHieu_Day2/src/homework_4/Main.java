package homework_4;

import java.util.Scanner;

public class Main {
    public static void nhapHangHoa(HangHoa hang) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap ten hang: ");
        hang.tenHang = sc.nextLine();

        System.out.printf("Nhap so luong hang: ");
        hang.soLuongHang = sc.nextInt();

        System.out.printf("Nhap don gia: ");
        hang.donGia = sc.nextDouble();

        sc.nextLine(); 
    }

    public static String hienThiHangHoa(HangHoa hang) {
        return String.format("%-20s%20d%20.3f%20.3f%n",
                hang.tenHang,
                hang.soLuongHang,
                hang.donGia,
                hang.donGia * hang.soLuongHang);
    }

    public static void nhapHoaDon(HoaDon hd) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin hoa don");

        System.out.printf("Nhap so hoa don: ");
        hd.soHoaDon = sc.nextLine();

        System.out.printf("Nhap ho ten khach hang: ");
        hd.hoTen = sc.nextLine();

        System.out.println("Nhap ngay thang nam mua hang");
        System.out.printf("Nhap ngay mua hang: ");
        String day = sc.nextLine();
        System.out.printf("Nhap thang mua hang: ");
        String month = sc.nextLine();
        System.out.printf("Nhap nam mua hang: ");
        String year = sc.nextLine();
        hd.ngayMua = day + "/" + month + "/" + year;

        System.out.println("Nhap danh sach hang hoa");
        for (int i = 0; i < 5; i++) {
            System.out.println("Nhap hang hoa thu " + (i + 1));
            hd.danhSachHangHoa[i] = new HangHoa();
            nhapHangHoa(hd.danhSachHangHoa[i]);
        }
    }

    public static String hienThiHoaDon(HoaDon hd) {
        double tongTien = 0;
        String dSHangHoa = "";

        for (int i = 0; i < 5; i++) {
            tongTien += hd.danhSachHangHoa[i].donGia * hd.danhSachHangHoa[i].soLuongHang;
            dSHangHoa += hienThiHangHoa(hd.danhSachHangHoa[i]);
        }

        double truThue = tongTien * 10 / 100; 

        String headerThongTin = String.format("%-20s%-20s%-20s%n", "So hoa don", "Ho ten", "Ngay mua")
                + String.format("%-20s%-20s%-20s%n", hd.soHoaDon, hd.hoTen, hd.ngayMua);

        String headerBang = String.format("%-20s%20s%20s%20s%n", "Ten hang", "So luong", "Don gia", "Thanh tien");

        return headerThongTin
                + headerBang
                + dSHangHoa
                + "Tong tien hang = " + String.format("%.3f", tongTien)
                + "\nSo tien sau khi tru thue = " + String.format("%.3f", truThue);
    }

    public static void main(String[] args) {
        HoaDon hoadon = new HoaDon();
        nhapHoaDon(hoadon);
        System.out.println(hienThiHoaDon(hoadon));
    }
}
