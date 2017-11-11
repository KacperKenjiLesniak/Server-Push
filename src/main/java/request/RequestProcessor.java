package request;

import notification.Notification;

import javax.servlet.http.HttpServletRequest;

public abstract class RequestProcessor {

    public final Notification processRequest(HttpServletRequest request)
    {
        preprocess(request);
        Notification notification = constructNotification(request);
        postprocess(request, notification);

        return notification;
    }

    protected void preprocess(HttpServletRequest request)
    {
    }

    // This is the method which the framework user needs to implement
    protected abstract Notification constructNotification(HttpServletRequest request);

    protected void postprocess(HttpServletRequest request, Notification notification)
    {
    }
}
