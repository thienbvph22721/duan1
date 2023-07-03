package repositories.impl;

import java.util.ArrayList;
import java.util.List;
import repositories.ChiTietHoaDonRepository;
import java.sql.*;
import models.ChiTietHoaDon;
import utilities.DBConnect;
import viewmodels.ChiTietHoaDonView;

public class ChiTietHoaDonRepositoryImpl implements ChiTietHoaDonRepository {

    private final String select = "SELECT SanPham.MaSanPham,SanPham.TenSanPham,ChiTietHoaDon.SoLuong,ChiTietHoaDon.DonGia,ChiTietHoaDon.GiamGia,ChiTietHoaDon.ThanhTien\n"
            + "FROM ChiTietHoaDon JOIN SanPham ON ChiTietHoaDon.MaSanPham = SanPham.MaSanPham WHERE MaHoaDon LIKE ?";
    private final String selectGH = "SELECT SanPham.MaSanPham,SanPham.TenSanPham,ChiTietHoaDon.SoLuong,ChiTietHoaDon.DonGia,KhuyenMai.GiamGia,ChiTietHoaDon.ThanhTien\n"
            + "            FROM ChiTietHoaDon JOIN SanPham ON ChiTietHoaDon.MaSanPham = SanPham.MaSanPham JOIN KhuyenMai ON SanPham.MaSanPham = KhuyenMai.MaSanPham WHERE SanPham.MaSanPham LIKE ?";

    @Override
    public List<ChiTietHoaDonView> getList(String maHD) {
        List<ChiTietHoaDonView> listCTHDV = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select, maHD);
            while (rs.next()) {
                ChiTietHoaDonView cthdv = new ChiTietHoaDonView();
                cthdv.setMaSanPham(rs.getString(1));
                cthdv.setTenSanPham(rs.getString(2));
                cthdv.setSoLuong(rs.getInt(3));
                cthdv.setDonGia(rs.getDouble(4));
                cthdv.setGiamGia(rs.getInt(5));
                cthdv.setThanhTien(rs.getDouble(6));
                listCTHDV.add(cthdv);
            }
            rs.getStatement().getConnection().close();
            return listCTHDV;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<ChiTietHoaDonView> getCTHoaDonByMaSP(String maSP) {
        List<ChiTietHoaDonView> listCTHDV = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(selectGH, maSP);
            while (rs.next()) {
                ChiTietHoaDonView cthdv = new ChiTietHoaDonView();
                cthdv.setMaSanPham(rs.getString(1));
                cthdv.setTenSanPham(rs.getString(2));
                cthdv.setSoLuong(rs.getInt(3));
                cthdv.setDonGia(rs.getDouble(4));
                cthdv.setGiamGia(rs.getInt(5));
                cthdv.setThanhTien(rs.getDouble(6));
                listCTHDV.add(cthdv);
            }
            rs.getStatement().getConnection().close();
            return listCTHDV;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean add(ChiTietHoaDon cthd) {
        int check = 0;
        String sql = "INSERT INTO ChiTietHoaDon(MaHoaDon,MaSanPham,SoLuong,DonGia,ThanhTien) VALUES(?,?,?,?,?)";
        try {
            check = DBConnect.Update(sql,cthd.getMaHoaDon(),cthd.getMaSanPham(),cthd.getSoLuong(),cthd.getDonGia(),cthd.getThanhTien());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

}
