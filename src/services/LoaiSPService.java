package services;

import java.util.List;
import models.LoaiSanPham;

public interface LoaiSPService {

    List<LoaiSanPham> getList();

    String add(LoaiSanPham lsp);

    String update(String maLSP, LoaiSanPham tenLSP);

    String delete(String tenLSP);
}
