package request;

import notification.Notification;

public abstract class RequestProcessor {

    protected Request request;

    public RequestProcessor(Request request)
    {
        this.request = request;
    }

    public Notification processRequest()
    {
        preprocess();
        Notification notification = constructNotification();
        postprocess(notification);

        return notification;
    }

    protected void preprocess()
    {
    }

    // This is the method which the framework user needs to implement
    protected abstract Notification constructNotification();

    protected void postprocess(Notification notification)
    {
    }
}
