package messenger;

import notification.Notification;
import notification.NotificationBuilder;

import java.time.LocalDateTime;

/**
 * Created by annterina on 11.11.17.
 */
public class ImageMessengerNotificationBuilder implements NotificationBuilder {

    private String newSenderId;
    private String newReceiverId;
    private String newSenderName;
    private String newReceiverName;
    private LocalDateTime newSendDate;
    private String imageName;
    private long imageSize;
    private byte[] newSendImage;

    public ImageMessengerNotificationBuilder() {}

    public ImageMessengerNotificationBuilder withSenderId(String newSenderId) {
        this.newSenderId = newSenderId;
        return this;
    }

    public ImageMessengerNotificationBuilder withReceiverId(String newReceiverId) {
        this.newReceiverId = newReceiverId;
        return this;
    }

    public ImageMessengerNotificationBuilder withSenderName(String newSenderName) {
        this.newSenderName = newSenderName;
        return this;
    }

    public ImageMessengerNotificationBuilder withReceiverName(String newReceiverName) {
        this.newReceiverName = newReceiverName;
        return this;
    }

    public ImageMessengerNotificationBuilder withSendDate(LocalDateTime newSendDate) {
        this.newSendDate = newSendDate;
        return this;
    }

    public ImageMessengerNotificationBuilder withSendImage(byte[] newSendImage) {
        this.newSendImage = newSendImage;
        return this;
    }

    @Override
    public ImageMessengerNotification build() {
        return new ImageMessengerNotification(newSenderId, newReceiverId, newSenderName, newReceiverName, newSendDate, imageName, imageSize, newSendImage);
    }

    public ImageMessengerNotificationBuilder withImageSize(Long imageSize) {
        this.imageSize = imageSize;
        return this;
    }

    public ImageMessengerNotificationBuilder withImageName(String imageName) {
        this.imageName = imageName;
        return this;
    }
}
