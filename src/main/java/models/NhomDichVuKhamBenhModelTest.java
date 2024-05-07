package models;

public class NhomDichVuKhamBenhModelTest {

    private String maNhomDichVuKB, tenNhomDichVuKB, trangThai;

    public NhomDichVuKhamBenhModelTest(String maNhomDichVuKB) {
        this.maNhomDichVuKB = maNhomDichVuKB;
    }

    public NhomDichVuKhamBenhModelTest(String maNhomDichVuKB, String tenNhomDichVuKB) {
        this.maNhomDichVuKB = maNhomDichVuKB;
        this.tenNhomDichVuKB = tenNhomDichVuKB;
    }

    public NhomDichVuKhamBenhModelTest(String maNhomDichVuKB, String tenNhomDichVuKB, String trangThai) {
        this.maNhomDichVuKB = maNhomDichVuKB;
        this.tenNhomDichVuKB = tenNhomDichVuKB;
        this.trangThai = trangThai;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
