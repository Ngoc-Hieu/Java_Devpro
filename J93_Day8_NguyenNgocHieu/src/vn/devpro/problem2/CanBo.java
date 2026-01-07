package vn.devpro.problem2;

public class CanBo extends NhanSu{
    private String phong;
    private String chucVu;
    private double heSoLuong;
    private String xepLoai;
    public CanBo(String phong, String chucVu, double heSoLuong, String xepLoai) {
        this.phong = phong;
        this.chucVu = chucVu;
        this.heSoLuong = heSoLuong;
        this.xepLoai = xepLoai;
    }
    public CanBo(String maMS, String hoDem, String ten, int namSinh, String gioiTinh, String phong, String chucVu,
            double heSoLuong, String xepLoai) {
        super(maMS, hoDem, ten, namSinh, gioiTinh);
        this.phong = phong;
        this.chucVu = chucVu;
        this.heSoLuong = heSoLuong;
        this.xepLoai = xepLoai;
    }
   
    public CanBo() {
        super();
    }
    public String getPhong() {
        return phong;
    }
    public void setPhong(String phong) {
        this.phong = phong;
    }
    public String getChucVu() {
        return chucVu;
    }
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    public double getHeSoLuong() {
        return heSoLuong;
    }
    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }
    public String getXepLoai() {
        return xepLoai;
    }
    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }
    @Override
    public double salary() {
        if(xepLoai.trim().equalsIgnoreCase("A"))
            return heSoLuong * 1150000 + 1000000;
        else if(xepLoai.trim().equalsIgnoreCase("B"))
            return heSoLuong * 1150000;
        else if(xepLoai.trim().equalsIgnoreCase("C"))
            return heSoLuong * 1150000 - 400000;
        else
            return heSoLuong * 1150000 - 1000000;
    }
    
}
