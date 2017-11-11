package configuration;

import app.TriggerEndpointConfiguration;
import app.UserConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebSocketMessageBroker
public class NotificationSocketConfig extends AbstractWebSocketMessageBrokerConfigurer
{
    @Autowired
    private ApplicationContext context;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config)
    {
        final List<String> list = getConfig().getTriggerEndpointConfigurations()
                .stream()
                .map(TriggerEndpointConfiguration::getTriggerEndpoint)
                .collect(Collectors.toList());
        config.setApplicationDestinationPrefixes(list.toArray(new String[list.size()]));
        config.enableSimpleBroker(getConfig().getBrokerDestinationEndpoint());

    }

    private UserConfiguration getConfig()
    {
        return (UserConfiguration) context.getBean(UserConfiguration.class.getName());
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry)
    {
        registry.addEndpoint(getConfig().getStompConnectionEndpoint()).setAllowedOrigins("*").withSockJS();
    }
}