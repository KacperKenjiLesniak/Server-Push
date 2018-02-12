package matchmade;

import history.HistoryService;
import notification.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by annterina on 12.02.18.
 */
public class MatchmadeHistoryService implements HistoryService {

    @Override
    public void addToHistory(Notification notification) {

    }

    @Override
    public List<Notification> getHistory() {
        return new ArrayList<>();
    }
}
