package matchmade;

import notification.Notification;
import request.RequestProcessor;

import javax.servlet.http.HttpServletRequest;

public class MatchmadeEnrollmentRequestProcessor extends RequestProcessor
{
    @Override
    protected Notification constructNotification(HttpServletRequest request)
    {
        String IDParameter = request.getParameter("client-id");
        return new MatchmadeEnrollmentNotification(Integer.parseInt(IDParameter));
    }
}
