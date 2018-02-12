package factory;

import history.HistoryService;
import request.RequestProcessor;

/**
 * Created by annterina on 12.02.18.
 */
public abstract class AbstractNotificationFactory {

    public abstract RequestProcessor createRequestProcessor();
    public abstract HistoryService createHistoryService();
}
