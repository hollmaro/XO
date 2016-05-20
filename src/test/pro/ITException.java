package test.pro;

/**
 * Created by ROMAN on 19.05.2016.
 */
public class ITException extends Exception {
    @Override
    public String getMessage() {
        return "ITException: " + super.getMessage();
    }
    public ITException(String text){
        super(text);

    }
}
