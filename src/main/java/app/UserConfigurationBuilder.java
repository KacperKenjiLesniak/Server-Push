package app;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class UserConfigurationBuilder
{
    private int port;
    private String stompConnectionEndpoint;
    private String brokerDestinationEndpoint;
    private List<TriggerEndpointConfiguration> triggerEndpointConfigurations;

    private UserConfigurationBuilder()
    {
    }

    public static UserConfigurationBuilder builder()
    {
        return new UserConfigurationBuilder();
    }

    public UserConfigurationBuilder withPort(final int port)
    {
        this.port = port;
        return this;
    }

    public UserConfigurationBuilder withStompConnectionEndpoint(final String stompConnectionEndpoint)
    {
        this.stompConnectionEndpoint = stompConnectionEndpoint;
        return this;
    }

    public UserConfigurationBuilder withBrokerDestinationEndpoint(final String brokerDestinationEndpoint)
    {
        this.brokerDestinationEndpoint = brokerDestinationEndpoint;
        return this;
    }

    public UserConfigurationBuilder withTriggerEndpointConfigurations(
            final List<TriggerEndpointConfiguration> triggerEndpointConfigurations)
    {
        this.triggerEndpointConfigurations = triggerEndpointConfigurations;
        return this;
    }

    public UserConfiguration build()
    {
        checkNotNull(port);
        checkNotNull(stompConnectionEndpoint);
        checkNotNull(brokerDestinationEndpoint);
        checkNotNull(triggerEndpointConfigurations);

        return new UserConfiguration(port,
                stompConnectionEndpoint,
                brokerDestinationEndpoint,
                triggerEndpointConfigurations);
    }
}
