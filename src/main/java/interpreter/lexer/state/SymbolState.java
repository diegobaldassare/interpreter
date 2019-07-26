package interpreter.lexer.state;

import interpreter.token.Token;
import interpreter.token.TokenImpl;
import interpreter.token.TokenType;

import java.util.HashMap;
import java.util.Map;

import static interpreter.token.TokenType.SEMICOLON;

class SymbolState extends LexerState {

    private static SymbolState theInstance;
    private final Map<Character, TokenType> symbols;
    private boolean readingSymbol; //fixes when more than one symbol is findById all together

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
        result.put(';', SEMICOLON);
        return result;
    }

    @Override
    boolean accepts(Character c) {
        if (symbols.containsKey(c) && !readingSymbol) {
            readingSymbol = true;
            return true;
        }
        return false;
    }

    @Override
    boolean isValidToken(LexerAutomaton context) {
        if (symbols.containsKey(context.getCurrentCharacter())) {
            readingSymbol = false;
            return true;
        }
        return false;
    }

    @Override
    LexerState next() {
        return new StringLiteralState();
    }

    @Override
    TokenType getTokenType(LexerAutomaton context) {
        return symbols.get(context.getCurrentCharacter());
    }

    @Override
    Token generateToken(LexerAutomaton context) {
        Token result = new TokenImpl(getTokenType(context), context.getFromColumn(), context.getToColumn(), context.getLine(), context.getLexeme());
        if (context.getCurrentCharacter().equals(';')) {
            context.setLine(context.getLine() + 1);
            context.setFromColumn(0);
            context.setStringLiterals(0);
            context.setPastLines(context.getPastLines() + context.getI() - context.getLineStart());
            context.setLineStart(context.getI());
        }
        return result;
    }

    static SymbolState getInstance() {
        if (theInstance == null)
            theInstance = new SymbolState();;
        return theInstance;
    }
}
