package factory;

import history.HistoryService;
import request.RequestProcessor;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by annterina on 12.02.18.
 */
public abstract class AbstractServerPushFactory
{

    public abstract RequestProcessor createRequestProcessor();
    public abstract HistoryService createHistoryService();
    public abstract String createTriggerEndpoint();
    public abstract List<String> createSendToEndpoints();

}
