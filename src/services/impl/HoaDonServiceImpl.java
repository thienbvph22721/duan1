package services.impl;

import java.util.List;
import models.HoaDon;
import repositories.HoaDonRepository;
import repositories.impl.HoaDonRepositoryImpl;
import services.HoaDonService;
import viewmodels.HoaDonView;

public class HoaDonServiceImpl implements HoaDonService {

    private final HoaDonRepository hoaDonRepository = new HoaDonRepositoryImpl();

    @Override
    public List<HoaDonView> getList() {
        return hoaDonRepository.getList();
    }

    @Override
    public List<HoaDonView> getSearch(String ngayTao, String maHD) {
        return hoaDonRepository.getSearch(ngayTao, maHD);

    }

    @Override
    public String add(HoaDon hd) {
        if (hoaDonRepository.add(hd)) {
            return "Thanh toán thành công!";
        } else {
            return "Thanh toán thất bại!";
        }
    }

    @Override
    public boolean update(String maHD, HoaDon hd) {
        return hoaDonRepository.update(maHD, hd);

    }

    @Override
    public HoaDonView getHDBYMa(String maHD) {
        return hoaDonRepository.getHDBYMa(maHD);
    }

    @Override
    public List<HoaDonView> getByTT(String ngay, String trangThai) {
        return hoaDonRepository.getByTT(ngay, trangThai);
    }

}
