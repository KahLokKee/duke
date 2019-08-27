public class MissingEventDateException extends Exception {
    private String errorMessage;

    public MissingEventDateException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return String.format("OOPS!!! %s", this.errorMessage);
    }
}