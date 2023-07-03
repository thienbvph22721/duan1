
package repositories;

import java.util.List;
import models.KichThuoc;


public interface KichThuocRepository {
    List<KichThuoc> getList();
    
    boolean add(KichThuoc kt);
    
    boolean update(String maKT,KichThuoc tenKT);
    
    boolean delete(String tenKT);

    KichThuoc getKichThuocByTen(String tenKT);
}
