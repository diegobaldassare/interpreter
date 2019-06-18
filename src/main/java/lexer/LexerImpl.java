package lexer;

import lexer.state.Automaton;
import lexer.state.Context;
import lexer.token.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Baldassare on 2019-06-18.
 */
public class LexerImpl implements Lexer {

    private Context context;

    public LexerImpl() {
        this.context = new Automaton();
    }

    @Override
    public List<Token> lex(String statements) {
        List<Token> tokens = new ArrayList<>();

        for (int i = 0; i < statements.length(); i++) {
            context.next(statements.charAt(i));
        }
        return tokens;
    }

}
