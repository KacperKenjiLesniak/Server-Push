package messenger;

import notification.Notification;
import request.RequestProcessor;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class MessengerRequestProcessor extends RequestProcessor {

    private LocalDateTime sendDate;

    @Override
    protected void preprocess(HttpServletRequest request)
    {
        super.preprocess(request);
        sendDate = LocalDateTime.now();
    }

    @Override
    protected void postprocess(HttpServletRequest request, Notification notification)
    {
        super.postprocess(request, notification);
    }

    @Override
    protected Notification constructNotification(HttpServletRequest request)
    {
        return new MessengerNotificationBuilder()
                .withMessage(request.getParameter("message"))
                .withSenderName(request.getParameter("sender-name"))
                .withReceiverName(request.getParameter("receiver-name"))
                .withSendDate(sendDate)
                .build();
    }
}
