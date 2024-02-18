package models;

import java.sql.Date;

public class XepGiuongModel {
    private String maXepGiuong, maGiuong, maBenhAn, maBenhNhan, tenBenhNhan, xuatVien, maPhong, tenPhong, tenLoaiPhong;
    private Date ngayNhapVien, ngayXuatVien;
    private int soNgay, thanhTien;

    public XepGiuongModel() {
    }

    public XepGiuongModel(String maXepGiuong, String maBenhAn, Date ngayNhapVien) {
        this.maXepGiuong = maXepGiuong;
        this.maBenhAn = maBenhAn;
        this.ngayNhapVien = ngayNhapVien;
    }
    
    public XepGiuongModel(String maXepGiuong, String maGiuong, String maBenhAn, String maBenhNhan, String tenBenhNhan, String maPhong, String tenPhong, Date ngayNhapVien) {
        this.maXepGiuong = maXepGiuong;
        this.maGiuong = maGiuong;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.ngayNhapVien = ngayNhapVien;
    }

    public XepGiuongModel(String maGiuong, String maPhong, String tenPhong, String tenLoaiPhong) {
        this.maGiuong = maGiuong;
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.tenLoaiPhong = tenLoaiPhong;
    }
    
    public XepGiuongModel(String maXepGiuong, String maGiuong, String maBenhAn, String maBenhNhan, String tenBenhNhan, String xuatVien, String maPhong, String tenPhong, Date ngayNhapVien, Date ngayXuatVien, int soNgay, int thanhTien) {
        this.maXepGiuong = maXepGiuong;
        this.maGiuong = maGiuong;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.xuatVien = xuatVien;
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayXuatVien = ngayXuatVien;
        this.soNgay = soNgay;
        this.thanhTien = thanhTien;
    }

    public XepGiuongModel(String maXepGiuong, String maGiuong, String maBenhAn, String maBenhNhan, String tenBenhNhan, String xuatVien, String maPhong, String tenPhong, String tenLoaiPhong, Date ngayNhapVien, Date ngayXuatVien, int soNgay, int thanhTien) {
        this.maXepGiuong = maXepGiuong;
        this.maGiuong = maGiuong;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.xuatVien = xuatVien;
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayXuatVien = ngayXuatVien;
        this.soNgay = soNgay;
        this.thanhTien = thanhTien;
    }
    
    public String getMaXepGiuong() {
        return maXepGiuong;
    }

    public void setMaXepGiuong(String maXepGiuong) {
        this.maXepGiuong = maXepGiuong;
    }

    public String getMaGiuong() {
        return maGiuong;
    }

    public void setMaGiuong(String maGiuong) {
        this.maGiuong = maGiuong;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getXuatVien() {
        return xuatVien;
    }

    public void setXuatVien(String xuatVien) {
        this.xuatVien = xuatVien;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public Date getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(Date ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public Date getNgayXuatVien() {
        return ngayXuatVien;
    }

    public void setNgayXuatVien(Date ngayXuatVien) {
        this.ngayXuatVien = ngayXuatVien;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }       
}
