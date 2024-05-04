package models;

public class NhomThuocModelTest {

    private String maNhomThuoc, tenNhomThuoc, trangThai;

    public NhomThuocModelTest(String maNhomThuoc, String tenNhomThuoc, String trangThai) {
        this.maNhomThuoc = maNhomThuoc;
        this.tenNhomThuoc = tenNhomThuoc;
        this.trangThai = trangThai;
    }

    public String getMaNhomThuoc() {
        return maNhomThuoc;
    }

    public void setMaNhomThuoc(String maNhomThuoc) {
        this.maNhomThuoc = maNhomThuoc;
    }

    public String getTenNhomThuoc() {
        return tenNhomThuoc;
    }

    public void setTenNhomThuoc(String tenNhomThuoc) {
        this.tenNhomThuoc = tenNhomThuoc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
