package services.impl;

import java.util.List;
import models.KhachHang;
import repositories.KhachHangRepository;
import repositories.impl.KhachHangRepositoryImpl;
import services.KhachHangService;
import viewmodels.KhachHangView;

public class KhachHangServiceImpl implements KhachHangService {

    private final KhachHangRepository khachHangRepository = new KhachHangRepositoryImpl();

    @Override
    public List<KhachHangView> getList() {
        return khachHangRepository.getList();
    }

    @Override
    public String add(KhachHang kh) {
        if (khachHangRepository.add(kh)) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

    @Override
    public String update(String maKH, KhachHang kh) {
        if (khachHangRepository.update(maKH, kh)) {
            return "Sửa thành công!";
        } else {
            return "Sửa thất bại!";
        }
    }

    @Override
    public String delete(String maKH) {
        if (khachHangRepository.delete(maKH)) {
            return "Xóa thành công!";
        } else {
            return "Xóa thất bại!";
        }
    }

    @Override
    public List<KhachHangView> getSearch(String sdt, String tenKH) {
        return khachHangRepository.getSearch(sdt, tenKH);
    }
}
