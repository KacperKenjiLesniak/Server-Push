package hello;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LiveScoreService
{
    private List<Batsman> scoresList = initialScores();

    private List<Batsman> initialScores()
    {

        Batsman sachin = new Batsman();

        sachin.setName("Sachin Tendulkar");
        sachin.setRuns(24);
        sachin.setBalls(26);

        Batsman ganguly = new Batsman();
        ganguly.setName("Sourav Ganguly");
        ganguly.setRuns(28);
        ganguly.setBalls(30);

        List<Batsman> scoresList = new ArrayList<Batsman>();

        scoresList.add(sachin);
        scoresList.add(ganguly);

        return scoresList;
    }
}