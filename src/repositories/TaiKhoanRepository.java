
package repositories;

import models.NhanVien;


public interface TaiKhoanRepository {
    NhanVien login(String tenDangNhap, String matKhau);
    
    boolean updateMK(String maNV,String mKM);
    
    boolean updateMKByEmail(String email,String mKM);
    
    NhanVien quenMatKhau(String gmail);
}
