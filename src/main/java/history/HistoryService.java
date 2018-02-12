package history;

import notification.Notification;

import java.util.List;

/**
 * Created by annterina on 12.02.18.
 */
public interface HistoryService {

    void addToHistory(Notification notification);
    List<Notification> getHistory();

}
