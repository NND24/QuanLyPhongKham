package models;

/**
 *
 * @author Phu Bao
 */
public class BacSiModel {
    private String maBacSi, email, maKhoa, tenKhoa, hoTen, gioiTinh, namSinh, diaChi, soDienThoai, canCuoc, trinhDo, anh;
    private boolean trangThaiXoa;

    public BacSiModel() {
    }

    public BacSiModel(String maBacSi, String email, String maKhoa, String tenKhoa, String hoTen, String gioiTinh, String namSinh, String diaChi, String soDienThoai, String canCuoc, String trinhDo, String anh, boolean trangThaiXoa) {
        this.maBacSi = maBacSi;
        this.email = email;
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.trinhDo = trinhDo;
        this.anh = anh;
        this.trangThaiXoa = trangThaiXoa;
    }

    public BacSiModel(String maBacSi, String email, String maKhoa, String tenKhoa, String hoTen, String gioiTinh, String namSinh, String diaChi, String soDienThoai, String canCuoc, String trinhDo, String anh) {
        this.maBacSi = maBacSi;
        this.email = email;
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.trinhDo = trinhDo;
        this.anh = anh;
    }
    
    public BacSiModel(String email, String maKhoa, String hoTen, String gioiTinh, String namSinh, String diaChi, String soDienThoai, String canCuoc, String trinhDo, String anh) {
        this.email = email;
        this.maKhoa = maKhoa;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.trinhDo = trinhDo;
        this.anh = anh;
    }
    
    public BacSiModel(String maKhoa, String hoTen, String gioiTinh, String namSinh, String diaChi, String soDienThoai, String canCuoc, String trinhDo, String anh) {
        this.maKhoa = maKhoa;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.trinhDo = trinhDo;
        this.anh = anh;
    }
    
    public BacSiModel(String maBacSi, String email, String maKhoa, String hoTen, String gioiTinh, String namSinh, String diaChi, String soDienThoai, String canCuoc, String trinhDo, String anh) {
        this.maBacSi = maBacSi;
        this.email = email;
        this.maKhoa = maKhoa;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.trinhDo = trinhDo;
        this.anh = anh;
    }
    
    
    

    public String getMaBacSi() {
        return maBacSi;
    }

    public void setMaBacSi(String maBacSi) {
        this.maBacSi = maBacSi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setCanCuoc(String canCuoc) {
        this.canCuoc = canCuoc;
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

    public boolean isTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(boolean trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }
    
    
    
}
