package repositories;

import java.util.List;
import models.KhachHang;
import viewmodels.KhachHangView;

public interface KhachHangRepository {

    List<KhachHangView> getList();

    boolean add(KhachHang kh);

    boolean update(String maKH,KhachHang kh);

    boolean delete(String maKH);

    List<KhachHangView> getSearch(String sdt, String tenKH);
}
