package lexer.token;

/**
 * Created by Diego Baldassare on 2019-06-18.
 */
public enum TokenType {

    IDENTIFIER, //name of variables

    STRING_LITERAL, //[0-9]
    NUMBER_LITERAL, //[a-zA-Z]

    STRING_TYPE("string"), //string primitive data type
    NUMBER_TYPE("number"), //number primitive data type

    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),

    DECLARATION(":"),
    ASSIGNATION("="),

    END_STATEMENT(";"),

    NEW_LINE("\\n"),
    SPACE(" "),

    LET("let"),
    PRINT("print");

    private String representation;

    TokenType() {}

    TokenType(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        if (representation != null) return String.format("%s(%s)", this.name(), representation);
        return this.name();
    }

    public String getRepresentation() {
        return representation;
    }
}
