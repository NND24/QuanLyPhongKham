package models;

public class DichVuKhamBenhModel extends NhomDichVuKhamBenhModel {

    private String maDichVuKB, tenDichVuKB;
    private int giaTien, giaBaoHiem;
    private String trangThai;

    public DichVuKhamBenhModel(String maDichVuKB, String tenDichVuKB, int giaTien, int giaBaoHiem, String trangThai, String maNhomDichVuKB) {
        super(maNhomDichVuKB);
        this.maDichVuKB = maDichVuKB;
        this.tenDichVuKB = tenDichVuKB;
        this.giaTien = giaTien;
        this.giaBaoHiem = giaBaoHiem;
        this.trangThai = trangThai;
    }

    public DichVuKhamBenhModel(String maDichVuKB, String tenDichVuKB, int giaTien, int giaBaoHiem, String trangThai, String maNhomDichVuKB, String tenNhomDichVuKB) {
        super(maNhomDichVuKB, tenNhomDichVuKB);
        this.maDichVuKB = maDichVuKB;
        this.tenDichVuKB = tenDichVuKB;
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
