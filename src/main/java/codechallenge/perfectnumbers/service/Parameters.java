package codechallenge.perfectnumbers.service;

/**
 * @author kolin
 *
 */
public class Parameters {

    private Long startNumber;
    private Long endNumber;

    public Parameters(Long startNumber, Long endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    public Long getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(Long startNumber) {
        this.startNumber = startNumber;
    }

    public Long getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(Long endNumber) {
        this.endNumber = endNumber;
    }
}