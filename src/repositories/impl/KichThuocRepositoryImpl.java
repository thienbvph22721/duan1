package repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.KichThuoc;
import repositories.KichThuocRepository;
import utilities.DBConnect;

public class KichThuocRepositoryImpl implements KichThuocRepository {

    private final String select_All = "SELECT * FROM KichThuoc";
    private final String select_By_Name = "SELECT * FROM KichThuoc WHERE TenKichThuoc = ?";
    private final String insert = "INSERT INTO KichThuoc(TenKichThuoc) VALUES (?);";
    private final String delete = "DELETE FROM KichThuoc WHERE MaKichThuoc = ?";
    private final String update = "UPDATE KichThuoc SET TenKichThuoc = ? WHERE MaKichThuoc = ? ";

    @Override
    public List<KichThuoc> getList() {
        List<KichThuoc> listKT = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select_All);
            while (rs.next()) {
                KichThuoc kt = new KichThuoc();
                kt.setMaKichThuoc(rs.getString(1));
                kt.setTenKichThuoc(rs.getString(2));
                listKT.add(kt);
            }
            rs.getStatement().getConnection().close();
            return listKT;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean add(KichThuoc kt) {
        int check = 0;
        try {
            check = DBConnect.Update(insert, kt.getTenKichThuoc());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

    @Override
    public boolean delete(String maKT) {
        int check = 0;
        try {
            check = DBConnect.Update(delete, maKT);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

    @Override
    public KichThuoc getKichThuocByTen(String tenKT) {
        try {
            ResultSet rs = DBConnect.Query(select_By_Name, tenKT);
            while (rs.next()) {
                KichThuoc kt = new KichThuoc();
                kt.setMaKichThuoc(rs.getString(1));
                kt.setTenKichThuoc(rs.getString(2));
                return kt;
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    public boolean update(String maKT, KichThuoc tenKT) {
        int check = 0;
        try {
            check = DBConnect.Update(update, tenKT.getTenKichThuoc(), maKT);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }
}
