package messenger;

import java.time.LocalDateTime;

public class MessengerNotificationBuilder {
    private String newSenderName;
    private String newReceiverName;
    private LocalDateTime newSendDate;
    private String newMessage;

    public MessengerNotificationBuilder(){

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
        return new MessengerNotification(newSenderName, newReceiverName, newSendDate, newMessage);
    }
}
