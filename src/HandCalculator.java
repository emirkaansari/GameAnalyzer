public class HandCalculator {
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
                    case 'Q':
                    case 'J':
                    case 'T':
                        cardValue = 10;
                        break;
                }
                handValue += cardValue;
            } else {
                questionCount++;
            }
        }
        
        return new int[] {handValue, questionCount, cards.length};
    }
    
}
