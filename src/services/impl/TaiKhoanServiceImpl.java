package services.impl;

import models.NhanVien;
import repositories.TaiKhoanRepository;
import repositories.impl.TaiKhoanRepositoryImpl;
import services.TaiKhoanService;

public class TaiKhoanServiceImpl implements TaiKhoanService {

    private TaiKhoanRepository taiKhoanRepository = new TaiKhoanRepositoryImpl();

    @Override
    public NhanVien login(String tenDangNhap, String matKhau) {
        return taiKhoanRepository.login(tenDangNhap, matKhau);
    }

    @Override
    public boolean updateMK(String maNV, String mKM) {
        return taiKhoanRepository.updateMK(maNV, mKM);
    }

    @Override
    public NhanVien quenMatKhau(String gmail) {
        return taiKhoanRepository.quenMatKhau(gmail);
    }

    @Override
    public boolean updateMKByEmail(String email,String mKM) {
        return taiKhoanRepository.updateMK(email,mKM);
    }

}
