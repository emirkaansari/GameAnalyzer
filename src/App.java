
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import pojo.*;
public class App {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader();
        RuleChecker ruleChecker = new RuleChecker();
        Map<Long, Game> gamesById =fileReader.readGames("game_data_2.txt");
        for (Game game : gamesById.values()) {
            game.sortTurns();
        }
        Map<Long, Game> sortedGamesById = new TreeMap<>(gamesById);
        //System.out.println(sortedGamesById.values());
        System.out.println(ruleChecker.findFaultyTurns(sortedGamesById));
    }
}
