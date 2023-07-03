
package services;

import models.NhanVien;


public interface TaiKhoanService {
    NhanVien login(String tenDangNhap, String matKhau);
    
    boolean updateMK(String maNV, String mKM);
    
     NhanVien quenMatKhau(String gmail);
     
     boolean updateMKByEmail(String email,String mKM);
}
