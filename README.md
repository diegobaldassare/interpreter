# Interpreter
System that serves as lexer, parser and interpreter of a subset of [TypeScript](https://www.typescriptlang.org). 
It reads code written in that language, creates an Abstract Syntax Tree (AST) and is able to execute the result. 
For this, it includes the syntactic and semantic validation, as well as indicates the position (row and column) of the errors.

## Purpose
This project represents the practical work number 4 for the course of System Engineering 2019, at Austral University.

## Definitions
A lexer is a software program that performs lexical analysis. Lexical analysis is the process of separating a stream of 
characters into different words, which are called 'tokens' .

Parsing means to make something understandable. This is done by partially analysing the data, 
understanding its underlying structure (by making some assumptions based on what you're expecting to see), and converting 
the information represented in one form into another one.

An interpreter is a program that can analyse and execute a program line by line. It directly executes instructions written 
in a programming language, without requiring previously to have been compiled into a machine language program.

## Modularization
The system is composed of three components: Lexer, Parser and Interpreter. The lexer is responsible for generating tokens
based on the code, that is, it reads the characters that make up the code and groups them in tokens. The parser creates a 
specific AST for this language based on the tokens generated by the lexer, this tree represents all the information that 
exists in the code, to then allow its execution. The interpreter reads the AST and executes, with it, each one of the 
statements of the code. Each of the components or modules of the system has a defined interface that allows it to be used 
by other components. When one component is used by another, it only access through the defined interface.

## Language
The language that is interpreted is a subset of TypeScript that is limited to:
* Declaration of variables
  * Only variables with the keyword "let"
  * Without type differences, it is necessary to clarify the variable type ("let x: number; ")
  * Only one variable can be declared per sentence
* Assignment of variables already declared ("x = 5")
* Declare and assign a value in the same sentence ("let x: number = 1; ")
* Print values with a function "print()" that receives an expression of type "string" or "number" as an argument. It prints 
its value to the console together with a line break.
* Support only two basic types: "string" and "number"
* Strings can be assigned with single ('test') or double quotes ("test")
* Concatenation of variables and literals of type "string"
  * With the "+" symbol
  * The result of the concatenation of "string" and "number", if the expression includes both types, is "string"
* Variables and literals of type "number" must support arithmetic operations:
  * Sum
  * Subtraction
  * Multiplication
  * Division
* Type "number" includes only positive integers
* All statements must be ended with ";"

# Testing
Each module is tested in order to proof its functionality. Run the LexerTest, ParserTest and InterpreterTest methods or run the following command:
```
gradle build
```
To diplay the test result in console run:
```
gradle clean test
```
Gradle Wrapper is also available for building and testing the project:
```
./gradlew build
```

# Sources
* https://www.antlr.org/
* [The Definitive ANTLR 4 Reference](http://lms.ui.ac.ir/public/group/90/59/01/15738_ce57.pdf)
* [Build an Interpreter](https://ruslanspivak.com/lsbasi-part1/)
* [Modern Compiler Implementation in C](https://doc.lagout.org/programmation/C/Modern%20Compiler%20Implementation%20in%20C%20%5BAppel%201997-12-13%5D.pdf)
* [Modern Compiler Design](http://160592857366.free.fr/joe/ebooks/ShareData/Modern%20Compiler%20Design%202e.pdf)
