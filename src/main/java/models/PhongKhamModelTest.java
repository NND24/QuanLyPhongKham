package models;

public class PhongKhamModelTest {

    private String maPhongKham, tenPhongKham, trangThai;
    private int soLuongBenhNhan;

    public PhongKhamModelTest(String maPhongKham, String tenPhongKham, String trangThai, int soLuongBenhNhan) {
        this.maPhongKham = maPhongKham;
        this.tenPhongKham = tenPhongKham;
        this.trangThai = trangThai;
        this.soLuongBenhNhan = soLuongBenhNhan;
    }

    public PhongKhamModelTest(String maPhongKham, String tenPhongKham, String trangThai) {
        this.maPhongKham = maPhongKham;
        this.tenPhongKham = tenPhongKham;
        this.trangThai = trangThai;
    }

    public PhongKhamModelTest(String maPhongKham, int soLuongBenhNhan) {
        this.maPhongKham = maPhongKham;
        this.soLuongBenhNhan = soLuongBenhNhan;
    }

    public int getSoLuongBenhNhan() {
        return soLuongBenhNhan;
    }

    public void setSoLuongBenhNhan(int soLuongBenhNhan) {
        this.soLuongBenhNhan = soLuongBenhNhan;
    }

    public String getMaPhongKham() {
        return maPhongKham;
    }

    public void setMaPhongKham(String maPhongKham) {
        this.maPhongKham = maPhongKham;
    }

    public String getTenPhongKham() {
        return tenPhongKham;
    }

    public void setTenPhongKham(String tenPhongKham) {
        this.tenPhongKham = tenPhongKham;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
