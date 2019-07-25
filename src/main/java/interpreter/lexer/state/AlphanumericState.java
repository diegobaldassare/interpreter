package interpreter.lexer.state;

import interpreter.token.TokenType;

import java.util.HashMap;
import java.util.Map;

import static common.Constants.ALPHANUMERIC;
import static common.Constants.DOUBLE_QUOTE;

class AlphanumericState extends LexerState {

    private static AlphanumericState theInstance = null;
    private final Map<String, TokenType> keywords;

    // Singleton
    private AlphanumericState() {
        keywords = initKeywords();
    }

    private Map<String, TokenType> initKeywords() {
        Map<String, TokenType> result = new HashMap<>();
        result.put("string", TokenType.STRING_TYPE);
        result.put("number", TokenType.NUMBER_TYPE);
        result.put("print", TokenType.PRINT);
        result.put("let", TokenType.LET);
        return result;
    }

    @Override
    boolean accepts(Character c) {
        return c.toString().matches(ALPHANUMERIC);
    }

    @Override
    boolean isValidToken(LexerAutomaton context) {
        return context.getCurrentCharacter().toString().matches(ALPHANUMERIC) && !context.getC().equals(DOUBLE_QUOTE);
    }

    @Override
    LexerState next() {
        return new SpaceState();
    }

    @Override
    TokenType getTokenType(LexerAutomaton context) {
        for (String s : keywords.keySet()) {
            if (s.equals(context.getLexeme()))
                return keywords.get(s);
        }
        return TokenType.IDENTIFIER;
    }

    static AlphanumericState getInstance() {
        if (theInstance == null)
            theInstance = new AlphanumericState();
        return theInstance;
    }
}
