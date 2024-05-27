package edu.austral.ingsis.math;

import java.util.ArrayList;
import java.util.List;

public class VariableFinder implements Visitor {
  final List<String> result = new ArrayList<>();

  public List<String> getResult() {
    return result;
  }

  @Override
  public void visit(Constant constant) {}

  @Override
  public void visit(Variable variable) {
    result.add(variable.getName());
  }

  @Override
  public void visit(Addition addition) {
    addition.getFirst().accept(this);
    addition.getSecond().accept(this);
  }

  @Override
  public void visit(Subtraction sub) {
    sub.getFirst().accept(this);
    sub.getSecond().accept(this);
  }

  @Override
  public void visit(Multiplication mult) {
    mult.getFirst().accept(this);
    mult.getSecond().accept(this);
  }

  @Override
  public void visit(Division div) {
    div.getFirst().accept(this);
    div.getSecond().accept(this);
  }

  @Override
  public void visit(Module mod) {
    mod.getSubSymbol().accept(this);
  }

  @Override
  public void visit(Exponentiation exp) {
    exp.getFirst().accept(this);
    exp.getSecond().accept(this);
  }

  @Override
  public void visit(Function function) {
    function.getRootSymbol().accept(this);
  }

  @Override
  public void visit(Sqrt sqrt) {
    sqrt.getSubSymbol().accept(this);
  }
}
