package validate;

public class DetailValidate {
    private String regex;
    private String message;

    public DetailValidate() {
    }

    public DetailValidate(String regex, String message) {
        this.regex = regex;
        this.message = message;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
