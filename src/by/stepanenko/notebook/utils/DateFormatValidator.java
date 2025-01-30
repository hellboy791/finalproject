package by.stepanenko.notebook.utils;

import java.util.regex.Pattern;

public class DateFormatValidator implements Matcher{
    private final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");

    public DateFormatValidator(){

    }

    @Override
    public boolean match(String date) {
        return this.DATE_PATTERN.matcher(date).matches();
    }
}
