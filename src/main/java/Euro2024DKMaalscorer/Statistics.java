package Euro2024DKMaalscorer;

import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {

    // Attribute
    private List<MatchResult> matchResults;
    private Map<String, Integer> goalsPerScorer;

    // Constructor
    public Statistics(String filename) throws FileNotFoundException {
        matchResults = new MatchResultFileReader(filename).readFile();
    }

    // Getters
    public Set<String> getGoalScorers() {

        return getGoalsPerScorer().keySet();
    }

    public Map<String, Integer> getGoalsPerScorer() {

        if (goalsPerScorer != null) {
            return goalsPerScorer;
        }

        goalsPerScorer = new HashMap<>();

        for (MatchResult matchResult : matchResults) {

            for (String goalScorer : matchResult.getGoalScorers()) {

                goalsPerScorer.putIfAbsent(goalScorer, 0);
                goalsPerScorer.replace(goalScorer, goalsPerScorer.get(goalScorer) + 1);
            }
        }

        return goalsPerScorer;
    }

    public int getNumberOfGoals(String goalScorer) {

        return getGoalsPerScorer().get(goalScorer);
    }
}