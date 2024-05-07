package models;

public class DichVuKhamBenhModel {

    private String maDichVuKB, tenDichVuKB, maNhomDichVuKB, tenNhomDichVuKB;
    private int giaTien, giaBaoHiem;
    private String trangThai;

    public DichVuKhamBenhModel(String maDichVuKB, String tenDichVuKB, String maNhomDichVuKB, String tenNhomDichVuKB, int giaTien, int giaBaoHiem, String trangThai) {
        this.maDichVuKB = maDichVuKB;
        this.tenDichVuKB = tenDichVuKB;
        this.maNhomDichVuKB = maNhomDichVuKB;
        this.tenNhomDichVuKB = tenNhomDichVuKB;
        this.giaTien = giaTien;
        this.giaBaoHiem = giaBaoHiem;
        this.trangThai = trangThai;
    }

    public DichVuKhamBenhModel(String maDichVuKB, String tenDichVuKB, String maNhomDichVuKB, int giaTien, int giaBaoHiem, String trangThai) {
        this.maDichVuKB = maDichVuKB;
        this.tenDichVuKB = tenDichVuKB;
        this.maNhomDichVuKB = maNhomDichVuKB;
        this.giaTien = giaTien;
        this.giaBaoHiem = giaBaoHiem;
        this.trangThai = trangThai;
    }

    public String getMaDichVuKB() {
        return maDichVuKB;
    }

    public void setMaDichVuKB(String maDichVuKB) {
        this.maDichVuKB = maDichVuKB;
    }

    public String getTenDichVuKB() {
        return tenDichVuKB;
    }

    public void setTenDichVuKB(String tenDichVuKB) {
        this.tenDichVuKB = tenDichVuKB;
    }

    public String getMaNhomDichVuKB() {
        return maNhomDichVuKB;
    }

    public void setMaNhomDichVuKB(String maNhomDichVuKB) {
        this.maNhomDichVuKB = maNhomDichVuKB;
    }

    public String getTenNhomDichVuKB() {
        return tenNhomDichVuKB;
    }

    public void setTenNhomDichVuKB(String tenNhomDichVuKB) {
        this.tenNhomDichVuKB = tenNhomDichVuKB;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public int getGiaBaoHiem() {
        return giaBaoHiem;
    }

    public void setGiaBaoHiem(int giaBaoHiem) {
        this.giaBaoHiem = giaBaoHiem;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
