package duke.exception;

public class InvalidTaskIndexException extends DukeException {
    private String errorMessage;

    public InvalidTaskIndexException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return String.format("OOPS!!! %s", this.errorMessage);
    }
}
