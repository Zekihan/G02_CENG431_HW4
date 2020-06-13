package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameReport {
    private List<Integer> playerScores;

    public GameReport(List<Integer> playerScores) {
        this.playerScores = playerScores;
    }

    public int getPlayerScore(int playerNo){
        return playerScores.get(playerNo);
    }

    public int getWinner(){
        int maxVal = Collections.max(playerScores);
        return playerScores.indexOf(maxVal);
    }

    public int winMargin(){
        Integer maxVal = Collections.max(playerScores);
        int i = playerScores.indexOf(maxVal);
        List<Integer> scores = new ArrayList(playerScores);
        scores.remove(i);
        Integer secMaxVal = Collections.max(scores);

        return maxVal - secMaxVal;
    }
}
