package messenger;

import notification.Notification;

import java.time.LocalDateTime;

/**
 * Created by annterina on 11.11.17.
 */
public class ImageMessengerNotification implements Notification {

    private String senderId;
    private String receiverId;
    private String senderName;
    private String receiverName;
    private LocalDateTime sendDate;
    private byte[] sendImage;
    private long sendImageSize;
    private String sendImageName;

    ImageMessengerNotification(String senderId, String receiverId, String senderName, String receiverName, LocalDateTime sendDate, byte[] sendImage, long sendImageSize, String sendImageName) {

        this.senderId = senderId;
        this.receiverId = receiverId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.sendDate = sendDate;
        this.sendImage = sendImage;
        this.sendImageSize = sendImageSize;
        this.sendImageName = sendImageName;
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

    public byte[] getSendImage() {
        return sendImage;
    }

    public long getSendImageSize() {
        return sendImageSize;
    }

    public String getSendImageName() {
        return sendImageName;
    }

}
