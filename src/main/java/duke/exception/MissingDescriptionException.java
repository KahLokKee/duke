package duke.exception;

public class MissingDescriptionException extends DukeException {
    private String errorMessage;

    public MissingDescriptionException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return String.format("OOPS!!! %s", this.errorMessage);
    }
}
