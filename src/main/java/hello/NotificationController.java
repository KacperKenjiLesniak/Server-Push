package hello;

import messenger.MessengerNotification;
import messenger.MessengerNotificationBuilder;
import notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NotificationController
{
    @Autowired
    private SimpMessagingTemplate template;

    @RequestMapping(value = "/send-update", method = RequestMethod.POST)
    @SendTo("/topic/myscores")
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)
    {
        final List<Notification> notificationList = new ArrayList<>();
        final Notification notificationA = new MessengerNotificationBuilder()
                .withMessage(request.getParameter("message"))
                .withSenderName(request.getParameter("sender-name"))
                .withReceiverName(request.getParameter("receiver-name"))
                .build();
        notificationList.add(notificationA);
        template.convertAndSend("/topic/myscores", notificationList);
        return "index.html";
    }

    @RequestMapping({"/", "/home"})
    public String showHome()
    {
        return "index.html";
    }
}