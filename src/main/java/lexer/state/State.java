package lexer.state;

/**
 * Created by Diego Baldassare on 2019-06-18.
 */
public interface State {

    State next();
    void handle(Context context);
}
