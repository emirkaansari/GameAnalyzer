package main;

import java.util.HashMap;
import java.util.Map;

import main.pojo.Game;
import main.pojo.Turn;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * A class that reads game data from a text file and constructs a Map of Game
 * objects indexed by game ID.
 * 
 * Each line in the file represents a single turn in the game, with six
 * comma-separated values:
 * 
 * time: long integer representing the time at which the turn was taken
 * gameId: long integer representing the ID of the game being played
 * playerId: long integer representing the ID of the player taking the turn
 * action: string representing the action taken by the player (e.g. "P Hit", "D
 * Stand", etc.)
 * dealerHand: string representing the dealer's hand at the time of the turn
 * playerHand: string representing the player's hand at the time of the turn
 * If a line is invalid (e.g. has the wrong number of values, contains
 * non-numeric values in time/gameId/playerId, etc.),
 * it will be skipped and an error message will be printed to the console.
 */
public class FileReader {
    /**
     * 
     * Reads game data from a file and constructs a Map of Game objects indexed by
     * game ID.
     * 
     * @param filename the name of the file containing the game data
     * @return a Map of Game objects indexed by game ID
     * @throws IOException if there is an error reading the file
     */
    public Map<Long, Game> readGames(String filename) throws IOException {
        Map<Long, Game> gamesById = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 6) {
                    System.out.println("Invalid input: " + line);
                    continue;
                }
                try {
                    long time = Long.parseLong(parts[0]);
                    long gameId = Long.parseLong(parts[1]);
                    long playerId = Long.parseLong(parts[2]);
                    if (!parts[3].matches(".+") || !parts[4].matches(".+") || !parts[5].matches(".+")) {
                        System.out.println("Invalid input: " + line);
                        continue;
                    }
                    Game game = gamesById.getOrDefault(gameId, new Game(gameId));
                    game.addTurn(new Turn(time, gameId, playerId, parts[3], parts[4], parts[5]));
                    gamesById.put(gameId, game);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + line);
                    continue;
                }
            }
        }
        return gamesById;
    }
}
