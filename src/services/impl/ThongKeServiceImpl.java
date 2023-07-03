package services.impl;

import java.util.List;
import repositories.ThongKeRepository;
import repositories.impl.ThongKeRepositoryImpl;
import services.ThongKeService;
import viewmodels.ThongKeView;

public class ThongKeServiceImpl implements ThongKeService {

    private ThongKeRepository thongKeRepository = new ThongKeRepositoryImpl();

    @Override
    public List<ThongKeView> getList(int nam) {
        return thongKeRepository.getList(nam);
    }

    @Override
    public List<ThongKeView> getTongDonHang(String ngayBD, String ngayKT) {
        return thongKeRepository.getTongDonHang(ngayBD, ngayKT);
    }

    @Override
    public List<ThongKeView> getTongDonHangByTrangThai(String ngayBD, String ngayKT, String trangThai) {
        return thongKeRepository.getTongDonHangByTrangThai(ngayBD, ngayKT, trangThai);
    }

    @Override
    public List<ThongKeView> doanhThuNgay(String ngayBD, String ngayKT) {
        return thongKeRepository.doanhThuNgay(ngayBD, ngayKT);
    }

    @Override
    public List<ThongKeView> doanhThuThang(String nam, String thang) {
        return thongKeRepository.doanhThuThang(nam, thang);
    }

    @Override
    public List<ThongKeView> getDonHangThang(String nam, String thang, String trangThai) {
        return thongKeRepository.getDonHangThang(nam, thang, trangThai);
    }

    @Override
    public List<ThongKeView> doanhThuNam(String nam) {
return thongKeRepository.doanhThuNam(nam);
    }
}
