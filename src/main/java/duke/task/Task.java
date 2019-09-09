package duke.task;

/**
 * Abstract class that represents a Task
 */
public abstract class Task {
    private String description;
    private boolean isDone;

    /**
     * Default constructor for Task
     * @param description String containing the name of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Gets the status icon of the Task
     * @return "Y" if Task is done and "N" if Task is not done
     */
    public String getStatusIcon() {
        return (isDone ? "Y" : "N");
    }

    /**
     * Gets the description of the Task
     * @return String containing description of the Task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the done status of the Task
     * @param done Status of the Task
     */
    public void setDone(boolean done) {
        isDone = done;
    }

    /**
     * Formats task into a String
     * @return String containing details of Task
     */
    @Override
    public abstract String toString();

    /**
     * Sets isDone variable to true
     */
    public void markAsDone() {
        this.isDone = true;
    }

}
