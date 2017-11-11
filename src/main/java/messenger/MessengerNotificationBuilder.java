package messenger;

import notification.NotificationBuilder;

import java.time.LocalDateTime;

public class MessengerNotificationBuilder implements NotificationBuilder {
    private String newSenderId;
    private String newReceiverId;
    private String newSenderName;
    private String newReceiverName;
    private LocalDateTime newSendDate;
    private String newMessage;

    public MessengerNotificationBuilder(){

    }

    public MessengerNotificationBuilder withSenderId(String newSenderId){
        this.newSenderId = newSenderId;
        return this;
    }

    public MessengerNotificationBuilder withReceiverId(String newReceiverId){
        this.newReceiverId = newReceiverId;
        return this;
    }

    public MessengerNotificationBuilder withSenderName(String newSenderName){
        this.newSenderName = newSenderName;
        return this;
    }

    public MessengerNotificationBuilder withReceiverName(String newReceiverName){
        this.newReceiverName = newReceiverName;
        return this;
    }

    public MessengerNotificationBuilder withSendDate(LocalDateTime newSendDate){
        this.newSendDate = newSendDate;
        return this;
    }

    public MessengerNotificationBuilder withMessage(String newMessage){
        this.newMessage = newMessage;
        return this;
    }

    public MessengerNotification build(){
        return new MessengerNotification(newSenderId, newReceiverId, newSenderName, newReceiverName, newSendDate, newMessage);
    }
}
