package repositories.impl;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.LoaiSanPham;
import repositories.LoaiSPRepository;
import utilities.DBConnect;

public class LoaiSPRepositoryImpl implements LoaiSPRepository {

    private final String select_All = "SELECT * FROM LoaiSanPham";
    private final String insert = "INSERT INTO LoaiSanPham(TenLoaiSanPham) VALUES (?)";
    private final String select_By_Name = "SELECT * FROM LoaiSanPham WHERE TenLoaiSanPham = ?";
    private final String delete = "DELETE FROM LoaiSanPham WHERE MaLoaiSanPham = ?";
    private final String update = "UPDATE LoaiSanPham SET TenLoaiSanPham = ? WHERE MaLoaiSanPham = ? ";

    @Override
    public List<LoaiSanPham> getList() {
        List<LoaiSanPham> listLSP = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select_All);
            while (rs.next()) {
                LoaiSanPham lsp = new LoaiSanPham();
                lsp.setMaLoaiSP(rs.getString(1));
                lsp.setTenLoaiSP(rs.getString(2));
                listLSP.add(lsp);
            }
            rs.getStatement().getConnection().close();
            return listLSP;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean add(LoaiSanPham lsp) {
        int check = 0;
        try {
            check = DBConnect.Update(insert, lsp.getTenLoaiSP());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }
        return check > 0;
    }

    @Override
    public boolean delete(String maLSP) {
        int check = 0;
        try {
            check = DBConnect.Update(delete, maLSP);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

    @Override
    public LoaiSanPham getLoaiSanPhamByTen(String tenLSP) {
        try {
            ResultSet rs = DBConnect.Query(select_By_Name, tenLSP);
            while (rs.next()) {
                LoaiSanPham kt = new LoaiSanPham();
                kt.setMaLoaiSP(rs.getString(1));
                kt.setTenLoaiSP(rs.getString(2));
                return kt;
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    public boolean update(String maLSP, LoaiSanPham tenLSP) {
        int check = 0;
        try {
            check = DBConnect.Update(update, tenLSP.getTenLoaiSP(), maLSP);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }
}
