package repositories;

import java.util.List;
import models.HoaDon;
import viewmodels.HoaDonView;
import java.sql.*;

public interface HoaDonRepository {

    boolean add(HoaDon hd);

    boolean update(String maHD, HoaDon hd);

    List<HoaDonView> getList();

    List<HoaDonView> getSearch(String ngayTao, String maHD);

    List<HoaDonView> getByTT(String ngay, String trangThai);

    HoaDonView getHDBYMa(String maHD);

}
