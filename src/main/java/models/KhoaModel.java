package models;

/**
 *
 * @author Phu Bao
 */
public class KhoaModel {
    private String maKhoa, tenKhoa, trangThai;
    private boolean trangThaiXoa;

    public KhoaModel() {
    }
    
    
    public KhoaModel(String tenKhoa, String trangThai) {
        this.tenKhoa = tenKhoa;
        this.trangThai = trangThai;
    }

    public KhoaModel(String maKhoa, String tenKhoa, String trangThai) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.trangThai = trangThai;
    }
    
    public KhoaModel(String maKhoa, String tenKhoa, String trangThai, boolean trangThaiXoa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.trangThai = trangThai;
        this.trangThaiXoa = trangThaiXoa;
    }
    
    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public boolean isTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(boolean trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }
  
    
    
}
