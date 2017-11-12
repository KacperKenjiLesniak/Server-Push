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
    private String imageName;
    private long imageSize;
    private byte[] image;

    public ImageMessengerNotification(String senderId, String receiverId, String senderName, String receiverName, LocalDateTime sendDate, String imageName, long imageSize, byte[] image) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.sendDate = sendDate;
        this.imageName = imageName;
        this.imageSize = imageSize;
        this.image = image;
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

    public String getImageName() {
        return imageName;
    }

    public long getImageSize() {
        return imageSize;
    }

    public byte[] getImage() {
        return image;
    }
}
