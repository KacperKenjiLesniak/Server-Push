package Messenger;

import Notification.Notification;

import java.util.Date;


/**
 * Created by kenjik on 06.11.17.
 */
public class MessengerNotification implements Notification {

    private String senderName;
    private String receiverName;
    private Date sendDate;
    private String message;

    public MessengerNotification(String senderName, String receiverName, Date sendDate, String message) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.sendDate = sendDate;
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
