package vn.devpro.problem2;

public class CongNhan extends NhanSu{
    private String xuong;
    private String congViec;
    private double soNgayCong;
    public CongNhan() {
        super();
    }
    public CongNhan(String xuong, String congViec, double soNgayCong) {
        this.xuong = xuong;
        this.congViec = congViec;
        this.soNgayCong = soNgayCong;
    }
    public CongNhan(String maMS, String hoDem, String ten, int namSinh, String gioiTinh, String xuong, String congViec,
            double soNgayCong) {
        super(maMS, hoDem, ten, namSinh, gioiTinh);
        this.xuong = xuong;
        this.congViec = congViec;
        this.soNgayCong = soNgayCong;
    }
    public String getXuong() {
        return xuong;
    }
    public void setXuong(String xuong) {
        this.xuong = xuong;
    }
    public String getCongViec() {
        return congViec;
    }
    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }
    public double getSoNgayCong() {
        return soNgayCong;
    }
    public void setSoNgayCong(double soNgayCong) {
        this.soNgayCong = soNgayCong;
    }
    @Override
    public double salary() {
        if(soNgayCong >= 23)
            return soNgayCong * 250000 + 500000;
        else if(soNgayCong >= 20)
            return soNgayCong * 250000 + 300000;
        else if(soNgayCong >= 18)
            return  soNgayCong * 250000;
        else 
            return soNgayCong * 250000-200000;
    }
    
}
