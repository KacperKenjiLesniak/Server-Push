package messenger;

import history.HistoryService;
import notification.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by annterina on 12.02.18.
 */
public class MessengerHistoryService implements HistoryService {

    private List<Notification> notifications = new ArrayList<>();

    @Override
    public void addToHistory(Notification notification) {
        notifications.add(notification);
    }

    @Override
    public List<Notification> getHistory() {
        return notifications;
    }
}
