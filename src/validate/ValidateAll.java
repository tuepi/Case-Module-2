package validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAll {

    public boolean validate(DetailValidate detailValidate, String string) {
        Pattern pattern = Pattern.compile(detailValidate.getRegex());
        Matcher matcher = pattern.matcher(string);
        if (!matcher.matches()){
            System.out.println(detailValidate.getMessage());
            System.out.println("---------------------------------");
        }
        return matcher.matches();
    }
}
