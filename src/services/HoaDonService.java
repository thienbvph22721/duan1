package services;

import java.sql.ResultSet;
import java.util.List;
import models.HoaDon;
import viewmodels.HoaDonView;

public interface HoaDonService {

    List<HoaDonView> getList();

    List<HoaDonView> getSearch(String ngayTao, String maHD);

    String add(HoaDon hd);

    HoaDonView getHDBYMa(String maHD);

    List<HoaDonView> getByTT(String ngay, String trangThai);

    boolean update(String maHD, HoaDon hd);

}
