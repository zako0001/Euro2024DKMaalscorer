package Euro2024DKMaalscorer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MatchResultFileReader {

    // Attributes
    private final Scanner scanner;

    // Constructor
    public MatchResultFileReader(String fileName) throws FileNotFoundException {
        scanner = new Scanner(new File(fileName));
    }

    // Method
    public List<MatchResult> readFile() {

        List<MatchResult> matchResults = new ArrayList<>();

        while (scanner.hasNextLine()) {

            String[] line = scanner.nextLine().split(";");
            String teams = line[0];
            List<String> scorers = new ArrayList<>();

            if (line.length > 1) {
                scorers.addAll(Arrays.asList(line[1].split(",")));
            }

            matchResults.add(new MatchResult(teams, scorers));
        }

        return matchResults;
    }
}