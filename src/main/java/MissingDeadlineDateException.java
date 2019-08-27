public class MissingDeadlineDateException extends Exception {
    private String errorMessage;

    public MissingDeadlineDateException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return String.format("OOPS!!! %s", this.errorMessage);
    }
}