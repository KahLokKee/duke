package exception;

public class UnknownCommandException extends DukeException {
    private String errorMessage;

    public UnknownCommandException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return String.format("OOPS!!! %s", this.errorMessage);
    }
}
