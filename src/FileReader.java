
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import pojo.Game;
import pojo.Turn;

public class FileReader {
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
