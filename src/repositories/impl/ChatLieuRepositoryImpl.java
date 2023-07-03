package repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.ChatLieu;
import repositories.ChatLieuRepository;
import utilities.DBConnect;

public class ChatLieuRepositoryImpl implements ChatLieuRepository {

    private final String select_All = "SELECT * FROM ChatLieu";
    private final String insert = "INSERT INTO ChatLieu(TenChatLieu) VALUES (?)";
    private final String select_By_Name = "SELECT * FROM ChatLieu WHERE TenChatLieu = ?";
    private final String delete = "DELETE FROM ChatLieu WHERE MaChatLieu = ?";
    private final String update = "UPDATE ChatLieu SET TenChatLieu = ? WHERE MaChatLieu = ? ";

    @Override
    public List<ChatLieu> getList() {
        List<ChatLieu> listCL = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select_All);
            while (rs.next()) {
                ChatLieu cl = new ChatLieu();
                cl.setMaChatLieu(rs.getString(1));
                cl.setTenChatLieu(rs.getString(2));
                listCL.add(cl);
            }
            rs.getStatement().getConnection().close();
            return listCL;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean add(ChatLieu cl) {
        int check = 0;
        try {
            check = DBConnect.Update(insert, cl.getTenChatLieu());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

    @Override
    public boolean delete(String maCL) {
        int check = 0;
        try {
            check = DBConnect.Update(delete, maCL);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

    @Override
    public ChatLieu getChatLieuByTen(String tenCL) {
        try {
            ResultSet rs = DBConnect.Query(select_By_Name, tenCL);
            while (rs.next()) {
                ChatLieu kt = new ChatLieu();
                kt.setMaChatLieu(rs.getString(1));
                kt.setTenChatLieu(rs.getString(2));
                return kt;
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    public boolean update(String maCL, ChatLieu tenCL) {
        int check = 0;
        try {
            check = DBConnect.Update(update, tenCL.getTenChatLieu(), maCL);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }
}
