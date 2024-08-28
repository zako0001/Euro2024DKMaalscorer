package Euro2024DKMaalscorer;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    @Test
    void getNumberOfGoalsNotZero() throws FileNotFoundException {

        Statistics statistics = new Statistics("src/main/resources/Euro2024QualifyingRound.csv");

        String goalScorerKey = "Wind";
        int expectedResult= 3;
        int actualResult = statistics.getNumberOfGoals(goalScorerKey);
        assertEquals(expectedResult, actualResult);
    }
}