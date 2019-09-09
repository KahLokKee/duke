package duke.ui;

import java.util.Scanner;

/**
 * Manages all input and output relating to duke
 */
public class Ui {
    Scanner sc;

    /**
     * Constructor for Ui
     */
    public Ui() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Prints welcome message
     */
    public void showWelcome() {
        System.out.println("Hello! I'm duke.Duke\nWhat can I do for you?");
    }

    /**
     * Prints goodbye message
     */
    public void showGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Prints loading error message
     */
    public void showLoadingError() {
        System.out.println("Save file not detected!");
    }

    /**
     * Reads input from user
     * @return String containing user input
     */
    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Prints error message
     * @param errorMessage String containing error message
     */
    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    /**
     * Prints an empty line
     */
    public void showLine() {
        System.out.println("____________________________________________________________");
    }
}
