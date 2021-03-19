public class InvalidException extends RuntimeException{
    public InvalidException(String message) {
        super(message);
    }
    public InvalidException(int an) {
        super(an + " nu este un an corect.");
    }
}
