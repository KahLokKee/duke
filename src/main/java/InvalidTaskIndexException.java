public class InvalidTaskIndexException extends Exception {
    String errorMessage;

    public InvalidTaskIndexException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return String.format("OOPS!!! %s", this.errorMessage);
    }
}