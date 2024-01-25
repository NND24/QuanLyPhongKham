package models;

public class BenhNhanModel {

    private String maBenhNhan, hoTen, gioiTinh, namSinh, diaChi, canCuoc, bhyt, soDienThoai, ngheNghiep, danToc, quocTich;

    public BenhNhanModel(String maBenhNhan, String hoTen, String gioiTinh, String namSinh, String diaChi, String canCuoc, String bhyt, String soDienThoai, String ngheNghiep, String danToc, String quocTich) {
        this.maBenhNhan = maBenhNhan;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.canCuoc = canCuoc;
        this.bhyt = bhyt;
        this.soDienThoai = soDienThoai;
        this.ngheNghiep = ngheNghiep;
        this.danToc = danToc;
        this.quocTich = quocTich;
    }

    public BenhNhanModel(String maBenhNhan, String hoTen, String gioiTinh, String namSinh) {
        this.maBenhNhan = maBenhNhan;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
    }

    public BenhNhanModel(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
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

    public String getCanCuoc() {
        return canCuoc;
    }

    public void setCanCuoc(String canCuoc) {
        this.canCuoc = canCuoc;
    }

    public String getBhyt() {
        return bhyt;
    }

    public void setBhyt(String bhyt) {
        this.bhyt = bhyt;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

}
