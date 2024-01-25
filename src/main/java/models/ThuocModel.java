package models;

public class ThuocModel {

    private String maThuoc, tenThuoc, tenHoatChat, maNhomThuoc, tenNhomThuoc, duongDung, hamLuong, soDangKy, dongGoi, donViTinh, hangSanXuat, nuocSanXuat;
    private int donGia, giaBHYT;
    private String trangThai;

    public ThuocModel(String maThuoc, String tenThuoc, String tenHoatChat, String maNhomThuoc, String duongDung, String hamLuong, String soDangKy, String dongGoi, String donViTinh, String hangSanXuat, String nuocSanXuat, int donGia, int giaBHYT, String trangThai) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.tenHoatChat = tenHoatChat;
        this.maNhomThuoc = maNhomThuoc;
        this.duongDung = duongDung;
        this.hamLuong = hamLuong;
        this.soDangKy = soDangKy;
        this.dongGoi = dongGoi;
        this.donViTinh = donViTinh;
        this.hangSanXuat = hangSanXuat;
        this.nuocSanXuat = nuocSanXuat;
        this.donGia = donGia;
        this.giaBHYT = giaBHYT;
        this.trangThai = trangThai;
    }

    public ThuocModel(String maThuoc, String tenThuoc, String tenHoatChat, String maNhomThuoc, String tenNhomThuoc, String duongDung, String hamLuong, String soDangKy, String dongGoi, String donViTinh, String hangSanXuat, String nuocSanXuat, int donGia, int giaBHYT, String trangThai) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.tenHoatChat = tenHoatChat;
        this.maNhomThuoc = maNhomThuoc;
        this.tenNhomThuoc = tenNhomThuoc;
        this.duongDung = duongDung;
        this.hamLuong = hamLuong;
        this.soDangKy = soDangKy;
        this.dongGoi = dongGoi;
        this.donViTinh = donViTinh;
        this.hangSanXuat = hangSanXuat;
        this.nuocSanXuat = nuocSanXuat;
        this.donGia = donGia;
        this.giaBHYT = giaBHYT;
        this.trangThai = trangThai;
    }

    public ThuocModel(String maThuoc, String tenThuoc, String duongDung, int donGia, int giaBHYT, String trangThai) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.donGia = donGia;
        this.giaBHYT = giaBHYT;
        this.trangThai = trangThai;
        this.duongDung = duongDung;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenNhomThuoc() {
        return tenNhomThuoc;
    }

    public void setTenNhomThuoc(String tenNhomThuoc) {
        this.tenNhomThuoc = tenNhomThuoc;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getTenHoatChat() {
        return tenHoatChat;
    }

    public void setTenHoatChat(String tenHoatChat) {
        this.tenHoatChat = tenHoatChat;
    }

    public String getMaNhomThuoc() {
        return maNhomThuoc;
    }

    public void setMaNhomThuoc(String maNhomThuoc) {
        this.maNhomThuoc = maNhomThuoc;
    }

    public String getDuongDung() {
        return duongDung;
    }

    public void setDuongDung(String duongDung) {
        this.duongDung = duongDung;
    }

    public String getHamLuong() {
        return hamLuong;
    }

    public void setHamLuong(String hamLuong) {
        this.hamLuong = hamLuong;
    }

    public String getSoDangKy() {
        return soDangKy;
    }

    public void setSoDangKy(String soDangKy) {
        this.soDangKy = soDangKy;
    }

    public String getDongGoi() {
        return dongGoi;
    }

    public void setDongGoi(String dongGoi) {
        this.dongGoi = dongGoi;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public String getNuocSanXuat() {
        return nuocSanXuat;
    }

    public void setNuocSanXuat(String nuocSanXuat) {
        this.nuocSanXuat = nuocSanXuat;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getGiaBHYT() {
        return giaBHYT;
    }

    public void setGiaBHYT(int giaBHYT) {
        this.giaBHYT = giaBHYT;
    }

}
