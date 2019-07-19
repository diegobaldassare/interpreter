package lexer.state;

import lexer.token.TokenType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SymbolState extends LexerState {

    private static SymbolState theInstance;
    private final Map<Character, TokenType> symbols;

    // Singleton
    private SymbolState() {
        symbols = initSymbols();
    }

    private Map<Character, TokenType> initSymbols() {
        Map<Character, TokenType> result = new HashMap<>();
        result.put('(', TokenType.LEFT_PARENTHESIS);
        result.put(')', TokenType.RIGHT_PARENTHESIS);
        result.put('+', TokenType.PLUS_SYMBOL);
        result.put('-', TokenType.SLASH);
        result.put('*', TokenType.ASTERISK);
        result.put('/', TokenType.FORWARD_SLASH);
        result.put('=', TokenType.EQUALS);
        result.put(':', TokenType.COLON);
        result.put(';', TokenType.SEMICOLON);
        return result;
    }

    @Override
    boolean accepts(Character c) {
        return symbols.containsKey(c);
    }

    @Override
    boolean isValidToken(LexerAutomaton context) {
        return symbols.containsKey(context.getC());
    }

    @Override
    LexerState next() {
        return new StringLiteralState();
    }

    @Override
    TokenType getTokenType(LexerAutomaton context) {
        return symbols.get(context.getLexeme().charAt(context.getLexeme().length()));
    }

    static SymbolState getInstance() {
        if (theInstance == null)
            theInstance = new SymbolState();;
        return theInstance;
    }
}
