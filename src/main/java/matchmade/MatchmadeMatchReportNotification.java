package matchmade;

import notification.Notification;

import java.util.List;

public class MatchmadeMatchReportNotification implements Notification
{
    private List<Integer> matchedClients;

    public MatchmadeMatchReportNotification(List<Integer> matchedClients)
    {
        this.matchedClients = matchedClients;
    }

    public List<Integer> getMatchedClients()
    {
        return matchedClients;
    }
}
