package models;

import java.sql.Date;

public class DangKyModel {

    private String maDangKy, maBenhNhan, maDichVuKB, tenDichVuKham, maPhongKham, tenPhongKham, lyDoKham;
    private int thuTuKham;
    private Date ngayKham;
    private String trangThai;

    public DangKyModel(String maDangKy, String maBenhNhan, String maDichVuKB, String maPhongKham, String lyDoKham, int thuTuKham, Date ngayKham, String trangThai) {
        this.maDangKy = maDangKy;
        this.maBenhNhan = maBenhNhan;
        this.maDichVuKB = maDichVuKB;
        this.maPhongKham = maPhongKham;
        this.lyDoKham = lyDoKham;
        this.thuTuKham = thuTuKham;
        this.ngayKham = ngayKham;
        this.trangThai = trangThai;
    }

    public DangKyModel(String maDangKy, String maDichVuKB, String maPhongKham, String lyDoKham, String trangThai) {
        this.maDangKy = maDangKy;
        this.maDichVuKB = maDichVuKB;
        this.maPhongKham = maPhongKham;
        this.lyDoKham = lyDoKham;
        this.trangThai = trangThai;
    }

    public DangKyModel(String maDangKy, String trangThai) {
        this.maDangKy = maDangKy;
        this.trangThai = trangThai;
    }

    public String getMaDangKy() {
        return maDangKy;
    }

    public void setMaDangKy(String maDangKy) {
        this.maDangKy = maDangKy;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getMaDichVuKB() {
        return maDichVuKB;
    }

    public void setMaDichVuKB(String maDichVuKB) {
        this.maDichVuKB = maDichVuKB;
    }

    public String getTenDichVuKham() {
        return tenDichVuKham;
    }

    public void setTenDichVuKham(String tenDichVuKham) {
        this.tenDichVuKham = tenDichVuKham;
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

    public String getLyDoKham() {
        return lyDoKham;
    }

    public void setLyDoKham(String lyDoKham) {
        this.lyDoKham = lyDoKham;
    }

    public int getThuTuKham() {
        return thuTuKham;
    }

    public void setThuTuKham(int thuTuKham) {
        this.thuTuKham = thuTuKham;
    }

    public Date getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
