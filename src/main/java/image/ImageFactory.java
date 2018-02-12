package image;

import factory.AbstractNotificationFactory;
import history.HistoryService;
import request.RequestProcessor;

/**
 * Created by annterina on 12.02.18.
 */
public class ImageFactory extends AbstractNotificationFactory {

    @Override
    public RequestProcessor createRequestProcessor() {
        return new ImageRequestProcessor();
    }

    @Override
    public HistoryService createHistoryService() {
        return new ImageHistoryService();
    }
}
