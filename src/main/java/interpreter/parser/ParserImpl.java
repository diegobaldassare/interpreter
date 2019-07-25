//package interpreter.parser;
//
//import interpreter.ast.ASTNode;
//import interpreter.token.Token;
//import interpreter.token.TokenType;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//
//import static interpreter.token.TokenType.*;
//
//
//public class ParserImpl implements Parser {
//
//    private Iterator<Token> iterator;
//    private Token current;
//
//    private HashMap<String, String> types = new HashMap<>();
//
//    public ASTNode parse(List<Token> tokens) {
//        iterator = tokens.iterator();
//        current = iterator.next();
//        return program();
//    }
//
//    /**
//     * program = statement_list
//     */
//    private ASTNode program() {
//
//        final List<ASTNode> nodes = statementList();
//
//        return new Compound(nodes);
//    }
//
//    /**
//     * statement_list = statement SEMICOLON | statement SEMICOLON statement_list
//     */
//    private List<ASTNode> statementList() {
//
//        final ASTNode node = statement();
//
//        eat(SEMICOLON);
//
//        final List<ASTNode> nodes = new ArrayList<>();
//
//        nodes.add(node);
//
//        while (current.tokenType() != SEMICOLON) {
//            nodes.add(statement());
//            eat(SEMICOLON);
//        }
//
//        return nodes;
//    }
//
//    /**
//     * statement = declaration_statement | print_statement | assignment_statement
//     */
//    private ASTNode statement() {
//
//        ASTNode node;
//
//        if (current.tokenType().equals(LET)) {
//            node = declarationStatement();
//        } else if (current.tokenType().equals(PRINT)) {
//            node = printStatement();
//        } else {
//            node = assignmentStatement();
//        }
//        return node;
//    }
//
//    /**
//     * declaration_statement = LET variable COLON type
//     */
//    private Declaration declarationStatement() {
//
//        eat(LET);
//
//        final Variable variable = variable();
//
//        eat(COLON);
//
//        final Type type = type();
//
//        types.put(variable.getValue(), type.getValue());
//
//        return new Declaration(variable, type);
//    }
//
//    /**
//     * print_statement = PRINT LPAREN expression RPAREN
//     */
//    private ASTNode printStatement() {
//
//        eat(PRINT);
//
//        eat(LEFT_PARENTHESIS);
//
//        final ASTNode expression = expression();
//
//        eat(RIGHT_PARENTHESIS);
//
//        return new Print(expression);
//    }
//
//    /**
//     * assignment_statement = variable ASSIGN expression
//     */
//    private Assignation assignmentStatement() {
//
//        final Variable variable = variable();
//
//        final Token current = this.current;
//
//        eat(EQUALS);
//
//        final ASTNode expression = expression();
//
//        return new Assignation(current.value(), variable, expression);
//    }
//
//    /**
//     * expression = number_expression | string_expression
//     */
//    private ASTNode expression() {
//
//        if (current.tokenType().equals(NUMBER_LITERAL)) {
//            return numberExpression();
//        } else if (current.tokenType().equals(STRING_LITERAL)) {
//            return stringExpression();
//        } else {
//            final String type = types.get(current.value());
//            if (type.equals("number")) return numberExpression();
//            else return stringExpression();
//        }
//    }
//
//    /**
//     * string_expression = string_term (PLUS string_expression)*
//     */
//    private ASTNode stringExpression() {
//
//        ASTNode node = stringTerm();
//
//        while (current.tokenType().equals(PLUS_SYMBOL)) {
//            final Token current = this.current;
//            eat(PLUS_SYMBOL);
//            node = new BinaryOperation(current.tokenType().name(), node, stringExpression());
//        }
//
//        return node;
//    }
//
//    /**
//     * string_term = STRING_LITERAL | string_expression | variable
//     */
//    private ASTNode stringTerm() {
//
//        if (current.tokenType().equals(STRING_LITERAL)) {
//            final Token current = this.current;
//            eat(STRING_LITERAL);
//            return new StringLiteral(current.value());
//        } else if (current.tokenType().equals(IDENTIFIER)) {
//            return variable();
//        } else {
//            return expression();
//        }
//    }
//
//    /**
//     * number_expression = term ((PLUS | MINUS) term)*
//     * term = factor ((MUL | DIV) factor)*
//     * factor = NUMBER_LITERAL | LPAREN number_expression RPAREN
//     */
//    private ASTNode numberExpression() {
//
//        ASTNode node = term();
//
//        while (current.tokenType().equals(TokenType.PLUS_SYMBOL) || current.tokenType().equals(SLASH)) {
//            final Token current = this.current;
//            if (current.tokenType().equals(PLUS_SYMBOL)) {
//                eat(PLUS_SYMBOL);
//            } else {
//                eat(SLASH);
//            }
//            node = new BinaryOperation(current.tokenType().name(), node, term());
//        }
//        return node;
//    }
//
//    /**
//     * term = factor ((MUL | DIV) factor)*
//     */
//    private ASTNode term() {
//
//        ASTNode node = factor();
//
//        while (current.tokenType().equals(ASTERISK) || current.tokenType().equals(FORWARD_SLASH)) {
//            Token current = this.current;
//            if (current.tokenType().equals(ASTERISK)) {
//                eat(ASTERISK);
//            } else {
//                eat(FORWARD_SLASH);
//            }
//            node = new BinaryOperation(current.tokenType().name(), node, factor());
//        }
//
//        return node;
//    }
//
//    /**
//     * factor = NUMBER_LITERAL | LPAREN number_expression RPAREN | variable
//     */
//    private ASTNode factor() {
//
//        final Token token = current;
//
//        if (token.tokenType().equals(NUMBER_LITERAL)) {
//            eat(NUMBER_LITERAL);
//            return new NumberLiteral(token.value());
//        } else if (token.tokenType().equals(LEFT_PARENTHESIS)) {
//            eat(LEFT_PARENTHESIS);
//            ASTNode node = numberExpression();
//            eat(RIGHT_PARENTHESIS);
//            return node;
//        } else {
//            return variable();
//        }
//    }
//
//    /**
//     * type = NUMBER_TYPE | STRING_TYPE
//     */
//    private Type type() {
//
//        final Type type;
//
//        if (current.tokenType().equals(NUMBER_TYPE)) {
//            eat(NUMBER_TYPE);
//            type = new Type("number");
//        } else {
//            eat(STRING_TYPE);
//            type = new Type("string");
//        }
//
//        return type;
//    }
//
//    /**
//     *  variable = IDENTIFIER
//     */
//    private Variable variable() {
//
//        final Variable variable = new Variable(current.value());
//
//        eat(IDENTIFIER);
//
//        return variable;
//    }
//
//    private void eat(TokenType kind) {
//
//        if (current.tokenType().equals(kind)) {
//            current = iterator.next();
//        }
//        else {
//            throw new RuntimeException("Invalid syntax, expected: " + kind.name() + "\ncurrent: " + current.value());
//        }
//    }
//}
