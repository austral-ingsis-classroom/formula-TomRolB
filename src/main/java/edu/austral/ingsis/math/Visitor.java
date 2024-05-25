package edu.austral.ingsis.math;

public interface Visitor {
  void visit(Constant constant);

  void visit(Variable variable);

  void visit(Sum sum);

  void visit(Difference diff);

  void visit(Product prod);

  void visit(Division div);

  void visit(Module mod);

  void visit(Power pow);

  void visit(Function function);
}
