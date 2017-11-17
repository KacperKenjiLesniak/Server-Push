package configuration;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class TriggerEndpointConfiguration
{
    private final String triggerEndpoint;
    private final List<String> sendToEndpoints;

    public TriggerEndpointConfiguration(final String triggerEndpoint, final List<String> sendToEndpoints)
    {
        this.sendToEndpoints = checkSendToEndpoints(sendToEndpoints);
        this.triggerEndpoint = checkNotNull(triggerEndpoint);
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
}
