package vn_devpro_store.model;

import java.util.Scanner;

public class Provider { // xem, thêm, sửa, xoá, tìm kiếm, sắp xếp
    private int id;
    private String code;
    private String name;

    public void display() {
        System.out.printf("%5d %12s %-30s%n", id, code, name);
    }

    public void edit() {
        System.out.println("\n\t\tSUA THONG TIN NHA CUNG CAP");
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhap ten moi: ");
        String name = sc.nextLine();
        if (name == null || name.isBlank()) {
            System.out.println("\tTen khong duoc bỏ trong");
            return;
        }
        this.setName(name);
        System.out.println("\tSua ten nha cung cap thanh cong");
    }

    public Provider() {
    }

    public Provider(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
