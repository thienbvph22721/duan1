package repositories.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.MauSac;
import repositories.MauSacRepository;
import utilities.DBConnect;

public class MauSacRepositoryImpl implements MauSacRepository {

    private final String select_All = "SELECT * FROM MauSac";
    private final String insert = "INSERT INTO MauSac(TenMauSac) VALUES (?)";
    private final String select_By_Name = "SELECT * FROM MauSac WHERE TenMauSac = ?";
    private final String delete = "DELETE FROM MauSac WHERE MaMauSac = ?";
    private final String update = "UPDATE MauSac SET TenMauSac = ? WHERE MaMauSac = ? ";

    @Override
    public List<MauSac> getList() {
        List<MauSac> listMS = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select_All);
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setMaMauSac(rs.getString(1));
                ms.setTenMauSac(rs.getString(2));
                listMS.add(ms);
            }
            rs.getStatement().getConnection().close();
            return listMS;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean add(MauSac ms) {
        int check = 0;
        try {
            check = DBConnect.Update(insert, ms.getTenMauSac());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

    @Override
    public boolean delete(String maMS) {
        int check = 0;
        try {
            check = DBConnect.Update(delete, maMS);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

    @Override
    public MauSac getMauSacByTen(String tenMS) {
        try {
            ResultSet rs = DBConnect.Query(select_By_Name, tenMS);
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setMaMauSac(rs.getString(1));
                ms.setTenMauSac(rs.getString(2));
                return ms;
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    public boolean update(String maMS, MauSac tenMS) {
        int check = 0;
        try {
            check = DBConnect.Update(update, tenMS.getTenMauSac(), maMS);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

}
