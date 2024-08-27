package Euro2024DKMaalscorer;

import java.util.List;

public class MatchResult {

    // Attributes
    private String teams;
    private List<String> goalScorers;

    // Constructor
    public MatchResult(String teams, List<String> goalScorers) {

        if (teams == null || goalScorers == null) {
            throw new NullPointerException("teams and goalScorers cannot be null.");
        }

        this.teams = teams;
        this.goalScorers = goalScorers;
    }

    // Getter
    public List<String> getGoalScorers() {

        return List.copyOf(goalScorers);
    }
}