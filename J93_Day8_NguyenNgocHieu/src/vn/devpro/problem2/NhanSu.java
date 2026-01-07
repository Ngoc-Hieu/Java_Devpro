package vn.devpro.problem2;

public abstract class NhanSu {
    protected String maMS;
    protected String hoDem;
    protected String ten;
    protected int namSinh;
    protected String gioiTinh;

    public NhanSu() {
    }

    public NhanSu(String maMS, String hoDem, String ten, int namSinh, String gioiTinh) {
        this.maMS = maMS;
        this.hoDem = hoDem;
        this.ten = ten;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
    }

    public abstract double salary();

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-10s %10d %-8s %,15.2f",
                maMS, hoDem, ten, namSinh, gioiTinh, salary());
    }

}
