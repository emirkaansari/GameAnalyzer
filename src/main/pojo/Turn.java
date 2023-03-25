package main.pojo;

public class Turn {
    private Long time;
    private Long gameId;
    private Long playerId;
    private String action;
    private String dealerHand;
    private String playerHand;

    public Turn() {
    }

    public Turn(Long time, Long gameId, Long playerId, String action, String dealerHand, String playerHand) {
        this.time = time;
        this.gameId = gameId;
        this.playerId = playerId;
        this.action = action;
        this.dealerHand = dealerHand;
        this.playerHand = playerHand;
    }

    public Long getTime() {
        return this.time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getGameId() {
        return this.gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDealerHand() {
        return this.dealerHand;
    }

    public void setDealerHand(String dealerHand) {
        this.dealerHand = dealerHand;
    }

    public String getPlayerHand() {
        return this.playerHand;
    }

    public void setPlayerHand(String playerHand) {
        this.playerHand = playerHand;
    }

    public Turn time(Long time) {
        setTime(time);
        return this;
    }

    public Turn gameId(Long gameId) {
        setGameId(gameId);
        return this;
    }

    public Turn playerId(Long playerId) {
        setPlayerId(playerId);
        return this;
    }

    public Turn action(String action) {
        setAction(action);
        return this;
    }

    public Turn dealerHand(String dealerHand) {
        setDealerHand(dealerHand);
        return this;
    }

    public Turn playerHand(String playerHand) {
        setPlayerHand(playerHand);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " time='" + getTime() + "'" +
            ", gameId='" + getGameId() + "'" +
            ", playerId='" + getPlayerId() + "'" +
            ", action='" + getAction() + "'" +
            ", dealerHand='" + getDealerHand() + "'" +
            ", playerHand='" + getPlayerHand() + "'" +
            "}";
    }
}


