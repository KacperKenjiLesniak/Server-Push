package controllers;

import configuration.BrokerConfiguration;
import configuration.UserConfiguration;
import matchmade.MatchmadeEnrollmentRequestProcessor;
import matchmade.MatchmadeMatchReportRequestProcessor;
import messenger.ImageMessengerRequestProcessor;
import messenger.MessengerRequestProcessor;
import notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @RequestMapping(value = "/send/{triggerEndpoint}", method = RequestMethod.POST)
    public String handleRequest(HttpServletRequest request,
                                HttpServletResponse response,
                                @PathVariable String triggerEndpoint)
    {
        configuration.getBrokerConfigurationFor(triggerEndpoint).ifPresent(brokerConfiguration -> {
            request.setAttribute("trigger", triggerEndpoint);
            handleRequestWithProcessor(brokerConfiguration, request);
            response.setStatus(HttpServletResponse.SC_OK);
        });

        return "redirect:/index.html";
    }

    private void handleRequestWithProcessor(BrokerConfiguration brokerConfiguration, HttpServletRequest request)
    {
        final List<Notification> notificationList = new ArrayList<>();
        RequestProcessor processor = brokerConfiguration.getRequestProcessor();
        notificationList.add(processor.processRequest(request));
        brokerConfiguration.getSendToEndpoints()
                           .forEach(endpoint -> template.convertAndSend(endpoint, notificationList));

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