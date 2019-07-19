//package lexer.state;
//
//import lexer.LexerException;
//import lexer.token.TokenType;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//class KeywordsState extends LexerState {
//
//    private int currentTransition;
//    private static KeywordsState theInstance = null;
//    private final Map<String, TokenType> keywords;
//
//    // Singleton
//    private KeywordsState() {
//        keywords = initKeywords();
//    }
//
//    private Map<String, TokenType> initKeywords() {
//        Map<String, TokenType> result = new HashMap<>();
//        result.put("string", TokenType.STRING_TYPE);
//        result.put("number", TokenType.NUMBER_TYPE);
//        result.put("print", TokenType.PRINT);
//        result.put("let", TokenType.LET);
//        return result;
//    }
//
//    @Override
//    boolean accepts(Character c) {
//        for (String s : keywords.keySet()) {
//            if (s.charAt(currentTransition) == c) {
//                currentTransition++;
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    boolean isValidToken(LexerAutomaton context) {
//        for (String s : keywords.keySet()) {
//            if (s.length() == currentTransition) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    LexerState next() {
//        return new StringLiteralState();
//    }
//
//    @Override
//    TokenType getTokenType(LexerAutomaton context) {
//        switch (context.getLexeme()) {
//            case "string":
//                return TokenType.STRING_TYPE;
//
//            case "number":
//                return TokenType.NUMBER_TYPE;
//
//            case "print":
//                return TokenType.PRINT;
//
//            case "let":
//                return TokenType.LET;
//        }
//        throw new LexerException(context);
//    }
//
//    static KeywordsState getInstance() {
//        if (theInstance == null)
//            theInstance = new KeywordsState();
//        return theInstance;
//    }


//    @Override
//    TokenType getTokenType(LexerAutomaton context) {
//        return keywords.get(context.getLexeme().charAt(context.getLexeme().length()));
//    }

//    public boolean accepts(Character c) {
//        for (int i = 0; i < getTransitions().size(); i++) {
//            if (getTransitions().get(i).accepts(c)) {
//                currentTransition = i;
//                return true;
//            }
//        }
//        return false;
//    }

//    @Override
//    boolean isValidToken() {
//        return getTransitions().get(currentTransition).isValidToken();
//    }
//
//    @Override
//    LexerState next() {
//        if (currentTransition == 0) return getTransitions().get(currentTransition).next();
//        return new SpaceState();
//    }


//    static KeywordsState getInstance() {
//        if (theInstance == null) {
//            theInstance = new KeywordsState();
//            for (String s : definedKeywords()) {
//                addTransition(s, theInstance);
//            }
//        }
//        return theInstance;
//    }
//
//    private static List<String> definedKeywords() {
//        List<String> result = new ArrayList<>();
//        result.add("string");
//        result.add("number");
//        result.add("print(");
//        result.add("let");
//        return result;
//    }

//    private static void addTransition(String s, LexerState state) {
//        if (s.length() == state) {
//            state.getTransitions().add(new LexerTransition(s.charAt(0), null, true));
//            return;
//        }
//        if (state.getTransitions().isEmpty()) {
//            state.getTransitions().add(new LexerTransition(s.charAt(0), null, false));
//            return;
//
//        }
//        for (LexerTransition t : state.getTransitions()) {
//            if (t.accepts(s.charAt(0))) {
//                if (t.hasNext()) addTransition(s, t.getNext());
//                else {
//                    KeywordsState nextState = new KeywordsState();
//                    addTransition(s, nextState);
//                    t.setNext(nextState);
//
//                }
//            } else {
//                KeywordsState nextState = new KeywordsState();
//                addTransition(s, nextState);
//                t.setNext(nextState);
//
//            }
//        }
//    }
//}