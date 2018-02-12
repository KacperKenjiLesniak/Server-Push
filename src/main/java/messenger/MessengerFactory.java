package messenger;

import factory.AbstractNotificationFactory;
import history.HistoryService;
import request.RequestProcessor;

/**
 * Created by annterina on 12.02.18.
 */
public class MessengerFactory extends AbstractNotificationFactory {

    @Override
    public RequestProcessor createRequestProcessor() {
        return new MessengerRequestProcessor();
    }

    @Override
    public HistoryService createHistoryService() {
        return new MessengerHistoryService();
    }
}
