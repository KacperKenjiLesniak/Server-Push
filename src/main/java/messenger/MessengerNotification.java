package messenger;

import notification.Notification;

import java.time.LocalDateTime;


public class MessengerNotification implements Notification {

    private String senderName;
    private String receiverName;
    private LocalDateTime sendDate;
    private String message;

    MessengerNotification(String senderName, String receiverName, LocalDateTime sendDate, String message) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.sendDate = sendDate;
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public LocalDateTime getSendDate() {
        return sendDate;
    }

    public String getMessage() {
        return message;
    }
    
}
