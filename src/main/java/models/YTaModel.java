package models;

public class YTaModel {

    private String MaYT, HoTen, GioiTinh, DiaChi, SDT, CCCD, Email;
    private String NgaySinh;

    public YTaModel() {
    }

    public YTaModel(String MaYT, String HoTen, String GioiTinh, String NgaySinh, String DiaChi, String SDT, String CCCD, String Email) {
        this.MaYT = MaYT;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.CCCD = CCCD;
        this.Email = Email;
    }

    public String getMaYT() {
        return MaYT;
    }

    public void setMaYT(String MaYT) {
        this.MaYT = MaYT;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
