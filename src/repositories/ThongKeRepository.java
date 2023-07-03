package repositories;

import java.util.List;
import viewmodels.ThongKeView;

public interface ThongKeRepository {

    List<ThongKeView> getList(int nam);

    List<ThongKeView> getTongDonHang(String ngayBD, String ngayKT);

    List<ThongKeView> getTongDonHangByTrangThai(String ngayBD, String ngayKT, String trangThai);

    List<ThongKeView> doanhThuNgay(String ngayBD, String ngayKT);

    List<ThongKeView> doanhThuThang(String nam, String thang);

    List<ThongKeView> getDonHangThang(String nam, String thang, String trangThai);
    
    List<ThongKeView> doanhThuNam(String nam);
}
