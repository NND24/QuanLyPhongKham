package models;

import java.sql.Date;

public class DangKyBenhNhanModel extends DangKyModel {

    private String hoTen, gioiTinh, namSinh, tenPhongKham, tenDichVuKB;

    public DangKyBenhNhanModel(String hoTen, String gioiTinh, String namSinh, String maDangKy, String maBenhNhan, String maDichVuKB, String maPhongKham, String lyDoKham, int thuTuKham, Date ngayKham, String trangThai) {
        super(maDangKy, maBenhNhan, maDichVuKB, maPhongKham, lyDoKham, thuTuKham, ngayKham, trangThai);
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
    }

    public DangKyBenhNhanModel(String hoTen, String gioiTinh, String namSinh, String maDangKy, String maBenhNhan, String maDichVuKB, String maPhongKham, String lyDoKham, int thuTuKham, Date ngayKham, String trangThai, String tenPhongKham, String tenDichVuKB) {
        super(maDangKy, maBenhNhan, maDichVuKB, maPhongKham, lyDoKham, thuTuKham, ngayKham, trangThai);
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.tenPhongKham = tenPhongKham;
        this.tenDichVuKB = tenDichVuKB;
    }

    public String getTenPhongKham() {
        return tenPhongKham;
    }

    public void setTenPhongKham(String tenPhongKham) {
        this.tenPhongKham = tenPhongKham;
    }

    public String getTenDichVuKB() {
        return tenDichVuKB;
    }

    public void setTenDichVuKB(String tenDichVuKB) {
        this.tenDichVuKB = tenDichVuKB;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

}
