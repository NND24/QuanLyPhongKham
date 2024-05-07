package models;

public class DichVuCLSModelTest extends NhomDichVuCLSModelTest {

    private String maDichVuCLS, tenDichVuCLS;
    private int giaTien, giaBaoHiem;
    private String trangThai;

    public DichVuCLSModelTest(String maDichVuCLS, String tenDichVuCLS, String maNhomDichVuCLS, String tenNhomDichVuCLS, int giaTien, int giaBaoHiem, String trangThai) {
        super(maNhomDichVuCLS, tenNhomDichVuCLS);
        this.maDichVuCLS = maDichVuCLS;
        this.tenDichVuCLS = tenDichVuCLS;
        this.giaTien = giaTien;
        this.giaBaoHiem = giaBaoHiem;
        this.trangThai = trangThai;
    }

    public DichVuCLSModelTest(String maDichVuCLS, String tenDichVuCLS, String maNhomDichVuCLS, int giaTien, int giaBaoHiem, String trangThai) {
        super(maNhomDichVuCLS);
        this.maDichVuCLS = maDichVuCLS;
        this.tenDichVuCLS = tenDichVuCLS;
        this.giaTien = giaTien;
        this.giaBaoHiem = giaBaoHiem;
        this.trangThai = trangThai;
    }

    public String getMaDichVuCLS() {
        return maDichVuCLS;
    }

    public void setMaDichVuCLS(String maDichVuCLS) {
        this.maDichVuCLS = maDichVuCLS;
    }

    public String getTenDichVuCLS() {
        return tenDichVuCLS;
    }

    public void setTenDichVuCLS(String tenDichVuCLS) {
        this.tenDichVuCLS = tenDichVuCLS;
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
