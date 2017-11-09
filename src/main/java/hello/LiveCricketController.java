package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LiveCricketController
{
    @Autowired
    private SimpMessagingTemplate template;

    @RequestMapping(value = "${updateTriggeringEndpoint}", method = RequestMethod.POST)
    @SendTo("${updateDestinationEndpoint}")
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)
    {
        final List<Batsman> list = new ArrayList<>();
        final Batsman batsmanA = new Batsman();
        batsmanA.setRuns(Integer.parseInt(request.getParameter("runs-a")));
        batsmanA.setBalls(Integer.parseInt(request.getParameter("balls-a")));
        list.add(batsmanA);
        final Batsman batsmanB = new Batsman();
        batsmanB.setRuns(Integer.parseInt(request.getParameter("runs-b")));
        batsmanB.setBalls(Integer.parseInt(request.getParameter("balls-b")));
        list.add(batsmanB);
        template.convertAndSend("${updateDestinationEndpoint}", list);
        return "index.html";
    }

    @RequestMapping({"/", "/home"})
    public String showHome()
    {
        return "index.html";
    }
}