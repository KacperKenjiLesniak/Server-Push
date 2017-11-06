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
}
