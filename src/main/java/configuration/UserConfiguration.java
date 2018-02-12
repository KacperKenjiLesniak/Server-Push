package configuration;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

public class UserConfiguration
{
    private static UserConfiguration instance;

    private int port;
    private String stompConnectionEndpoint;
    private List<BrokerConfiguration> brokerConfigurations;

    private UserConfiguration(final int port,
                              final String stompConnectionEndpoint,
                              final List<BrokerConfiguration> brokerConfigurations)
    {
        this.port = port;
        this.stompConnectionEndpoint = checkNotNull(stompConnectionEndpoint);
        this.brokerConfigurations = checkNotNull(brokerConfigurations);
    }

    public static UserConfiguration tryCreatingSingleton(final int port,
                                                         final String stompConnectionEndpoint,
                                                         final List<BrokerConfiguration> brokerConfigurations)
    {
        if (instance == null) {
            instance = new UserConfiguration(
                    port,
                    stompConnectionEndpoint,
                    brokerConfigurations);
            return instance;
        } else {
            throw new UnsupportedOperationException(
                    "This object was already created. Obtain it via UserConfiguration::getInstance");
        }
    }

    public static UserConfiguration getInstance()
    {
        if(instance == null) {
            throw new UnsupportedOperationException(
                    "Instance needs to be created first. Use UserConfiguration::tryCreatingSingleton");
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

    public Optional<BrokerConfiguration> getBrokerConfigurationFor(String triggerEndpoint)
    {
        List<BrokerConfiguration> brokers =
                brokerConfigurations.stream()
                                    .filter(conf -> conf.getTriggerEndpoint().equals(String.format("/%s", triggerEndpoint)))
                                    .collect(Collectors.toList());

        return Optional.ofNullable(brokers.get(0));
    }
}
