package repositories;

import java.util.List;
import models.KhuyenMai;
import viewmodels.KhuyenMaiView;

public interface KhuyenMaiRepository {

    List<KhuyenMaiView> getList();

    boolean insert(KhuyenMai km);

    boolean update(String maKM, KhuyenMai km);

    boolean delete(String maKM);

    List<KhuyenMaiView> getSearch(String tenKM, String tenSP);
}
