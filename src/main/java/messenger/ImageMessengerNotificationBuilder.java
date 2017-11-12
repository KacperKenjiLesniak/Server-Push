package messenger;

import notification.NotificationBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UncheckedIOException;
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
    private byte[] newSendImage;
    private long newSendImageSize;
    private String newSendImageName;

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

    public ImageMessengerNotificationBuilder withImage(MultipartFile newSendImage) {
        try {
            this.newSendImage = newSendImage.getBytes();
            this.newSendImageSize = newSendImage.getSize();
            this.newSendImageName = newSendImage.getOriginalFilename();
        } catch (IOException e) {
            throw new UncheckedIOException("Could not get bytes from image", e);
        }
        return this;
    }

    @Override
    public ImageMessengerNotification build() {
        return new ImageMessengerNotification(newSenderId, newReceiverId, newSenderName, newReceiverName, newSendDate, newSendImage, newSendImageSize, newSendImageName);
    }

}
