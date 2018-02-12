package image;

import history.HistoryService;
import notification.Notification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by annterina on 12.02.18.
 */
public class ImageHistoryService implements HistoryService {

    private Map<String, List<Notification>> notifications = new HashMap<>();

    @Override
    public void addToHistory(Notification notification) {
        ImageNotification imageNotification = (ImageNotification) notification;
        String receiverName = imageNotification.getReceiverName();
        if (notifications.containsKey(receiverName)) {
            notifications.get(receiverName).add(notification);
        } else {
            List<Notification> newNotifications = new ArrayList<>();
            newNotifications.add(notification);
            notifications.put(receiverName, newNotifications);
        }
    }

    @Override
    public List<Notification> getHistory() {
        List<Notification> allNotifications = new ArrayList<>();
        notifications.forEach((key, value) -> allNotifications.addAll(value));
        return allNotifications;
    }
}
