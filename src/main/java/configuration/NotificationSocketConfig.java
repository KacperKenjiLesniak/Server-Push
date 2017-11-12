package configuration;

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
    private UserConfiguration configuration = UserConfiguration.getInstance();

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config)
    {
        final List<String> list = configuration.getTriggerEndpointConfigurations()
                .stream()
                .map(TriggerEndpointConfiguration::getTriggerEndpoint)
                .collect(Collectors.toList());
        config.setApplicationDestinationPrefixes(list.toArray(new String[list.size()]));
        config.enableSimpleBroker(configuration.getBrokerDestinationEndpoint());

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry)
    {
        registry.addEndpoint(configuration.getStompConnectionEndpoint()).setAllowedOrigins("*").withSockJS();
    }
}