import configuration.BrokerConfiguration;
import configuration.UserConfiguration;
import com.google.common.collect.ImmutableList;
import image.ImageFactory;
import matchmade.MatchmadeEnrollmentFactory;
import matchmade.MatchmadeEnrollmentRequestProcessor;
import matchmade.MatchmadeMatchReportFactory;
import matchmade.MatchmadeMatchReportRequestProcessor;
import image.ImageRequestProcessor;
import messenger.MessengerFactory;
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
                        new BrokerConfiguration(new MessengerFactory()),
                        new BrokerConfiguration(new ImageFactory()),
                        new BrokerConfiguration(new MatchmadeEnrollmentFactory()),
                        new BrokerConfiguration(new MatchmadeMatchReportFactory()))
        );

        PushServer.run(userConfiguration, args);
    }
}
