package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScoreScheduler {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    LiveScoreService service;

    @Scheduled(fixedRate = 5000)
    public void publishUpdates(){

        template.convertAndSend("/topic/myscores", service.getScore());

    }

}