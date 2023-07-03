package repositories;

import java.util.List;
import models.ChatLieu;

public interface ChatLieuRepository {

    List<ChatLieu> getList();

    boolean add(ChatLieu cl);

    boolean update(String maCL, ChatLieu tenCL);

    boolean delete(String tenCL);

    ChatLieu getChatLieuByTen(String tenCL);
}
