package repositories;

import java.util.List;
import models.NhanVien;
import viewmodels.NhanVienViewModel;

public interface NhanVienRepository {

    List<NhanVienViewModel> getList(int trangThai);

    boolean add(NhanVien nv);

    boolean update(String maNV, NhanVien nv);

    boolean delete(String maNV);

    List<NhanVienViewModel> getSearch(String tenNV,String sdt,int trangThai);
    

}
