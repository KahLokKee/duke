package duke.task;

/**
 * Class that represents a todo item
 */
public class Todo extends Task {
    /**
     * Constructor for todo object
     * @param description name of todo item
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Formats todo item into a string
     * @return String containing details of todo
     */
    @Override
    public String toString() {
        return "[T][" + super.getStatusIcon() + "] " + super.getDescription();
    }

}
