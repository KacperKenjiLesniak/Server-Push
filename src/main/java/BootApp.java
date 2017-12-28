import configuration.TriggerEndpointConfiguration;
import configuration.UserConfiguration;
import com.google.common.collect.ImmutableList;

public class BootApp
{
    public static void main(String[] args)
    {
        final UserConfiguration userConfiguration = UserConfiguration.tryCreatingSingleton(
                8080,
                "/server-push",
                "/topic",
                ImmutableList.of(
                        new TriggerEndpointConfiguration("/text", ImmutableList.of("/topic/messages")),
                        new TriggerEndpointConfiguration("/image", ImmutableList.of("/topic/images")))
        );

        PushServer.run(userConfiguration, args);
    }
}
