package services;

import java.util.List;
import models.KichThuoc;

public interface KichThuocService {

    List<KichThuoc> getList();

    String add(KichThuoc kt);

    String update(String maKT, KichThuoc tenKT);
    
    String delete(String tenKT);
    
}
