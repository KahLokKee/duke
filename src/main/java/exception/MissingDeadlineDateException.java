package exception;

public class MissingDeadlineDateException extends DukeException {
    private String errorMessage;

    public MissingDeadlineDateException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return String.format("OOPS!!! %s", this.errorMessage);
    }
}