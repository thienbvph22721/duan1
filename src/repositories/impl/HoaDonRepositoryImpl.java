package repositories.impl;

import java.util.ArrayList;
import java.util.List;
import repositories.HoaDonRepository;
import viewmodels.HoaDonView;
import java.sql.*;
import models.HoaDon;

import utilities.DBConnect;

public class HoaDonRepositoryImpl implements HoaDonRepository {

    private final String select = "SELECT MaHoaDon,NhanVien.TenNhanVien,KhachHang.TenKhachHang,KhachHang.DiaChi,KhachHang.SoDienThoai"
            + ",NgayTao,TongTien,HTThanhToan,HoaDon.TinhTrang,GhiChu\n"
            + "FROM  HoaDon JOIN NhanVien ON HoaDon.MaNhanVien = NhanVien.MaNhanVien JOIN KhachHang\n"
            + "ON HoaDon.MaKhachHang = KhachHang.MaKhachHang";
    private final String search = "SELECT MaHoaDon,NhanVien.TenNhanVien,KhachHang.TenKhachHang,NgayTao,HoaDon.TinhTrang\n"
            + "FROM  HoaDon JOIN NhanVien ON HoaDon.MaNhanVien = NhanVien.MaNhanVien JOIN KhachHang\n"
            + "ON HoaDon.MaKhachHang = KhachHang.MaKhachHang WHERE NgayTao LIKE ? OR MaHoaDon LIKE ?";
//    @Override
//    public boolean add(HoaDon hd) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public List<HoaDonView> getList() {
        List<HoaDonView> listHDV = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select);
            while (rs.next()) {
                HoaDonView hd = new HoaDonView();
                hd.setMaHoaDon(rs.getString(1));
                hd.setTenNhanVien(rs.getString(2));
                hd.setTenKhachHang(rs.getString(3));
                hd.setDiaChi(rs.getString(4));
                hd.setSoDienThoai(rs.getString(5));
                hd.setNgayTao(rs.getDate(6));
                hd.setTongTien(rs.getDouble(7));
                hd.sethTThanhToan(rs.getString(8));
                hd.setTinhTrang(rs.getString(9));
                hd.setGhiChu(rs.getString(10));
                listHDV.add(hd);
            }
            rs.getStatement().getConnection().close();
            return listHDV;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<HoaDonView> getSearch(String ngayTao, String maHD) {
        List<HoaDonView> listHDV = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(search, "%" + ngayTao + "%", "%" + maHD + "%");
            while (rs.next()) {
                HoaDonView hd = new HoaDonView();
                hd.setMaHoaDon(rs.getString(1));
                hd.setTenNhanVien(rs.getString(2));
                hd.setTenKhachHang(rs.getString(3));
                hd.setNgayTao(rs.getDate(4));
                hd.setTinhTrang(rs.getString(5));
                listHDV.add(hd);
            }
            rs.getStatement().getConnection().close();
            return listHDV;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean add(HoaDon hd) {
        int check = 0;
        String sql = "INSERT INTO HoaDon(MaNhanVien,MaKhachHang,NgayTao,TinhTrang) VALUES(?,?,?,?)";
        try {
            check = DBConnect.Update(sql, hd.getMaNhanVien(), hd.getMaKhachHang(), hd.getNgayTao(), hd.getTinhTrang());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(String maHD, HoaDon hd) {
        int check = 0;
        String sql = "UPDATE HoaDon SET MaKhachHang = ?,NgayTao =?,TongTien = ?,HTThanhToan =?,TinhTrang = ?,GhiChu = ? WHERE MaHoaDon LIKE ?";
        try {
            check = DBConnect.Update(sql, hd.getMaKhachHang(), hd.getNgayTao(), hd.getTongTien(), hd.gethTThanhToan(), hd.getTinhTrang(), hd.getGhiChu(), maHD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public HoaDonView getHDBYMa(String maHD) {
        String sql = "SELECT MaHoaDon,NhanVien.TenNhanVien,KhachHang.TenKhachHang,NgayTao\n"
                + "FROM  HoaDon JOIN NhanVien ON HoaDon.MaNhanVien = NhanVien.MaNhanVien JOIN KhachHang\n"
                + "ON HoaDon.MaKhachHang = KhachHang.MaKhachHang WHERE MaHoaDon LIKE ?";
        try {
            ResultSet rs = DBConnect.Query(sql, maHD);
            while (rs.next()) {
                HoaDonView hd = new HoaDonView();
                hd.setMaHoaDon(rs.getString(1));
                hd.setTenNhanVien(rs.getString(2));
                hd.setTenKhachHang(rs.getString(3));
                hd.setNgayTao(rs.getDate(4));
                return hd;
            }
            rs.getStatement().getConnection().close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    public List<HoaDonView> getByTT(String ngay, String trangThai) {
        String sql = "SELECT MaHoaDon,NhanVien.TenNhanVien,KhachHang.TenKhachHang,NgayTao,HoaDon.TinhTrang\n" +
"                FROM  HoaDon JOIN NhanVien ON HoaDon.MaNhanVien = NhanVien.MaNhanVien JOIN KhachHang\n" +
"                ON HoaDon.MaKhachHang = KhachHang.MaKhachHang WHERE NgayTao = ? AND HoaDon.TinhTrang  = ?";
        List<HoaDonView> listHD = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(sql, ngay, trangThai);
            while (rs.next()) {
                HoaDonView hd = new HoaDonView();
                hd.setMaHoaDon(rs.getString(1));
                hd.setTenNhanVien(rs.getString(2));
                hd.setTenKhachHang(rs.getString(3));
                hd.setNgayTao(rs.getDate(4));
                hd.setTinhTrang(rs.getString(5));
                listHD.add(hd);
            }
            rs.getStatement().getConnection().close();
            return listHD;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
