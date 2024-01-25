package models;

public class DichVuKhamBenhModel {

    private String maDichVu, tenDichVu, maNhomDichVu, tenNhomDichVu;
    private int giaTien, giaBaoHiem;
    private String trangThai;

    public DichVuKhamBenhModel(String maDichVu, String tenDichVu, String maNhomDichVu, String tenNhomDichVu, int giaTien, int giaBaoHiem, String trangThai) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.maNhomDichVu = maNhomDichVu;
        this.tenNhomDichVu = tenNhomDichVu;
        this.giaTien = giaTien;
        this.giaBaoHiem = giaBaoHiem;
        this.trangThai = trangThai;
    }

    public DichVuKhamBenhModel(String maDichVu, String tenDichVu, String maNhomDichVu, int giaTien, int giaBaoHiem, String trangThai) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.maNhomDichVu = maNhomDichVu;
        this.giaTien = giaTien;
        this.giaBaoHiem = giaBaoHiem;
        this.trangThai = trangThai;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getMaNhomDichVu() {
        return maNhomDichVu;
    }

    public void setMaNhomDichVu(String maNhomDichVu) {
        this.maNhomDichVu = maNhomDichVu;
    }

    public String getTenNhomDichVu() {
        return tenNhomDichVu;
    }

    public void setTenNhomDichVu(String tenNhomDichVu) {
        this.tenNhomDichVu = tenNhomDichVu;
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
