package exception;

public class UnknownTaskException extends DukeException {
    private String errorMessage;

    public UnknownTaskException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return String.format("OOPS!!! %s", this.errorMessage);
    }
}
