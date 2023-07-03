package repositories.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.KhachHang;
import repositories.KhachHangRepository;
import utilities.DBConnect;
import viewmodels.KhachHangView;

public class KhachHangRepositoryImpl implements KhachHangRepository {

    @Override
    public List<KhachHangView> getList() {
        List<KhachHangView> listKH = new ArrayList<>();
        String sql = "SELECT MaKhachHang,TenKhachHang,SoDienThoai,DiaChi FROM KhachHang";

        try {
            ResultSet rs = DBConnect.Query(sql);
            while (rs.next()) {
                KhachHangView kh = new KhachHangView();
                kh.setMaKhachHang(rs.getString(1));
                kh.setTenKhachHang(rs.getString(2));
                kh.setSoDienThoai(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                listKH.add(kh);
            }
            rs.getStatement().getConnection().close();
            return listKH;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public boolean update(String maKH, KhachHang kh) {
        String sql = "update KhachHang set TenKhachHang= ?,SoDienThoai=?,DiaChi=? where MaKhachHang =?";

        int row = 0;
        try {
            row = DBConnect.Update(sql, kh.getTenKhachHang(), kh.getSoDienThoai(), kh.getDiaChi(), maKH);
        } catch (Exception e) {
        }
        return row > 0;
    }

    @Override
    public boolean delete(String maKH) {
        String sql = "delete from KhachHang where MaKhachHang =?";
        int row = 0;
        try {
            row = DBConnect.Update(sql, maKH);
        } catch (Exception e) {
        }
        return row > 0;
    }

    @Override
    public List<KhachHangView> getSearch(String sdt, String tenKH) {
        List<KhachHangView> listKH = new ArrayList<>();
        String sql = "SELECT MaKhachHang,TenKhachHang,SoDienThoai,DiaChi FROM KhachHang WHERE  SoDienThoai LIKE ? OR  TenKhachHang LIKE ?";

        try {
            ResultSet rs = DBConnect.Query(sql, "%" + sdt + "%", "%" + tenKH + "%");
            while (rs.next()) {
               KhachHangView kh = new KhachHangView();
                kh.setMaKhachHang(rs.getString(1));
                kh.setTenKhachHang(rs.getString(2));
                kh.setSoDienThoai(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                listKH.add(kh);
            }
            rs.getStatement().getConnection().close();
            return listKH;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public boolean add(KhachHang kh) {
        String sql = "insert into KhachHang(TenKhachHang,SoDienThoai,DiaChi) values (?,?,?)";
        int row = 0;
        try {
            row = DBConnect.Update(sql, kh.getTenKhachHang(), kh.getSoDienThoai(), kh.getDiaChi());
        } catch (Exception e) {
        }

        return row > 0;
    }
}
