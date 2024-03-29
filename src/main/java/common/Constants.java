package common;

public final class Constants {

    private Constants() {
        throw new IllegalStateException("common.Constants class");
    }

    public static final Character DOUBLE_QUOTE = '\"';
    public static final Character QUOTE = '\'';
    public static final Character SPACE = ' ';
    public static final String ALPHANUMERIC = "[a-zA-Z|0-9]";
    public static final String NUMBER = "[0-9]";
    public static final String NUMBERS = "[0-9]*";

    public static final String NOT_A_DOUBLE_QUOTE = "[^\"]";
    public static final String SEPARATOR = ";|:|=|\\)|\\(";
    public static final String LETTER = "[a-zA-Z]";
    public static final String OPERATOR = "\\+|-|\\*|/";
    public static final String SPACES = "[\\s]*";
    public static final String NEW_LINE = "\n";
    public static final String NEW_LINES = "[\n]*";
    public static final String STRING = "^\".*\"$";
}
