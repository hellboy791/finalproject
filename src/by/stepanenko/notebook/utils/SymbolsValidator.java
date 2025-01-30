package by.stepanenko.notebook.utils;

import java.util.regex.Pattern;

public class SymbolsValidator implements Matcher{
    private final Pattern SYMBOLS_PATTERN = Pattern.compile("(.*);(.*)");

    public SymbolsValidator(){}

    @Override
    public boolean match(String value) {
        return SYMBOLS_PATTERN.matcher(value).matches();
    }
}

