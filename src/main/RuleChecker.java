package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.pojo.Game;
import main.pojo.Result;
import main.pojo.Turn;

/**
 * 
 * RuleChecker class checks the validity of each turn of a game using
 * HandCalculator
 * 
 */
public class RuleChecker {
    /**
     * 
     * This function finds the faulty turns in each game using a HandCalculator
     * 
     * @param gamesById Map of games to be checked where game ids are keys
     * 
     * @return List of faulty turns
     */
    public List<Turn> findFaultyTurns(Map<Long, Game> gamesById) {
        HandCalculator handCalculator = new HandCalculator();
        List<Turn> unsatisfiedTurns = new ArrayList<>();
        for (Map.Entry<Long, Game> entry : gamesById.entrySet()) {
            Game game = entry.getValue();
            List<Turn> turns = game.getTurns();
            Turn preTurn = turns.get(0);
            boolean satisfied = true;

            for (int i = 0; i < turns.size(); i++) {
                if (i > 0) {
                    preTurn = turns.get(i - 1);
                }
                Turn turn = turns.get(i);

                int[] dealerResult = handCalculator.calculateHand(turn.getDealerHand());
                Result dealer = new Result(dealerResult[0], dealerResult[1], dealerResult[2]);

                int[] playerResult = handCalculator.calculateHand(turn.getPlayerHand());
                Result player = new Result(playerResult[0], playerResult[1], playerResult[2]);

                String action = turn.getAction();
                String preAction = preTurn.getAction();

                switch (action) {
                    case "P Joined":
                        if (i == 0 && dealer.getUnknownCardCount() == 1 && dealer.getCardCount() == 2
                                && player.getCardCount() == 2 && player.getUnknownCardCount() == 0) {
                            break;
                        } else {
                            unsatisfiedTurns.add(turn);
                            satisfied = false;
                            break;
                        }
                    case "P Hit":
                        if ((preAction.equals("P Joined") || preAction.equals("P Hit") || preAction.equals("D Redeal"))
                                && dealer.getUnknownCardCount() == 1 && dealer.getCardCount() == 2
                                && player.getUnknownCardCount() == 0 && player.getHandValue() < 20) {
                            break;
                        } else {
                            unsatisfiedTurns.add(turn);
                            satisfied = false;
                            break;
                        }
                    case "P Stand":
                        if ((preAction.equals("P Joined") || preAction.equals("P Hit") || preAction.equals("D Redeal"))
                                && dealer.getUnknownCardCount() == 1 && dealer.getCardCount() == 2
                                && player.getUnknownCardCount() == 0 && player.getHandValue() < 22) {
                            break;
                        } else {
                            unsatisfiedTurns.add(turn);
                            satisfied = false;
                            break;
                        }
                    case "D Show":
                        if ((preAction.equals("P Stand"))
                                && dealer.getUnknownCardCount() == 1 && dealer.getCardCount() == 2
                                && player.getUnknownCardCount() == 0 && player.getHandValue() < 22) {
                            break;
                        } else {
                            unsatisfiedTurns.add(turn);
                            satisfied = false;
                            break;
                        }
                    case "D Hit":
                        if ((preAction.equals("D Show") || preAction.equals("D Hit"))
                                && dealer.getUnknownCardCount() == 0 && player.getUnknownCardCount() == 0
                                && player.getHandValue() < 22 && dealer.getHandValue() < 17) {
                            break;
                        } else {
                            unsatisfiedTurns.add(turn);
                            satisfied = false;
                            break;
                        }
                    case "P Win":
                        if (((preAction.equals("D Show") || preAction.equals("D Hit"))
                                && dealer.getUnknownCardCount() == 0 && player.getUnknownCardCount() == 0
                                && dealer.getHandValue() > 17
                                && player.getHandValue() < 22)
                                && ((player.getHandValue() >= dealer.getHandValue()) || (dealer.getHandValue() > 21))) {
                            break;
                        } else {
                            unsatisfiedTurns.add(turn);
                            satisfied = false;
                            break;
                        }
                    case "P Lose":
                        if (((preAction.equals("D Show") || preAction.equals("D Hit") || preAction.equals("P Hit"))
                                && dealer.getUnknownCardCount() < 2 && player.getUnknownCardCount() == 0)
                                && ((player.getHandValue() < dealer.getHandValue()) || (player.getHandValue() > 21))
                                && (dealer.getHandValue() < 22)) {
                            break;
                        } else {
                            unsatisfiedTurns.add(turn);
                            satisfied = false;
                            break;
                        }
                    case "D Redeal":
                        if ((preAction.equals("P Win") || preAction.equals("P Lose"))
                                && dealer.getUnknownCardCount() == 1 && dealer.getCardCount() == 2
                                && player.getCardCount() == 2 && player.getUnknownCardCount() == 0) {
                            break;
                        } else {
                            unsatisfiedTurns.add(turn);
                            satisfied = false;
                            break;
                        }
                }
                if (satisfied == false) {
                    break;
                }
            }
        }
        return unsatisfiedTurns;
    }
}
