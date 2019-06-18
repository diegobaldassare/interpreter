package lexer.state;

/**
 * Created by Diego Baldassare on 2019-06-18.
 */
public interface Context {

    void setState(State state);
    void next(Character c); //request

    int getFromColumn();
    int getToColumn();
    int getLine();

    String getLexeme();
    State getState();
}
