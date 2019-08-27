public class TaskAlreadyDoneException extends Exception {
    private String errorMessage;

    public TaskAlreadyDoneException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return String.format("OOPS!!! %s", this.errorMessage);
    }
}