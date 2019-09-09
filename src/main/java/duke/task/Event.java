package duke.task;

/**
 * Class that represents an event
 */
public class Event extends Task {
    private String at;

    /**
     * Default constructor for event object
     * @param description String containing name of Event
     * @param at String containing Date and Time of Event
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Formats event into a String
     * @return String containing details of Event
     */
    @Override
    public String toString() {
        return "[E][" + super.getStatusIcon() + "] " + super.getDescription() + " (at: " + at + ")";
    }

}
