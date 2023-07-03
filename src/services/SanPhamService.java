package services;

import java.util.List;
import models.SanPham;
import viewmodels.SanPhamViewModel;

public interface SanPhamService {

    List<SanPhamViewModel> getList(int TrangThai);

    String add(SanPham sp);

    List<SanPhamViewModel> getSearch(String tenSP);

    String update(String maSP, SanPham sp);

    List<SanPhamViewModel> getSanPhamByMaLSP(String tenLSP);

    String hide(int trangThai, String maSP);

    SanPham getSanPhamByMa(String maSP);

    int updateSLSP(String maSP, int soLuong);

    int updateSLGH(String maSP, int soLuong);
    
    SanPhamViewModel getSanPhamByMaSP(String maSP);

}
