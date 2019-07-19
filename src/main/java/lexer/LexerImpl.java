//package lexer;
//
//import lexer.state.LexerAutomaton;
//import lexer.state.Context;
//import lexer.token.Token;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class LexerImpl implements Lexer {
//
//    private Context context;
//
//    public LexerImpl() {
//        this.context = new LexerAutomaton();
//    }
//
//    /**
//     * Lexical analyzer (also known as scanner or tokenizer)
//     * This method is responsible for breaking a sentence
//     * apart into tokens. One token at a time.
//     * @param input
//     * @return
//     */
//    @Override
//    public List<Token> lex(String input) {
//        List<Token> tokens = new ArrayList<>();
//
//        for (int i = 0; i < input.length(); i++) {
//            context.next(input.charAt(i));
//        }
//        return tokens;
//    }
//
//}
