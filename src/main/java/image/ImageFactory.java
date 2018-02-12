package image;

import com.google.common.collect.ImmutableList;
import factory.AbstractNotificationFactory;
import history.HistoryService;
import request.RequestProcessor;

import java.util.List;

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

    @Override
    public String createTriggerEndpoint() {
        return "/image";
    }

    @Override
    public List<String> createSendToEndpoints() {
        return ImmutableList.of("/topic/images");
    }
}
