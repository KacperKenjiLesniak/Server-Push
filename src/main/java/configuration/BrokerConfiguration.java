package configuration;


import factory.AbstractServerPushFactory;
import history.HistoryService;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class BrokerConfiguration
{
    private final AbstractServerPushFactory serverPushFactory;
    private final String triggerEndpoint;
    private final List<String> sendToEndpoints;
    private HistoryService historyService;

    public BrokerConfiguration(final AbstractServerPushFactory serverPushFactory)
    {
        this.serverPushFactory = checkNotNull(serverPushFactory);
        this.sendToEndpoints = serverPushFactory.createSendToEndpoints();
        this.triggerEndpoint = serverPushFactory.createTriggerEndpoint();
        this.historyService = serverPushFactory.createHistoryService();
    }

    public String getTriggerEndpoint()
    {
        return triggerEndpoint;
    }

    public List<String> getSendToEndpoints()
    {
        return sendToEndpoints;
    }

    public AbstractServerPushFactory getServerPushFactory()
    {
        return serverPushFactory;
    }

    public HistoryService getHistoryService() {
        return historyService;
    }

}
