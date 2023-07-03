package services.impl;

import java.util.List;
import models.KichThuoc;
import repositories.KichThuocRepository;
import repositories.impl.KichThuocRepositoryImpl;
import services.KichThuocService;

public class KichThuocServiceImpl implements KichThuocService {

    KichThuocRepository kichThuocRepository = new KichThuocRepositoryImpl();

    @Override
    public List<KichThuoc> getList() {
        return kichThuocRepository.getList();
    }

    @Override
    public String add(KichThuoc kt) {
        KichThuoc NewKT = kichThuocRepository.getKichThuocByTen(kt.getTenKichThuoc());
        if (kt.getTenKichThuoc().isEmpty()) {
            return "Tên thuộc tính không được để trống!";
        }
        if (NewKT != null) {
            return "Tên kích thước đã tồn tại!";
        }
        if (kichThuocRepository.add(kt)) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String delete(String tenKT) {
        if (kichThuocRepository.delete(tenKT)) {
            return "Xóa thành công!";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String update(String maKT, KichThuoc tenKT) {
        KichThuoc NewKT = kichThuocRepository.getKichThuocByTen(tenKT.getTenKichThuoc());
        if (tenKT.getTenKichThuoc().isEmpty()) {
            return "Tên thuộc tính không được để trống!";
        }
        if (NewKT != null) {
            return "Tên kích thước đã tồn tại!";
        }
        if (kichThuocRepository.update(maKT, tenKT)) {
            return "Cập nhật thành công!";
        } else {
            return "Cập nhật thất bại";
        }
    }
}
