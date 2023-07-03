package repositories;

import java.util.List;
import models.LoaiSanPham;

public interface LoaiSPRepository {

    List<LoaiSanPham> getList();

    boolean add(LoaiSanPham lsp);

    boolean update(String maLSP, LoaiSanPham tenLSP);

    boolean delete(String tenLSP);

    LoaiSanPham getLoaiSanPhamByTen(String tenLSP);
}
