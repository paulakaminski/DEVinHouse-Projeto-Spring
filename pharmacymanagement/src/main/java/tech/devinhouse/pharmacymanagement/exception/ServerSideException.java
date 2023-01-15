package tech.devinhouse.pharmacymanagement.exception;

public class ServerSideException extends RuntimeException {

    public ServerSideException() {
        super();
    }

    public ServerSideException(String message) {
        super(message);
    }

    public ServerSideException(String message, Throwable cause) {
        super(message, cause);
    }

}
