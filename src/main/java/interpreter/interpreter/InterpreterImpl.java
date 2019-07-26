package interpreter.interpreter;

import interpreter.interpreter.visitor.ASTVisitor;
import interpreter.lexer.Lexer;
import interpreter.lexer.state.LexerAutomaton;
import interpreter.node.*;
import interpreter.node.operation.BinaryOperationNode;
import interpreter.node.value.NumberValue;
import interpreter.node.value.StringValue;
import interpreter.node.value.Value;
import interpreter.parser.Parser;
import interpreter.parser.ParserImpl;

public class InterpreterImpl implements Interpreter, ASTVisitor {

    private final Memory<String, Value> memory;
    private final Terminal terminal;

    public InterpreterImpl() {
        this.memory = new MemoryImpl();
        this.terminal = new TerminalSystem();
    }

    public InterpreterImpl(Memory<String, Value> memory, Terminal terminal) {
        this.memory = memory;
        this.terminal = terminal;
    }

    public InterpreterImpl(Memory<String, Value> memory) {
        this.memory = memory;
        this.terminal = new TerminalSystem();
    }

    public InterpreterImpl(Terminal terminal) {
        this.memory = new MemoryImpl();
        this.terminal = terminal;
    }

    @Override
    public void interpret(String input) {
        Lexer lexer = new LexerAutomaton();
        Parser parser = new ParserImpl();
        interpret(parser.parse(lexer.lex(input)));
    }

    @Override
    public void interpret(AST program) {

    }

    @Override
    public void visitProgram(ASTProgram program) {

    }

    @Override
    public void visitDeclaration(DeclarationNode node) {

    }

    @Override
    public void visitAssignation(AssignationNode node) {

    }

    @Override
    public void visitPrint(PrintNode node) {

    }

    @Override
    public void visitDeclarationAndAssignation(DeclarationAndAssignationNode node) {

    }

    @Override
    public void visitExpression(ExpressionNode node) {

    }

    @Override
    public void visitBinaryOperation(BinaryOperationNode node) {

    }

    @Override
    public void visitIdentifier(IdentifierNode node) {

    }

    @Override
    public void visitNumber(NumberValue node) {

    }

    @Override
    public void visitString(StringValue node) {

    }
}
