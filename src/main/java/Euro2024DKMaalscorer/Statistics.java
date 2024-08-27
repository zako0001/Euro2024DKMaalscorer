package Euro2024DKMaalscorer;

import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {

    // Attribute
    private List<MatchResult> matchResults;

    // Constructor
    public Statistics(String filename) throws FileNotFoundException {
        matchResults = new MatchResultFileReader(filename).readFile();
    }

    // Getters
    public Set<String> getGoalScorers() {

        Set<String> goalScorers = new HashSet<>();

        for (MatchResult matchResult : matchResults) {
            goalScorers.addAll(matchResult.getGoalScorers());
        }

        return goalScorers;
    }

    public Map<String, Integer> getGoalScorersWithTotals() {

        Map<String, Integer> map = new HashMap<>();

        for (MatchResult matchResult : matchResults) {

            for (String goalScorer : matchResult.getGoalScorers()) {

                map.putIfAbsent(goalScorer, 0);
                map.replace(goalScorer, map.get(goalScorer) + 1);
            }
        }

        return map;
    }

    public int getNumberOfGoals(String goalScorer) {

        return getGoalScorersWithTotals().get(goalScorer);
    }
}