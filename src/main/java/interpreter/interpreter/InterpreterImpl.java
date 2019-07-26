package interpreter.interpreter;

import interpreter.interpreter.visitor.ASTVisitor;
import interpreter.lexer.Lexer;
import interpreter.lexer.state.LexerAutomaton;
import interpreter.node.*;
import interpreter.node.value.DataType;
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
        verifyDeclaration(node.getIdentifier());
        memory.saveOrUpdate(node.getIdentifier(), Value.emptyValue(node.getDataType()));
    }

    @Override
    public void visitAssignation(AssignationNode node) {
        verifyAssignation(node.getIdentifier());
        verifyDeclarationAndAssignationTypes(
                node.getExpression().value().getDataType(),
                memory.findById(node.getIdentifier()).get().getDataType(), node.getIdentifier());
        memory.findById(node.getIdentifier()).ifPresent(v -> v.setValue(node.getExpression().value()));
    }

    @Override
    public void visitPrint(PrintNode node) {
        terminal.print(node.getArgument().value().toString());
    }

    @Override
    public void visitIdentifier(IdentifierNode node) {
        verifyDeclaration(node.getIdentifier());
        memory.findById(node.getIdentifier()).ifPresent(node::setValue);
    }

    private void verifyDeclaration(String identifier) {
        if (memory.findById(identifier).isPresent()) {
            throw new InterpreterException("identifier \'" + identifier + "\' is already declared");
        }
    }

    private void verifyAssignation(String identifier) {
        if (!memory.findById(identifier).isPresent()) {
            throw new InterpreterException("identifier \'" + identifier + "\' is not declared");
        }
    }

    private void verifyDeclarationAndAssignationTypes(DataType declaredDataType, DataType assignedDataType, String identifier) {
        if (!declaredDataType.equals(assignedDataType)) {
            throw new InterpreterException("can not assign a \'" + assignedDataType +
                    "\' to the identifier \'" + identifier + "\' of type \'" + declaredDataType + "\'.");
        }
    }
}
