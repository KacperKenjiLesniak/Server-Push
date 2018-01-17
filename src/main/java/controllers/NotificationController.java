package controllers;

import configuration.UserConfiguration;
import messenger.ImageMessengerRequestProcessor;
import messenger.MessengerRequestProcessor;
import notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import request.RequestProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NotificationController
{
    private UserConfiguration configuration = UserConfiguration.getInstance();

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private SessionHandler sessionHandler;

    @RequestMapping(value = "/send/text", method = RequestMethod.POST)
    public String handleMessengerRequest(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("trigger", "text");
        RequestProcessor processor = new MessengerRequestProcessor();
        handleRequestWithProcessor(processor, request);

        return "redirect:/index.html";
    }

    @RequestMapping(value = "/send/image", method = RequestMethod.POST)
    public String handleImageRequest(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("trigger", "image");
        RequestProcessor processor = new ImageMessengerRequestProcessor();
        handleRequestWithProcessor(processor, request);

        return "redirect:/index.html";
    }

    private void handleRequestWithProcessor(RequestProcessor processor, HttpServletRequest request)
    {
        String trigger = (String) request.getAttribute("trigger");

        final List<Notification> notificationList = new ArrayList<>();
        notificationList.add(processor.processRequest(request));
        configuration.getTriggerEndpointConfigurations()
                     .stream()
                     .filter(endpointConf -> endpointConf.getTriggerEndpoint().equals(String.format("/%s", trigger)))
                     .forEach(endpointConf -> endpointConf.getSendToEndpoints()
                                                          .forEach(endpoint -> template.convertAndSend(endpoint, notificationList)
                                                          ));
    }

    @RequestMapping(value = "/closeAll", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void closeAll()
    {
        sessionHandler.closeAll();
    }

    @RequestMapping({"/", "/home"})
    public String showHome()
    {
        return "index.html";
    }
}