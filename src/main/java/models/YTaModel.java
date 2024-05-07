package models;

public class YTaModel {

    private String MaYT, HoTen, GioiTinh, DiaChi, SDT, CCCD, email, namSinh, anh;

    public YTaModel() {
    }

    public YTaModel(String MaYT, String email) {
        this.MaYT = MaYT;
        this.email = email;
    }

    public YTaModel(String HoTen, String GioiTinh, String namSinh, String DiaChi, String SDT, String CCCD, String anh) {
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.namSinh = namSinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.CCCD = CCCD;
        this.anh = anh;
    }

    public YTaModel(String MaYT, String HoTen, String GioiTinh, String namSinh, String DiaChi, String SDT, String CCCD, String anh) {
        this.MaYT = MaYT;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.namSinh = namSinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.CCCD = CCCD;
        this.anh = anh;
    }

    public YTaModel(String MaYT, String HoTen, String GioiTinh, String DiaChi, String SDT, String CCCD, String email, String namSinh, String anh) {
        this.MaYT = MaYT;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.CCCD = CCCD;
        this.email = email;
        this.namSinh = namSinh;
        this.anh = anh;
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

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
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
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

}
