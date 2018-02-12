import com.google.common.collect.ImmutableList;
import configuration.BrokerConfiguration;
import configuration.UserConfiguration;
import image.ImageFactory;
import matchmade.MatchmadeEnrollmentFactory;
import matchmade.MatchmadeMatchReportFactory;
import messenger.MessengerFactory;

public class BootApp
{
    public static void main(String[] args)
    {
        final UserConfiguration userConfiguration = UserConfiguration.tryCreatingSingleton(
                8080,
                "/server-push",
                ImmutableList.of(
                        new BrokerConfiguration(new MessengerFactory()),
                        new BrokerConfiguration(new ImageFactory()),
                        new BrokerConfiguration(new MatchmadeEnrollmentFactory()),
                        new BrokerConfiguration(new MatchmadeMatchReportFactory()))
        );

        PushServer.run(args);
    }
}
