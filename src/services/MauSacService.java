package services;

import java.util.List;
import models.MauSac;

public interface MauSacService {

    List<MauSac> getList();

    String add(MauSac ms);

    String update(String maMS, MauSac tenMS);

    String delete(String maMS);

}
