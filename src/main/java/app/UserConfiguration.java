package app;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class UserConfiguration
{
    private final int port;
    private final String stompConnectionEndpoint;
    private final String brokerDestinationEndpoint;
    private final List<TriggerEndpointConfiguration> triggerEndpointConfigurations;

    public UserConfiguration(final int port,
                      final String stompConnectionEndpoint,
                      final String brokerDestinationEndpoint,
                      final List<TriggerEndpointConfiguration> triggerEndpointConfigurations)
    {
        checkNotNull(port);
        checkNotNull(stompConnectionEndpoint);
        checkNotNull(brokerDestinationEndpoint);
        checkNotNull(triggerEndpointConfigurations);

        this.port = checkNotNull(port);
        this.stompConnectionEndpoint = checkNotNull(stompConnectionEndpoint);
        this.brokerDestinationEndpoint = checkNotNull(brokerDestinationEndpoint);
        this.triggerEndpointConfigurations = checkNotNull(triggerEndpointConfigurations);
    }

    public int getPort()
    {
        return port;
    }

    public String getStompConnectionEndpoint()
    {
        return stompConnectionEndpoint;
    }

    public String getBrokerDestinationEndpoint()
    {
        return brokerDestinationEndpoint;
    }

    public List<TriggerEndpointConfiguration> getTriggerEndpointConfigurations()
    {
        return triggerEndpointConfigurations;
    }
}
