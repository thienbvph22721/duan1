package services.impl;

import java.util.List;
import models.LoaiSanPham;
import repositories.LoaiSPRepository;
import repositories.impl.LoaiSPRepositoryImpl;
import services.LoaiSPService;

public class LoaiSPServiceImpl implements LoaiSPService {

    LoaiSPRepository loaiSPRepository = new LoaiSPRepositoryImpl();

    @Override
    public List<LoaiSanPham> getList() {
        return loaiSPRepository.getList();
    }

    @Override
    public String add(LoaiSanPham lsp) {
        LoaiSanPham NewLSP = loaiSPRepository.getLoaiSanPhamByTen(lsp.getTenLoaiSP());
        if (lsp.getTenLoaiSP().isEmpty()) {
            return "Tên thược tính không được để trống!";
        }
        if (NewLSP != null) {
            return "Tên loại sản phẩm đã tồn tại!";
        }
        if (loaiSPRepository.add(lsp)) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

    @Override
    public String delete(String tenLSP) {
        if (loaiSPRepository.delete(tenLSP)) {
            return "Xóa thành công!";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String update(String maLSP, LoaiSanPham tenLSP) {
        LoaiSanPham NewLSP = loaiSPRepository.getLoaiSanPhamByTen(tenLSP.getTenLoaiSP());
        if (tenLSP.getTenLoaiSP().isEmpty()) {
            return "Tên thược tính không được để trống!";
        }
        if (NewLSP != null) {
            return "Tên loại sản phẩm đã tồn tại!";
        }
        if (loaiSPRepository.update(maLSP, tenLSP)) {
            return "Cập nhật thành công!";
        } else {
            return "Cập nhật thất bại";
        }
    }

}
