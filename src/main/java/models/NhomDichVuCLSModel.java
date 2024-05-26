package models;

public class NhomDichVuCLSModel {

    private String maNhomDichVuCLS, tenNhomDichVuCLS, trangThai;

    public NhomDichVuCLSModel(String maNhomDichVuCLS) {
        this.maNhomDichVuCLS = maNhomDichVuCLS;
    }

    public NhomDichVuCLSModel(String maNhomDichVuCLS, String tenNhomDichVuCLS) {
        this.maNhomDichVuCLS = maNhomDichVuCLS;
        this.tenNhomDichVuCLS = tenNhomDichVuCLS;
    }

    public NhomDichVuCLSModel(String maNhomDichVuCLS, String tenNhomDichVuCLS, String trangThai) {
        this.maNhomDichVuCLS = maNhomDichVuCLS;
        this.tenNhomDichVuCLS = tenNhomDichVuCLS;
        this.trangThai = trangThai;
    }

    public String getMaNhomDichVuCLS() {
        return maNhomDichVuCLS;
    }

    public void setMaNhomDichVuCLS(String maNhomDichVuCLS) {
        this.maNhomDichVuCLS = maNhomDichVuCLS;
    }

    public String getTenNhomDichVuCLS() {
        return tenNhomDichVuCLS;
    }

    public void setTenNhomDichVuCLS(String tenNhomDichVuCLS) {
        this.tenNhomDichVuCLS = tenNhomDichVuCLS;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
