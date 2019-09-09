package duke.exception;

/**
 * Exception thrown when done command is issued on a task that is already done
 */
public class TaskAlreadyDoneException extends DukeException {
    private String errorMessage;

    /**
     * Sets the error message of the exception
     * @param errorMessage String containing error message
     */
    public TaskAlreadyDoneException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Formats error message
     * @return String containing formatted output of error message
     */
    @Override
    public String toString() {
        return String.format("OOPS!!! %s", this.errorMessage);
    }
}