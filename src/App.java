
import java.util.Map;
import pojo.*;
public class App {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader();
        Map<Long, Game> gamesById =fileReader.readGames("game_data_1.txt");
        for (Game game : gamesById.values()) {
            game.sortTurns();
        }
        System.out.println(gamesById.toString());
    }
}
