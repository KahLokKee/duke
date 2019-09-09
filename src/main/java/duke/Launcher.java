package duke;

import javafx.application.Application;

/**
 * A launcher class to workaround classpath issues.
 */
public class Launcher {
    /**
     * Launches duke GUI
     * @param args unused
     */
    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}