package matchmade;

import factory.AbstractNotificationFactory;
import history.HistoryService;
import request.RequestProcessor;

/**
 * Created by annterina on 12.02.18.
 */
public class MatchmadeEnrollmentFactory extends AbstractNotificationFactory {

    @Override
    public RequestProcessor createRequestProcessor() {
        return new MatchmadeEnrollmentRequestProcessor();
    }

    @Override
    public HistoryService createHistoryService() {
        return new MatchmadeHistoryService();
    }
}
