package exception;

public class MissingEventDateException extends DukeException {
    private String errorMessage;

    public MissingEventDateException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return String.format("OOPS!!! %s", this.errorMessage);
    }
}