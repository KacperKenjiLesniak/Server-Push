package app;

import java.util.List;

public class UserConfiguration
{
    private final int port;
    private final String stompConnectionEndpoint;
    private final String brokerDestinationEndpoint;
    private final List<TriggerEndpointConfiguration> triggerEndpointConfigurations;

    UserConfiguration(final int port,
                      final String stompConnectionEndpoint,
                      final String brokerDestinationEndpoint,
                      final List<TriggerEndpointConfiguration> triggerEndpointConfigurations)
    {
        this.port = port;
        this.stompConnectionEndpoint = stompConnectionEndpoint;
        this.brokerDestinationEndpoint = brokerDestinationEndpoint;
        this.triggerEndpointConfigurations = triggerEndpointConfigurations;
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