package openmrsproject.core.utilities.results;

public class SuccessResult extends Result {
    public SuccessResult() {
        super(true);
    }
    public SuccessResult(String message) {
        super(true,message);
    }
    public SuccessResult(boolean result,String message) {
        super(result,message);
    }
}
