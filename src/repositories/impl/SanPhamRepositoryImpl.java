package repositories.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import models.SanPham;
import repositories.SanPhamRepository;
import utilities.DBConnect;
import viewmodels.SanPhamViewModel;

public class SanPhamRepositoryImpl implements SanPhamRepository {

    private final String select_All = "SELECT MaSanPham,TenSanPham,LoaiSanPham.TenLoaiSanPham, MauSac.TenMauSac,KichThuoc.TenKichThuoc,ChatLieu.TenChatLieu,GiaBan,SoLuong \n"
            + "FROM SanPham JOIN LoaiSanPham ON SanPham.MaLoaiSanPham = LoaiSanPham.MaLoaiSanPham \n"
            + "JOIN MauSac ON SanPham.MaMauSac = MauSac.MaMauSac \n"
            + "JOIN ChatLieu ON SanPham.MaChatLieu = ChatLieu.MaChatLieu \n"
            + "JOIN KichThuoc ON SanPham.MaKichThuoc = KichThuoc.MaKichThuoc Where TrangThai LIKE ?";
    private final String insert = "INSERT INTO SanPham(TenSanPham,MaLoaiSanPham,MaMauSac,MaKichThuoc,MaChatLieu,GiaBan,SoLuong)VALUES (?,?,?,?,?,?,?);";
    private final String search = "SELECT MaSanPham,TenSanPham,LoaiSanPham.TenLoaiSanPham, MauSac.TenMauSac,KichThuoc.TenKichThuoc,ChatLieu.TenChatLieu,GiaBan,SoLuong \n"
            + "FROM SanPham JOIN LoaiSanPham ON SanPham.MaLoaiSanPham = LoaiSanPham.MaLoaiSanPham \n"
            + "JOIN MauSac ON SanPham.MaMauSac = MauSac.MaMauSac \n"
            + "JOIN ChatLieu ON SanPham.MaChatLieu = ChatLieu.MaChatLieu \n"
            + "JOIN KichThuoc ON SanPham.MaKichThuoc = KichThuoc.MaKichThuoc WHERE TenSanPham LIKE ?";
    private final String update = "UPDATE SanPham SET TenSanPham = ?,MaLoaiSanPham = ?,MaMauSac =?,MaKichThuoc=?,MaChatLieu=?,GiaBan=?,SoLuong=? WHERE MaSanPham = ?";
    private final String hide = "UPDATE SanPham SET TrangThai=? WHERE MaSanPham = ?";
    private final String select_By_Id = "SELECT SanPham.MaSanPham,TenSanPham,GiaBan,SoLuong FROM SanPham WHERE MaSanPham LIKE ?";
    private final String select_By_MaLSP = "SELECT MaSanPham,TenSanPham,LoaiSanPham.TenLoaiSanPham, MauSac.TenMauSac,KichThuoc.TenKichThuoc,ChatLieu.TenChatLieu,GiaBan,SoLuong \n"
            + "            FROM SanPham JOIN LoaiSanPham ON SanPham.MaLoaiSanPham = LoaiSanPham.MaLoaiSanPham \n"
            + "            JOIN MauSac ON SanPham.MaMauSac = MauSac.MaMauSac \n"
            + "            JOIN ChatLieu ON SanPham.MaChatLieu = ChatLieu.MaChatLieu \n"
            + "           JOIN KichThuoc ON SanPham.MaKichThuoc = KichThuoc.MaKichThuoc WHERE LoaiSanPham.TenLoaiSanPham LIKE ?";

    @Override

    public List<SanPhamViewModel> getList(int TrangThai) {
        List<SanPhamViewModel> listSPVM = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select_All, TrangThai);
            while (rs.next()) {
                SanPhamViewModel sp = new SanPhamViewModel();
                sp.setMaSanPham(rs.getString(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setTenLoaiSP(rs.getString(3));
                sp.setTenMauSac(rs.getString(4));
                sp.setTenKichThuoc(rs.getString(5));
                sp.setTenChatLieu(rs.getString(6));
                sp.setGiaBan(rs.getDouble(7));
                sp.setSoLuong(rs.getInt(8));
                listSPVM.add(sp);
            }
            rs.getStatement().getConnection().close();
            return listSPVM;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean add(SanPham sp) {
        int check = 0;
        try {
            check = DBConnect.Update(insert, sp.getTenSanPham(), sp.getMaLoaiSP(), sp.getMaMauSac(), sp.getMaKichThuoc(), sp.getMaChatLieu(), sp.getDonGia(), sp.getSoLuong());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

    @Override
    public boolean update(String maSP, SanPham sp) {
        int check = 0;
        try {
            check = DBConnect.Update(update, sp.getTenSanPham(), sp.getMaLoaiSP(), sp.getMaMauSac(), sp.getMaKichThuoc(), sp.getMaChatLieu(), sp.getDonGia(), sp.getSoLuong(), maSP);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

    @Override
    public boolean hide(int trangThai, String maSP) {
        int check = 0;
        try {
            check = DBConnect.Update(hide, trangThai, maSP);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

    @Override
    public List<SanPhamViewModel> getSearch(String tenSP) {
        List<SanPhamViewModel> listSP = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(search, "%" + tenSP + "%");
            while (rs.next()) {
                SanPhamViewModel sp = new SanPhamViewModel();
                sp.setMaSanPham(rs.getString(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setTenLoaiSP(rs.getString(3));
                sp.setTenMauSac(rs.getString(4));
                sp.setTenKichThuoc(rs.getString(5));
                sp.setTenChatLieu(rs.getString(6));
                sp.setGiaBan(rs.getDouble(7));
                sp.setSoLuong(rs.getInt(8));
                listSP.add(sp);
            }
            rs.getStatement().getConnection().close();
            return listSP;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public SanPham getSanPhamByMa(String maSP) {
        try {
            ResultSet rs = DBConnect.Query(select_By_Id, maSP);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setDonGia(rs.getDouble(3));
                sp.setSoLuong(rs.getInt(4));
                return sp;
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;

    }

    @Override
    public List<SanPhamViewModel> getSanPhamByMaLSP(String maSP) {
        List<SanPhamViewModel> listSPVM = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select_By_MaLSP, maSP);
            while (rs.next()) {
                SanPhamViewModel sp = new SanPhamViewModel();
                sp.setMaSanPham(rs.getString(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setTenLoaiSP(rs.getString(3));
                sp.setTenMauSac(rs.getString(4));
                sp.setTenKichThuoc(rs.getString(5));
                sp.setTenChatLieu(rs.getString(6));
                sp.setGiaBan(rs.getDouble(7));
                sp.setSoLuong(rs.getInt(8));
                listSPVM.add(sp);
            }
            rs.getStatement().getConnection().close();
            return listSPVM;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int updateSLSP(String maSP, int soLuong) {
        String sql = "UPDATE SanPham SET SoLuong = (SoLuong - ?) WHERE MaSanPham LIKE ?";
        try {
            return DBConnect.Update(sql, soLuong, maSP);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int updateSLGH(String maSP, int soLuong) {
        String sql = "UPDATE SanPham SET SoLuong = (SoLuong + ?) WHERE MaSanPham LIKE ?";
        try {
            return DBConnect.Update(sql, soLuong, maSP);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public SanPhamViewModel getSanPhamByMaSP(String maSP) {
        String select_By_MaSP = "SELECT MaSanPham,TenSanPham,LoaiSanPham.TenLoaiSanPham, MauSac.TenMauSac,KichThuoc.TenKichThuoc,ChatLieu.TenChatLieu,GiaBan,SoLuong \n"
                + "            FROM SanPham JOIN LoaiSanPham ON SanPham.MaLoaiSanPham = LoaiSanPham.MaLoaiSanPham \n"
                + "            JOIN MauSac ON SanPham.MaMauSac = MauSac.MaMauSac \n"
                + "            JOIN ChatLieu ON SanPham.MaChatLieu = ChatLieu.MaChatLieu \n"
                + "           JOIN KichThuoc ON SanPham.MaKichThuoc = KichThuoc.MaKichThuoc WHERE MaSanPham LIKE ?";
        try {
            ResultSet rs = DBConnect.Query(select_By_MaSP, maSP);
            while (rs.next()) {
                SanPhamViewModel sp = new SanPhamViewModel();
                sp.setMaSanPham(rs.getString(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setTenLoaiSP(rs.getString(3));
                sp.setTenMauSac(rs.getString(4));
                sp.setTenKichThuoc(rs.getString(5));
                sp.setTenChatLieu(rs.getString(6));
                sp.setGiaBan(rs.getDouble(7));
                sp.setSoLuong(rs.getInt(8));
                return sp;
            }
            rs.getStatement().getConnection().close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }
}
