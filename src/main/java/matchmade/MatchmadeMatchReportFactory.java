package matchmade;

import com.google.common.collect.ImmutableList;
import factory.AbstractNotificationFactory;
import history.HistoryService;
import request.RequestProcessor;

import java.util.List;

/**
 * Created by annterina on 12.02.18.
 */
public class MatchmadeMatchReportFactory extends AbstractNotificationFactory {

    @Override
    public RequestProcessor createRequestProcessor() {
        return new MatchmadeMatchReportRequestProcessor();
    }

    @Override
    public HistoryService createHistoryService() {
        return new MatchmadeHistoryService();
    }

    @Override
    public String createTriggerEndpoint() {
        return "/matchmade-match";
    }

    @Override
    public List<String> createSendToEndpoints() {
        return ImmutableList.of("/topic/matchmade");
    }
}
