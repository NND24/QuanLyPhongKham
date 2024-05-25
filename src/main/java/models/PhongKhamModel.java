package models;

public class PhongKhamModel {

    private String maPhongKham, tenPhongKham, trangThai;
    private int soLuong;

    public PhongKhamModel(String maPhongKham, String tenPhongKham, String trangThai, int soLuong) {
        this.maPhongKham = maPhongKham;
        this.tenPhongKham = tenPhongKham;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
    }

    public PhongKhamModel(String maPhongKham, String tenPhongKham, String trangThai) {
        this.maPhongKham = maPhongKham;
        this.tenPhongKham = tenPhongKham;
        this.trangThai = trangThai;
    }

    public PhongKhamModel(String maPhongKham, int soLuong) {
        this.maPhongKham = maPhongKham;
        this.soLuong = soLuong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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
