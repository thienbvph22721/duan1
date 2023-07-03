package repositories.impl;

import repositories.*;
import java.util.ArrayList;
import java.util.List;
import viewmodels.ThongKeView;
import java.sql.*;

import utilities.DBConnect;

public class ThongKeRepositoryImpl implements ThongKeRepository {

    @Override
    public List<ThongKeView> getList(int nam) {
        List<ThongKeView> listTK = new ArrayList<>();
        String sql = "SELECT MONTH(NgayTao),SUM(TongTien) AS 'TongTien' FROM HoaDon WHERE YEAR(NgayTao) LIKE ? GROUP BY MONTH(NgayTao),TongTien ORDER BY MONTH(NgayTao)";
        try {
            ResultSet rs = DBConnect.Query(sql, nam);
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setThang(rs.getString(1));
                tk.setDoanhThu(rs.getDouble(2));
                listTK.add(tk);
            }
            rs.getStatement().getConnection().close();
            return listTK;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ThongKeView> getTongDonHang(String ngayBD, String ngayKT) {
        List<ThongKeView> listTK = new ArrayList<>();
        String sql = "SELECT COUNT(TinhTrang) FROM HoaDon WHERE NgayTao BETWEEN ? AND ?";
        try {
            ResultSet rs = DBConnect.Query(sql, ngayBD, ngayKT);
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setSoLuongDon(rs.getInt(1));
                listTK.add(tk);
            }
            rs.getStatement().getConnection().close();
            return listTK;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ThongKeView> getTongDonHangByTrangThai(String ngayBD, String ngayKT, String trangThai) {
        List<ThongKeView> listTK = new ArrayList<>();
        String sql = "SELECT COUNT(TinhTrang) FROM HoaDon WHERE (NgayTao BETWEEN ? AND ?) AND TinhTrang LIKE ?";
        try {
            ResultSet rs = DBConnect.Query(sql, ngayBD, ngayKT, "%" + trangThai + "%");
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setSoLuongDon(rs.getInt(1));
                listTK.add(tk);
            }
            rs.getStatement().getConnection().close();
            return listTK;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ThongKeView> doanhThuNgay(String ngayBD, String ngayKT) {
        List<ThongKeView> listTK = new ArrayList<>();
        String sql = "SELECT SUM(TongTien) AS 'TongTien' FROM HoaDon WHERE (NgayTao BETWEEN ? AND ?)";
        try {
            ResultSet rs = DBConnect.Query(sql, ngayBD, ngayKT);
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setDoanhThu(rs.getDouble(1));
                listTK.add(tk);
            }
            rs.getStatement().getConnection().close();
            return listTK;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ThongKeView> doanhThuThang(String nam, String thang) {
          List<ThongKeView> listTK = new ArrayList<>();
        String sql = "SELECT SUM(TongTien) AS 'TongTien' FROM HoaDon WHERE YEAR(NgayTao) LIKE ? AND MONTH(NgayTao) LIKE ?";
        try {
            ResultSet rs = DBConnect.Query(sql, nam,thang);
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setDoanhThu(rs.getDouble(1));
                listTK.add(tk);
            }
            rs.getStatement().getConnection().close();
            return listTK;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ThongKeView> getDonHangThang(String nam, String thang, String trangThai) {
            List<ThongKeView> listTK = new ArrayList<>();
        String sql = "SELECT COUNT(TinhTrang) FROM HoaDon WHERE YEAR(NgayTao) LIKE ? AND MONTH(NgayTao) LIKE ? AND TinhTrang LIKE ?";
        try {
            ResultSet rs = DBConnect.Query(sql, nam,thang,"%"+trangThai+"%");
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setSoLuongDon(rs.getInt(1));
                listTK.add(tk);
            }
            rs.getStatement().getConnection().close();
            return listTK;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ThongKeView> doanhThuNam(String nam) {
List<ThongKeView> listTK = new ArrayList<>();
        String sql = "SELECT SUM(TongTien) AS 'TongTien' FROM HoaDon WHERE YEAR(NgayTao) LIKE ?";
        try {
            ResultSet rs = DBConnect.Query(sql, nam);
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setDoanhThu(rs.getDouble(1));
                listTK.add(tk);
            }
            rs.getStatement().getConnection().close();
            return listTK;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
