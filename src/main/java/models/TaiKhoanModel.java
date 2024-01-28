package models;

public class TaiKhoanModel {
    private String email, maChucVu, matKhau;

    public TaiKhoanModel() {
    }

    public TaiKhoanModel(String email, String maChucVu, String matKhau) {
        this.email = email;
        this.maChucVu = maChucVu;
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
