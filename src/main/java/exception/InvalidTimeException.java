package exception;

public class InvalidTimeException extends DukeException {
    private String errorMessage;

    public InvalidTimeException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return String.format("OOPS!!! %s", this.errorMessage);
    }
}
