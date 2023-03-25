import java.util.List;
import java.util.Map;

import pojo.Game;
import pojo.Turn;

public class RuleChecker {
    public void findFaultyTurns(Map<Long, Game> gamesById) {
        HandCalculator handCalculator = new HandCalculator();

        for (Map.Entry<Long, Game> entry : gamesById.entrySet()) {
            long gameId = entry.getKey();
            Game game = entry.getValue();
            List<Turn> turns = game.getTurns();
            Turn preTurn = turns.get(0);

            for (int i = 0; i < turns.size(); i++) {
                if (i > 0) {
                     preTurn = turns.get(i - 1);
                }
                Turn turn = turns.get(i);
                // do something with the turn
                
                int[] dealerResult = handCalculator.calculateHand(turn.getDealerHand());
                Result dealer = new Result(dealerResult[0], dealerResult[1], dealerResult[2]);

                int[] playerResult = handCalculator.calculateHand(turn.getPlayerHand());
                Result player = new Result(playerResult[0], playerResult[1], playerResult[2]);

                String action = turn.getAction();
                String preAction = preTurn.getAction();

                switch (action) {
                    case "P Joined":
                    if(i == 0 && dealer.getUnknownCardCount() == 1 && dealer.getCardCount() == 2 
                    && player.getCardCount() == 2 && player.getUnknownCardCount() == 0)
                        break;
                    case "P Hit":
                    if((preAction.equals("P Joined") || preAction.equals("P Hit") || preAction.equals("D Redeal")) 
                    && dealer.getUnknownCardCount() == 1 && dealer.getCardCount() == 2 && player.getUnknownCardCount() == 0 && player.getHandValue() < 21)
                        break;
                    case "P Stand":
                    if((preAction.equals("P Joined") || preAction.equals("P Hit") || preAction.equals("D Redeal")) 
                    && dealer.getUnknownCardCount() == 1 && dealer.getCardCount() == 2 && player.getUnknownCardCount() == 0 && player.getHandValue() < 21)
                        break;
                    case "D Show":
                    
                    
                        break;
                    case "D Hit":
                      
                        break;
                    case "P Win":
                     
                        break;
                    case "P Lose":
                      

            }
        }
    }
}
}
