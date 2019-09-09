package duke.exception;

/**
 * Exception thrown when task selected does not exist
 */
public class UnknownTaskException extends DukeException {
    private String errorMessage;

    /**
     * Sets the error message of the exception
     * @param errorMessage String containing error message
     */
    public UnknownTaskException(String errorMessage) {
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
