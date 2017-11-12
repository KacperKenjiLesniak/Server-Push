import configuration.TriggerEndpointConfiguration;
import configuration.UserConfiguration;
import com.google.common.collect.ImmutableList;

public class BootApp
{
    public static void main(String[] args)
    {
        final UserConfiguration userConfiguration = UserConfiguration.tryCreatingSingleton(
                8090,
                "/livescore-websocket",
                "/topic",
                ImmutableList.of(
                        new TriggerEndpointConfiguration("/app", ImmutableList.of("/topic/myscores")))
        );

        PushServer.run(userConfiguration, args);
    }
}
