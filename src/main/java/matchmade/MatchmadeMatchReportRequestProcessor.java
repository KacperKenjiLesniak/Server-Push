package matchmade;

import notification.Notification;
import request.RequestProcessor;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatchmadeMatchReportRequestProcessor extends RequestProcessor
{
    @Override
    protected Notification constructNotification(HttpServletRequest request)
    {
        String encodedMatch = request.getParameter("match");
        List<Integer> matchedClients = decodeMatchedClientsIDs(encodedMatch);
        return new MatchmadeMatchReportNotification(matchedClients);
    }

    private List<Integer> decodeMatchedClientsIDs(String encodedMatch)
    {
        List<Integer> clientIDs = new ArrayList<>();
        Scanner scanner = new Scanner(encodedMatch);
        scanner.useDelimiter(";");

        while (scanner.hasNext())
        {
            clientIDs.add(Integer.parseInt(scanner.next()));
        }

        return clientIDs;
    }
}
