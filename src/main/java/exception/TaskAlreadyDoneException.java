package exception;

public class TaskAlreadyDoneException extends DukeException {
    private String errorMessage;

    public TaskAlreadyDoneException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return String.format("OOPS!!! %s", this.errorMessage);
    }
}