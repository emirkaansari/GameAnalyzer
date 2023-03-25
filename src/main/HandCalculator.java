package main;

/**
 * 
 * A class to calculate the value of a given hand.
 */
public class HandCalculator {
    /**
     * Calculates the value of a given hand represented as a string.
     * 
     * @param hand the hand to be evaluated
     * @return an integer array representing the value of the hand, the number of
     *         unknown cards and the total number of cards in the hand
     */
    public int[] calculateHand(String hand) {
        int handValue = 0;
        int questionCount = 0;
        String[] cards = hand.split("-");

        for (String card : cards) {
            if (!card.equals("?")) {
                char value = card.charAt(0);
                int cardValue = 0;
                switch (value) {
                    case 'A':
                        cardValue = 11;
                        break;
                    case '2':
                        cardValue = 2;
                        break;
                    case '3':
                        cardValue = 3;
                        break;
                    case '4':
                        cardValue = 4;
                        break;
                    case '5':
                        cardValue = 5;
                        break;
                    case '6':
                        cardValue = 6;
                        break;
                    case '7':
                        cardValue = 7;
                        break;
                    case '8':
                        cardValue = 8;
                        break;
                    case '9':
                        cardValue = 9;
                        break;
                    case 'K':
                    case 'k':
                    case 'Q':
                    case 'q':
                    case 'J':
                    case 'j':
                    case 'T':
                    case 't':
                        cardValue = 10;
                        break;
                }
                handValue += cardValue;
            } else {
                questionCount++;
            }
        }

        return new int[] { handValue, questionCount, cards.length };
    }

}
