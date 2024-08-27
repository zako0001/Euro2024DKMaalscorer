package Euro2024DKMaalscorer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
            String match = line[0];
            List<String> scorers = new ArrayList<>();

            if (line.length == 2) {
                List<String> unmodifiableList = List.of(line[1].split(","));
                scorers.addAll(unmodifiableList);
            }

            matchResults.add(new MatchResult(match, scorers));
        }

        return matchResults;
    }
}