package models;

public class SanPham {
    private int idSanPham;
    private String maSanPham;
    private String tenSanPham;
    private String maLoaiSP;
    private String maMauSac;
    private String maKichThuoc;
    private String maChatLieu;
    private double donGia;
    private int soLuong;
    private int trangThai;
    private String moTa;

    public SanPham() {
    }

    public SanPham(int idSanPham, String maSanPham, String tenSanPham, String maLoaiSP, String maMauSac, String maKichThuoc, String maChatLieu, double donGia, int soLuong, int trangThai, String moTa) {
        this.idSanPham = idSanPham;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.maLoaiSP = maLoaiSP;
        this.maMauSac = maMauSac;
        this.maKichThuoc = maKichThuoc;
        this.maChatLieu = maChatLieu;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMaLoaiSP() {
        return maLoaiSP;
    }

    public void setMaLoaiSP(String maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public String getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(String maMauSac) {
        this.maMauSac = maMauSac;
    }

    public String getMaKichThuoc() {
        return maKichThuoc;
    }

    public void setMaKichThuoc(String maKichThuoc) {
        this.maKichThuoc = maKichThuoc;
    }

    public String getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(String maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    
    
   
}
