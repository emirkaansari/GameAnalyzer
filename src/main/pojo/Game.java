package main.pojo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private long id;
    private List <Turn> turns;


    public Game() {
    }

    public Game(long id, List<Turn> turns) {
        this.id = id;
        this.turns = turns;
    }

    public Game(long id) {
        this.id = id;
        this.turns = new ArrayList<>();
    }

    public void addTurn(Turn turn) {
        this.turns.add(turn);
    }

    public void sortTurns() {
        Collections.sort(turns, (t1, t2) -> Long.compare(t1.getTime(), t2.getTime()));
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Turn> getTurns() {
        return this.turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }

    public Game id(long id) {
        setId(id);
        return this;
    }

    public Game turns(List<Turn> turns) {
        setTurns(turns);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", turns='" + getTurns() + "'" +
            "}";
    }


}
