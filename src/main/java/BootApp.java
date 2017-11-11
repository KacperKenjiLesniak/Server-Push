import app.TriggerEndpointConfiguration;
import app.UserConfiguration;
import app.UserConfigurationBuilder;
import com.google.common.collect.ImmutableList;

public class BootApp
{
    public static void main(String[] args)
    {
        final UserConfiguration userConfiguration = UserConfigurationBuilder.builder()
                .withPort(8090)
                .withBrokerDestinationEndpoint("/topic")
                .withStompConnectionEndpoint("/livescore-websocket")
                .withTriggerEndpointConfigurations(ImmutableList.of(
                        new TriggerEndpointConfiguration("/app", ImmutableList.of("/topic/myscores"))
                ))
                .build();

        new PushServer(userConfiguration).run();
    }
}
