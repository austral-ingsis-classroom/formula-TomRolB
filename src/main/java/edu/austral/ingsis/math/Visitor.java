package edu.austral.ingsis.math;

public interface Visitor {
  void visit(Constant constant);

  void visit(Variable variable);

  void visit(Addition addition);

  void visit(Subtraction sub);

  void visit(Multiplication mult);

  void visit(Division div);

  void visit(Module mod);

  void visit(Exponentiation exp);

  void visit(Function function);

  void visit(Sqrt sqrt);
}
