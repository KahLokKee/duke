package exception;

public class EmptyListException extends DukeException {
    private String errorMessage;

    public EmptyListException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return String.format("OOPS!!! %s", this.errorMessage);
    }
}
