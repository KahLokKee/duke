public class UnknownCommandException extends Exception {
    String errorMessage;

    public UnknownCommandException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return String.format("OOPS!!! %s", this.errorMessage);
    }
}
