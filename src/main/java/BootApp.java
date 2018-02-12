import configuration.BrokerConfiguration;
import configuration.UserConfiguration;
import com.google.common.collect.ImmutableList;
import matchmade.MatchmadeEnrollmentRequestProcessor;
import matchmade.MatchmadeMatchReportRequestProcessor;
import messenger.ImageMessengerRequestProcessor;
import messenger.MessengerRequestProcessor;

public class BootApp
{
    public static void main(String[] args) throws NoSuchMethodException
    {
        final UserConfiguration userConfiguration = UserConfiguration.tryCreatingSingleton(
                8080,
                "/server-push",
                "/topic",
                ImmutableList.of(
                        new BrokerConfiguration("/text",
                                                ImmutableList.of("/topic/messages"),
                                                new MessengerRequestProcessor()),
                        new BrokerConfiguration("/image",
                                                ImmutableList.of("/topic/images"),
                                                new ImageMessengerRequestProcessor()),
                        new BrokerConfiguration("/matchmade-enrollment",
                                                ImmutableList.of("/topic/matchmade"),
                                                new MatchmadeEnrollmentRequestProcessor()),
                        new BrokerConfiguration("/matchmade-match",
                                                ImmutableList.of("/topic/matchmade"),
                                                new MatchmadeMatchReportRequestProcessor()))
        );

        PushServer.run(userConfiguration, args);
    }
}
