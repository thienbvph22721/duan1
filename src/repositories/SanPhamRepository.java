package repositories;

import java.util.List;
import models.SanPham;
import viewmodels.SanPhamViewModel;

public interface SanPhamRepository {

    List<SanPhamViewModel> getList(int trangThai);

    boolean add(SanPham sp);

    boolean update(String maSP, SanPham tenSP);

    boolean hide(int trangThai, String maSP);

    List<SanPhamViewModel> getSearch(String tenSP);

    List<SanPhamViewModel> getSanPhamByMaLSP(String tenLSP);

   SanPhamViewModel getSanPhamByMaSP(String maSP);

    SanPham getSanPhamByMa(String maSP);

    int updateSLSP(String maSP, int soLuong);

    int updateSLGH(String maSP, int soLuong);

}
