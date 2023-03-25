package main;

import java.util.Map;
import java.util.TreeMap;

import main.pojo.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Create instances of FileReader, RuleChecker, and FileOutput
        FileReader fileReader = new FileReader();
        RuleChecker ruleChecker = new RuleChecker();
        FileOutput fileOutput = new FileOutput();

        // Read game data from file using the FileReader instance
        Map<Long, Game> gamesById = fileReader.readGames("src/main/resources/game_data_2.txt");
        // Sort the turns for each game
        for (Game game : gamesById.values()) {
            game.sortTurns();
        }
        // Sort the games by ID using a TreeMap
        Map<Long, Game> sortedGamesById = new TreeMap<>(gamesById);

        // Find faulty turns using the RuleChecker instance and write them to a file
        // using the FileOutput instance
        fileOutput.writeUnsatisfied(ruleChecker.findFaultyTurns(sortedGamesById));
    }
}
