package codechallenge.perfectnumbers.exception;

/**
 * @author kolin
 *
 */
public class ErrorMessage {

    private String error;
    private int status;

    public ErrorMessage() {
    }

    public ErrorMessage(String error, int status) {
        this.error = error;
        this.status = status;
    }

    public String getErrorMessage() {
        return error;
    }

    public void setErrorMessage(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}