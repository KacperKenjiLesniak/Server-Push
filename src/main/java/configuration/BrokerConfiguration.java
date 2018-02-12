package configuration;


import factory.AbstractNotificationFactory;
import history.HistoryService;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class BrokerConfiguration
{

    private final AbstractNotificationFactory notificationFactory;
    private final String triggerEndpoint;
    private final List<String> sendToEndpoints;
    private HistoryService historyService;

    public BrokerConfiguration(final AbstractNotificationFactory notificationFactory)
    {
        this.notificationFactory = checkNotNull(notificationFactory);
        this.sendToEndpoints = notificationFactory.createSendToEndpoints();
        this.triggerEndpoint = notificationFactory.createTriggerEndpoint();
        this.historyService = notificationFactory.createHistoryService();
    }

    public String getTriggerEndpoint()
    {
        return triggerEndpoint;
    }

    public List<String> getSendToEndpoints()
    {
        return sendToEndpoints;
    }

    public AbstractNotificationFactory getNotificationFactory()
    {
        return notificationFactory;
    }

    public HistoryService getHistoryService() {
        return historyService;
    }

}
