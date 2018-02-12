package configuration;


import factory.AbstractNotificationFactory;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class BrokerConfiguration
{
    private final String triggerEndpoint;
    private final List<String> sendToEndpoints;
    private final AbstractNotificationFactory notificationFactory;

    public BrokerConfiguration(final String triggerEndpoint,
                               final List<String> sendToEndpoints,
                               final AbstractNotificationFactory notificationFactory)
    {
        this.sendToEndpoints = checkSendToEndpoints(sendToEndpoints);
        this.triggerEndpoint = checkNotNull(triggerEndpoint);
        this.notificationFactory = checkNotNull(notificationFactory);
    }

    private List<String> checkSendToEndpoints(List<String> sendToEndpoints)
    {
        checkNotNull(sendToEndpoints);
        checkArgument(!sendToEndpoints.isEmpty(),
                "Send-to-endpoints must not be empty. Please add at least one endpoint");
        return sendToEndpoints;
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
}
