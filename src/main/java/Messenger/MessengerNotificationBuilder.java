package Messenger;

import java.util.Date;

/**
 * Created by kenjik on 06.11.17.
 */
public class MessengerNotificationBuilder {
    private String newSenderName;
    private String newReceiverName;
    private Date newSendDate;
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

    public MessengerNotificationBuilder withSendDate(Date newSendDate){
        this.newSendDate = newSendDate;
        return this;
    }

    public MessengerNotificationBuilder withMessage(String newMessage){
        this.newMessage = newMessage;
        return this;
    }

    public MessengerNotification Build(){
        return new MessengerNotification(newSenderName, newReceiverName, newSendDate, newMessage);
    }
}
