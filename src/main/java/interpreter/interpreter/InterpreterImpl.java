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
        program.accept(this);
    }

    @Override
    public void visitProgram(ASTProgram program) {
        program.getStatements().forEach(node -> node.accept(this));
    }

    @Override
    public void visitDeclaration(DeclarationNode node) {
        if (memory.findById(node.getIdentifier()).isPresent())
            throw new InterpreterException("identifier was already decalred. Can not declare it again at line " +
                    node.getLine() + ", between column " + node.getFromColumn() + " and " + node.getToColumn() + ".");

        memory.saveOrUpdate(node.getIdentifier(), Value.generateEmptyValue(node.getDataType()));
    }

    @Override
    public void visitAssignation(AssignationNode node) {
        //verify existence
        if (!memory.findById(node.getIdentifier()).isPresent())
            throw new InterpreterException("identifier was never decalred. Can not assign it at line " +
                    node.getLine() + ", between column " + node.getFromColumn() + " and " + node.getToColumn() + ".");

        //verify data types
        if (!memory.findById(node.getIdentifier()).get().getDataType().equals(node.getExpression().value().getDataType()))
            throw new InterpreterException("identifier has a different data type to the result expression at line " +
                    node.getLine() + ", between column " + node.getFromColumn() + " and " + node.getToColumn() + ".");

        memory.findById(node.getIdentifier()).get().setValue(node.getExpression().value());
    }

    @Override
    public void visitPrint(PrintNode node) {
        terminal.print(node.getArgument().value().toString());
    }

    @Override
    public void visitDeclarationAndAssignation(DeclarationAndAssignationNode node) {
        if (memory.findById(node.getIdentifier()).isPresent())
            throw new InterpreterException("identifier was already decalred. Can not declare it again at line " +
                    node.getLine() + ", between column " + node.getFromColumn() + " and " + node.getToColumn() + ".");

        memory.saveOrUpdate(node.getIdentifier(), node.getExpression().value());
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
