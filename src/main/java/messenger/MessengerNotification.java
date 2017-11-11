package messenger;

import notification.Notification;

import java.time.LocalDateTime;


public class MessengerNotification implements Notification {

    private String senderId;
    private String receiverId;
    private String senderName;
    private String receiverName;
    private LocalDateTime sendDate;
    private String message;

    public MessengerNotification(String senderId, String receiverId, String senderName, String receiverName, LocalDateTime sendDate, String message) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.sendDate = sendDate;
        this.message = message;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
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
