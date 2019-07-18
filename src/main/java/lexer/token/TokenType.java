package lexer.token;

/**
 * This class represents the type of a Token.
 *
 * Note that it describes the lexical symbols (i.e. EQUALS)
 * and not its meanings as the operations that can perform (i.e. ASSIGNATION).
 *
 * Note that quote marks are not a token type, since it is the lexicographical form to recognize a string literal.
 */
public enum TokenType {

    IDENTIFIER, //name of variables

    STRING_LITERAL, // [a-zA-Z] (anything between "")
    NUMBER_LITERAL, // [0-9]

    PLUS_SYMBOL, // "+"
    SLASH, // "-"
    ASTERISK, // "*"
    FORWARD_SLASH, // "/"

    COLON, // ":"
    SEMICOLON, // ";"
    EQUALS, // "="
    SPACE, // " "

    STRING_TYPE, // "string" (string primitive data type)
    NUMBER_TYPE, // "number" (number primitive data type)
    LET, // "let"
    PRINT, // "print"
    LEFT_PARENTHESIS, // "("
    RIGHT_PARENTHESIS, // ")"
}
