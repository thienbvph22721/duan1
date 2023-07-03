package repositories.impl;

import java.util.ArrayList;
import java.util.List;
import models.KhuyenMai;
import repositories.KhuyenMaiRepository;
import viewmodels.KhuyenMaiView;
import java.sql.*;
import utilities.DBConnect;

public class KhuyenMaiRepositoryImpl implements KhuyenMaiRepository {

    private final String select_All = "SELECT MaKhuyenMai,TenKhuyenMai,NgayBatDau,NgayKetThuc,GiamGia,KhuyenMai.TrangThai,SanPham.TenSanPham "
            + "FROM KhuyenMai JOIN SanPham ON KhuyenMai.MaSanPham = SanPham.MaSanPham";
    private final String insert = "INSERT INTO KhuyenMai(TenKhuyenMai,NgayBatDau,NgayKetThuc,GiamGia,TrangThai,MaSanPham) VALUES (?,?,?,?,?,?)";
    private final String update = "UPDATE KhuyenMai SET TenKhuyenMai = ?,NgayBatDau =?,NgayKetThuc=?,GiamGia=?,TrangThai = ?,MaSanPham =? WHERE MaKhuyenMai = ?";
    private final String delete = "DELETE FROM KhuyenMai WHERE MaKhuyenMai LIKE ?";
    private final String search = "SELECT MaKhuyenMai,TenKhuyenMai,NgayBatDau,NgayKetThuc,GiamGia,KhuyenMai.TrangThai,SanPham.TenSanPham \n" +
"FROM KhuyenMai JOIN SanPham ON KhuyenMai.MaSanPham = SanPham.MaSanPham\n" +
"WHERE TenKhuyenMai LIKE ? OR SanPham.TenSanPham LIKE ?";
    @Override
    public List<KhuyenMaiView> getList() {
        List<KhuyenMaiView> listKM = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select_All);
            while (rs.next()) {
                KhuyenMaiView km = new KhuyenMaiView();
                km.setMaKhuyenMai(rs.getString(1));
                km.setTenKhuyenMai(rs.getString(2));
                km.setNgayBatDau(rs.getDate(3));
                km.setNgayKetThuc(rs.getDate(4));
                km.setGiamGia(rs.getInt(5));
                km.setTrangThai(rs.getInt(6));
                km.setTenSanPham(rs.getString(7));
                listKM.add(km);
            }
            rs.getStatement().getConnection().close();
            return listKM;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean insert(KhuyenMai km) {
        int check = 0;
        try {
            check = DBConnect.Update(insert, km.getTenKhuyenMai(), km.getNgayBatDau(), km.getNgayKetThuc(), km.getGiamGia(), km.getTrangThai(), km.getMaSanPham());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }
        return check > 0;
    }

    @Override
    public boolean update(String maKM, KhuyenMai km) {
        int check = 0;
        try {
            check = DBConnect.Update(update, km.getTenKhuyenMai(), km.getNgayBatDau(), km.getNgayKetThuc(), km.getGiamGia(), km.getTrangThai(), km.getMaSanPham(),maKM);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

    @Override
    public boolean delete(String maKM) {
         int check = 0;
        try {
            check = DBConnect.Update(delete,maKM);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }
        return check > 0;
    }

    @Override
    public List<KhuyenMaiView> getSearch(String tenKM, String tenSP) {
List<KhuyenMaiView> listKM = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(search,"%"+tenKM+"%","%"+tenSP+"%");
            while (rs.next()) {
                KhuyenMaiView km = new KhuyenMaiView();
                km.setMaKhuyenMai(rs.getString(1));
                km.setTenKhuyenMai(rs.getString(2));
                km.setNgayBatDau(rs.getDate(3));
                km.setNgayKetThuc(rs.getDate(4));
                km.setGiamGia(rs.getInt(5));
                km.setTrangThai(rs.getInt(6));
                km.setTenSanPham(rs.getString(7));
                listKM.add(km);
            }
            rs.getStatement().getConnection().close();
            return listKM;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
