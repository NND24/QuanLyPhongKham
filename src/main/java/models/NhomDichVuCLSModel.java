package models;

public class NhomDichVuCLSModel {

    private String maNhomDichVu, tenNhomDichVu, trangThai;

    public NhomDichVuCLSModel(String maNhomDichVu, String tenNhomDichVu, String trangThai) {
        this.maNhomDichVu = maNhomDichVu;
        this.tenNhomDichVu = tenNhomDichVu;
        this.trangThai = trangThai;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
