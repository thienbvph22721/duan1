package services.impl;

import java.util.List;
import models.SanPham;
import repositories.SanPhamRepository;
import repositories.impl.SanPhamRepositoryImpl;
import services.SanPhamService;
import viewmodels.SanPhamViewModel;

public class SanPhamServiceImpl implements SanPhamService {

    private final SanPhamRepository sanPhamRepository = new SanPhamRepositoryImpl();

    @Override
    public List<SanPhamViewModel> getList(int thangThai) {
        return sanPhamRepository.getList(thangThai);
    }

    @Override
    public String add(SanPham sp) {
        if (sanPhamRepository.add(sp)) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

    @Override
    public List<SanPhamViewModel> getSearch(String tenSP) {
        return sanPhamRepository.getSearch(tenSP);
    }

    @Override
    public String update(String maSP, SanPham sp) {
        if (sanPhamRepository.update(maSP, sp)) {
            return "Sửa thành công!";
        } else {
            return "Sửa thất bại!";
        }
    }

//    @Override
//    public SanPham getSanPhamByMa(String maSP) {
//        return sanPhamRepository.getSanPhamByMa(maSP);
//    }
    @Override
    public String hide(int trangThai, String maSP) {
        if (sanPhamRepository.hide(trangThai, maSP)) {
            return "Ẩn thành công!";
        } else {
            return "Ẩn thất bại!";
        }
    }

    @Override
    public List<SanPhamViewModel> getSanPhamByMaLSP(String tenLSP) {
        return sanPhamRepository.getSanPhamByMaLSP(tenLSP);
    }

    @Override
    public SanPham getSanPhamByMa(String maSP) {
        return sanPhamRepository.getSanPhamByMa(maSP);
    }

    @Override
    public int updateSLSP(String maSP, int soLuong) {
        return sanPhamRepository.updateSLSP(maSP, soLuong);
    }

    @Override
    public int updateSLGH(String maSP, int soLuong) {
        return sanPhamRepository.updateSLGH(maSP, soLuong);
    }

    @Override
    public SanPhamViewModel getSanPhamByMaSP(String maSP) {
        return sanPhamRepository.getSanPhamByMaSP(maSP);
    }

}
