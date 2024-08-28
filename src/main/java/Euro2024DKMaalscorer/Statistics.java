package Euro2024DKMaalscorer;

import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {

    // Attribute
    private List<MatchResult> matchResults;
    private Map<String, Integer> goalScorersWithTotals;

    // Constructor
    public Statistics(String filename) throws FileNotFoundException {
        matchResults = new MatchResultFileReader(filename).readFile();
    }

    // Getters
    public Set<String> getGoalScorers() {

        return getGoalScorersWithTotals().keySet();
    }

    public Map<String, Integer> getGoalScorersWithTotals() {

        if (goalScorersWithTotals != null) {
            return goalScorersWithTotals;
        }

        Map<String, Integer> goalsPerScorer = new HashMap<>();

        for (MatchResult matchResult : matchResults) {

            for (String goalScorer : matchResult.getGoalScorers()) {

                goalsPerScorer.putIfAbsent(goalScorer, 0);
                goalsPerScorer.replace(goalScorer, goalsPerScorer.get(goalScorer) + 1);
            }
        }

        return goalsPerScorer;
    }

    public int getNumberOfGoals(String goalScorer) {

        return getGoalScorersWithTotals().get(goalScorer);
    }
}