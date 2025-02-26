package org.example;

import java.util.List;
import java.util.Map;

public class IPLCensor {
    public static void applyCensorship(List<IPLMatch> matches) {
        for (IPLMatch match : matches) {
            match.setTeam1(censorTeamName(match.getTeam1()));
            match.setTeam2(censorTeamName(match.getTeam2()));
            match.setWinner(censorTeamName(match.getWinner()));
            match.setPlayerOfMatch("REDACTED");

            Map<String, Integer> scores = match.getScore();
            Map<String, Integer> censoredScores = new HashMap<>();
            for (Map.Entry<String, Integer> entry : scores.entrySet()) {
                censoredScores.put(censorTeamName(entry.getKey()), entry.getValue());
            }
            match.setScore(censoredScores);
        }
    }

    private static String censorTeamName(String teamName) {
        return teamName.replaceAll("\\s\\w+$", " ***");
    }
}