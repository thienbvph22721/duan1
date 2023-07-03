package repositories.impl;

import repositories.TaiKhoanRepository;
import utilities.DBConnect;
import java.sql.*;
import models.NhanVien;

public class TaiKhoanRepositoryImpl implements TaiKhoanRepository {

    @Override
    public NhanVien login(String tenDangNhap, String matKhau) {

        String sql = "SELECT MaNhanVien,TenNhanVien,MatKhau,VaiTro FROM NhanVien WHERE MaNhanVien LIKE ? AND MatKhau LIKE ?";
        NhanVien nv = null;
        try {
            ResultSet rs = DBConnect.Query(sql, tenDangNhap, matKhau);
            if (rs.next()) {
                nv = new NhanVien();
                nv.setMaNhanVien(rs.getString(1));
                nv.setTenNhanVien(rs.getString(2));
                nv.setMatKhau(rs.getString(3));
                nv.setVaiTro(rs.getBoolean(4));
            }
            rs.getStatement().getConnection().close();
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateMK(String maNV, String mKM) {
        String sql = "UPDATE NhanVien SET MatKhau = ? WHERE MaNhanVien LIKE ?";
        int check = 0;
        try {
            check = DBConnect.Update(sql, mKM, maNV);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

    @Override
    public NhanVien quenMatKhau(String gmail) {

        String sql = "SELECT MaNhanVien,MatKhau,VaiTro FROM NhanVien WHERE Email LIKE ?";
        NhanVien nv = null;
        try {
            ResultSet rs = DBConnect.Query(sql,gmail);
            if (rs.next()) {
                nv = new NhanVien();
                nv.setMaNhanVien(rs.getString(1));
                nv.setMatKhau(rs.getString(2));
                nv.setVaiTro(rs.getBoolean(3));
            }
            rs.getStatement().getConnection().close();
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateMKByEmail(String email,String mKM) {
         String sql = "UPDATE NhanVien SET MatKhau = ? WHERE Email LIKE ?";
        int check = 0;
        try {
            check = DBConnect.Update(sql,mKM,email);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

}
