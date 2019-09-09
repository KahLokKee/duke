package duke.exception;

/**
 * Exception thrown when command given is not recognized
 */
public class UnknownCommandException extends DukeException {
    private String errorMessage;

    /**
     * Sets the error message of the exception
     * @param errorMessage String containing error message
     */
    public UnknownCommandException(String errorMessage) {
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
