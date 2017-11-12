package messenger;

import notification.Notification;
import request.RequestProcessor;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;

public class MessengerRequestProcessor extends RequestProcessor {

    private LocalDateTime sendDate;
    private String senderName;
    private String receiverName;
    private MessengerDatabase database;

    @Override
    protected void preprocess(HttpServletRequest request) {
        super.preprocess(request);
        database = new MessengerDatabase();
        senderName = database.getNameFromId(request.getParameter("sender-id"));
        receiverName = database.getNameFromId(request.getParameter("receiver-id"));
        sendDate = LocalDateTime.now();
    }

    @Override
    protected void postprocess(HttpServletRequest request, Notification notification) {
        super.postprocess(request, notification);
        database.addNotification(notification);
    }

    @Override
    protected Notification constructNotification(HttpServletRequest request) {
        return new MessengerNotificationBuilder()
                .withMessage(request.getParameter("message"))
                .withSenderId(request.getParameter("sender-id"))
                .withReceiverId(request.getParameter("receiver-id"))
                .withSenderName(senderName)
                .withReceiverName(receiverName)
                .withSendDate(sendDate)
                .build();
    }
}
