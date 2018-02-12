package messenger;

import com.google.common.collect.ImmutableList;
import factory.AbstractNotificationFactory;
import history.HistoryService;
import request.RequestProcessor;

import java.util.List;

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

    @Override
    public String createTriggerEndpoint() {
        return "/text";
    }

    @Override
    public List<String> createSendToEndpoints() {
        return ImmutableList.of("/topic/messages");
    }
}
