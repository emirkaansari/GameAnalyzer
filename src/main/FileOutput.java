package main;

import java.util.List;

import main.pojo.Turn;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The FileOutput class is responsible for writing the unsatisfied turns to a
 * file.
 */
public class FileOutput {
    /**
     * Writes the unsatisfied turns to a file named "analyzer_results.txt".
     *
     * @param unsatisfiedList a list of unsatisfied turns to be written to the file.
     */
    public void writeUnsatisfied(List<Turn> unsatisfiedList) {
        try {
            String fileName = "analyzer_results.txt";
            FileWriter writer = new FileWriter(fileName);
            for (Turn turn : unsatisfiedList) {
                writer.write(turn.getTime() + "," + turn.getGameId()
                        + "," + turn.getPlayerId()
                        + "," + turn.getAction() + ","
                        + turn.getDealerHand() + ","
                        + turn.getPlayerHand() + System.lineSeparator());
            }
            writer.close();
            System.out.println("Successfully wrote unsatisfied data to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
    }
}
