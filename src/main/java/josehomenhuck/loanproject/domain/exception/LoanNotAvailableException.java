package josehomenhuck.loanproject.domain.exception;

public class LoanNotAvailableException extends RuntimeException {

    public LoanNotAvailableException(String message) {
        super(message);
    }
}
