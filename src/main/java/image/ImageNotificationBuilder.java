package image;

import notification.NotificationBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.time.LocalDateTime;

/**
 * Created by annterina on 11.11.17.
 */
public class ImageNotificationBuilder implements NotificationBuilder {

    private String newSenderId;
    private String newReceiverId;
    private String newSenderName;
    private String newReceiverName;
    private LocalDateTime newSendDate;
    private byte[] newSendImage;
    private long newSendImageSize;
    private String newSendImageName;

    public ImageNotificationBuilder() {}

    public ImageNotificationBuilder withSenderId(String newSenderId) {
        this.newSenderId = newSenderId;
        return this;
    }

    public ImageNotificationBuilder withReceiverId(String newReceiverId) {
        this.newReceiverId = newReceiverId;
        return this;
    }

    public ImageNotificationBuilder withSenderName(String newSenderName) {
        this.newSenderName = newSenderName;
        return this;
    }

    public ImageNotificationBuilder withReceiverName(String newReceiverName) {
        this.newReceiverName = newReceiverName;
        return this;
    }

    public ImageNotificationBuilder withSendDate(LocalDateTime newSendDate) {
        this.newSendDate = newSendDate;
        return this;
    }

    public ImageNotificationBuilder withImage(MultipartFile newSendImage) {
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
    public ImageNotification build() {
        return new ImageNotification(newSenderId, newReceiverId, newSenderName, newReceiverName, newSendDate, newSendImage, newSendImageSize, newSendImageName);
    }

}
