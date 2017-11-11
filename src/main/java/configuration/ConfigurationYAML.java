package configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class ConfigurationYAML
{
    private String environment;
    private List<String> servers = new ArrayList<>();
    private String updateTriggeringEndpoint;
    private String updateDestinationEndpoint;

    public String getEnvironment()
    {
        return environment;
    }

    public List<String> getServers()
    {
        return servers;
    }

    public String getUpdateTriggeringEndpoint()
    {
        return updateTriggeringEndpoint;
    }

    public String getUpdateDestinationEndpoint()
    {
        return updateDestinationEndpoint;
    }
}
