
package repositories;

import java.util.List;
import models.ChiTietHoaDon;
import viewmodels.ChiTietHoaDonView;


public interface ChiTietHoaDonRepository {
    
    List<ChiTietHoaDonView> getList(String maHD);
    
    List<ChiTietHoaDonView> getCTHoaDonByMaSP(String maSP);
    
    boolean add(ChiTietHoaDon cthd);
}
