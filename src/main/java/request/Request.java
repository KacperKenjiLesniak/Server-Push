package request;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

public class Request {

    private HttpServletRequest httpServletRequest;

    public Request(HttpServletRequest httpServletRequest)
    {
        this.httpServletRequest = httpServletRequest;
    }

    // Exemplary method, others to be implemented
    public String getPayload() throws IOException
    {
        return httpServletRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    }
}
