public class Result {

    private int handValue;
    private int unknownCardCount;
    private int cardCount;


    public Result() {
    }

    public Result(int handValue, int unknownCardCount, int cardCount) {
        this.handValue = handValue;
        this.unknownCardCount = unknownCardCount;
        this.cardCount = cardCount;
    }

    public int getHandValue() {
        return this.handValue;
    }

    public void setHandValue(int handValue) {
        this.handValue = handValue;
    }

    public int getUnknownCardCount() {
        return this.unknownCardCount;
    }

    public void setUnknownCardCount(int unknownCardCount) {
        this.unknownCardCount = unknownCardCount;
    }

    public int getCardCount() {
        return this.cardCount;
    }

    public void setCardCount(int cardCount) {
        this.cardCount = cardCount;
    }

    public Result handValue(int handValue) {
        setHandValue(handValue);
        return this;
    }

    public Result unknownCardCount(int unknownCardCount) {
        setUnknownCardCount(unknownCardCount);
        return this;
    }

    public Result cardCount(int cardCount) {
        setCardCount(cardCount);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " handValue='" + getHandValue() + "'" +
            ", unknownCardCount='" + getUnknownCardCount() + "'" +
            ", cardCount='" + getCardCount() + "'" +
            "}";
    }

}
