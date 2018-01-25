package matchmade;

import notification.Notification;

public class MatchmadeEnrollmentNotification implements Notification
{
    private int clientID;

    public MatchmadeEnrollmentNotification(int clientID)
    {
        this.clientID = clientID;
    }

    public int getClientID()
    {
        return clientID;
    }
}
