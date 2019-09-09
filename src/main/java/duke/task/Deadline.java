package duke.task;

/**
 * Class that represents an deadline
 */
public class Deadline extends Task {
    private String by;

    /**
     * Default constructor for deadline object
     * @param description String containing name of deadline
     * @param by String containing Date and Time of Deadline
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D][" + super.getStatusIcon() + "] " + super.getDescription() + " (by: " + by + ")";
    }
}
