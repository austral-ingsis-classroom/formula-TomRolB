package edu.austral.ingsis.math;

public interface Visitor {
  void visit(Constant constant);

  void visit(Variable variable);

  void visit(Addition addition);

  void visit(Substraction diff);

  void visit(Multiplication prod);

  void visit(Division div);

  void visit(Module mod);

  void visit(Exponentiation pow);

  void visit(Function function);
}
