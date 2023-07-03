package viewmodels;

import java.util.Date;

public class HoaDonView {

    private String maHoaDon;
    private String tenNhanVien;
    private String tenKhachHang;
    private Date ngayTao;
    private String tinhTrang;
    private String soDienThoai;
    private String diaChi;
    private double tienShip;
    private double tongTien;
    private String hTThanhToan;
    private String ghiChu;

    public HoaDonView() {
    }

    public HoaDonView(String maHoaDon, String tenNhanVien, String tenKhachHang, Date ngayTao, String tinhTrang, String soDienThoai, String diaChi, double tienShip, double tongTien, String hTThanhToan, String ghiChu) {
        this.maHoaDon = maHoaDon;
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.tienShip = tienShip;
        this.tongTien = tongTien;
        this.hTThanhToan = hTThanhToan;
        this.ghiChu = ghiChu;
    }



    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getTienShip() {
        return tienShip;
    }

    public void setTienShip(double tienShip) {
        this.tienShip = tienShip;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String gethTThanhToan() {
        return hTThanhToan;
    }

    public void sethTThanhToan(String hTThanhToan) {
        this.hTThanhToan = hTThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
