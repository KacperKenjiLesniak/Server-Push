package configuration;

import request.RequestProcessor;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class BrokerConfiguration
{
    private final String triggerEndpoint;
    private final List<String> sendToEndpoints;
    private final RequestProcessor requestProcessor;

    public BrokerConfiguration(final String triggerEndpoint,
                               final List<String> sendToEndpoints,
                               final RequestProcessor requestProcessor)
    {
        this.sendToEndpoints = checkSendToEndpoints(sendToEndpoints);
        this.triggerEndpoint = checkNotNull(triggerEndpoint);
        this.requestProcessor = checkNotNull(requestProcessor);
    }

    private List<String> checkSendToEndpoints(List<String> sendToEndpoints)
    {
        checkNotNull(sendToEndpoints);
        checkArgument(!sendToEndpoints.isEmpty(),
                "Send-to-endpoints must not be empty. Please add at least one endpoint");
        return sendToEndpoints;
    }

    public String getTriggerEndpoint()
    {
        return triggerEndpoint;
    }

    public List<String> getSendToEndpoints()
    {
        return sendToEndpoints;
    }

    public RequestProcessor getRequestProcessor()
    {
        return requestProcessor;
    }
}
