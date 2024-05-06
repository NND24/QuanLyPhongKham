package models;

/**
 *
 * @author Phu Bao
 */
public class TaiKhoanCaNhanModel {
    private String ma, maChucVu, matKhau, tenChucVu, email, hoTen, gioiTinh, namSinh, diaChi, soDienThoai, canCuoc, trinhDo, anh;

    public TaiKhoanCaNhanModel() {
    }
    
    public TaiKhoanCaNhanModel(String ma, String maChucVu, String matKhau, String email, String hoTen, String gioiTinh, String namSinh, String diaChi, String soDienThoai, String canCuoc, String anh) {
        this.ma = ma;
        this.maChucVu = maChucVu;
        this.matKhau = matKhau;
        this.email = email;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.anh = anh;
    }

    public TaiKhoanCaNhanModel(String ma, String maChucVu, String matKhau, String email, String hoTen, String gioiTinh, String namSinh, String diaChi, String soDienThoai, String canCuoc, String trinhDo, String anh) {
        this.ma = ma;
        this.maChucVu = maChucVu;
        this.matKhau = matKhau;
        this.email = email;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.trinhDo = trinhDo;
        this.anh = anh;
    }
    
    public TaiKhoanCaNhanModel(String ma, String maChucVu, String matKhau, String tenChucVu, String email, String hoTen, String gioiTinh, String namSinh, String diaChi, String soDienThoai, String canCuoc, String trinhDo, String anh) {
        this.ma = ma;
        this.maChucVu = maChucVu;
        this.matKhau = matKhau;
        this.tenChucVu = tenChucVu;
        this.email = email;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.trinhDo = trinhDo;
        this.anh = anh;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
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

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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

    public void setCanCuoc(String cacnCuoc) {
        this.canCuoc = cacnCuoc;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

}
