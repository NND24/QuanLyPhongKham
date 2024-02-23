package models;

/**
 *
 * @author Phu Bao
 */
public class QuanLyModel {
    private String maQuanLy, email, hoTen, gioiTinh, diaChi, namSinh, soDienThoai, canCuoc, anh;
    private boolean trangThaiXoa;

    public QuanLyModel() {
    }

    public QuanLyModel(String email, String hoTen, String gioiTinh, String diaChi, String namSinh, String soDienThoai, String canCuoc, String anh) {
        this.email = email;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.namSinh = namSinh;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.anh = anh;
    }
    
    public QuanLyModel(String hoTen, String gioiTinh, String diaChi, String namSinh, String soDienThoai, String canCuoc, String anh) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.namSinh = namSinh;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.anh = anh;
    }
    
    public QuanLyModel(String maQuanLy, String email, String hoTen, String gioiTinh, String diaChi, String namSinh, String soDienThoai, String canCuoc, String anh) {
        this.maQuanLy = maQuanLy;
        this.email = email;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.namSinh = namSinh;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.anh = anh;
    }
    
    public QuanLyModel(String maQuanLy, String email, String hoTen, String gioiTinh, String diaChi, String namSinh, String soDienThoai, String canCuoc, String anh, boolean trangThaiXoa) {
        this.maQuanLy = maQuanLy;
        this.email = email;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.namSinh = namSinh;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.anh = anh;
        this.trangThaiXoa = trangThaiXoa;
    }

    public String getMaQuanLy() {
        return maQuanLy;
    }

    public void setMaQuanLy(String maQuanLy) {
        this.maQuanLy = maQuanLy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getCanCuoc() {
        return canCuoc;
    }

    public void setCanCuoc(String canCuoc) {
        this.canCuoc = canCuoc;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public boolean isTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(boolean trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }
       
}
