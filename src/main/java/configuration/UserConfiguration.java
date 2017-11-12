package configuration;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class UserConfiguration
{
    private static UserConfiguration instance;

    private int port;
    private String stompConnectionEndpoint;
    private String brokerDestinationEndpoint;
    private List<TriggerEndpointConfiguration> triggerEndpointConfigurations;

    private UserConfiguration(final int port,
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

    public static UserConfiguration tryCreatingSingleton(final int port,
                                                         final String stompConnectionEndpoint,
                                                         final String brokerDestinationEndpoint,
                                                         final List<TriggerEndpointConfiguration> triggerEndpointConfigurations)
    {
        if (instance == null) {
            instance = new UserConfiguration(port,
                    stompConnectionEndpoint,
                    brokerDestinationEndpoint,
                    triggerEndpointConfigurations);
            return instance;
        } else {
            throw new UnsupportedOperationException("This object was already created. Obtain it via " +
                    "UserConfiguration::getInstance");
        }
    }

    public static UserConfiguration getInstance()
    {
        if(instance == null) {
            throw new UnsupportedOperationException("Instance needs to be created first. Use " +
                    "UserConfiguration::tryCreatingSingleton");
        } else {
            return instance;
        }
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
