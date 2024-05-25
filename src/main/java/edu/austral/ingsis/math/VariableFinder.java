package edu.austral.ingsis.math;

import java.util.ArrayList;
import java.util.List;

public class VariableFinder implements Visitor {
  List<String> result = new ArrayList<>();

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
  public void visit(Substraction diff) {
    diff.getFirst().accept(this);
    diff.getSecond().accept(this);
  }

  @Override
  public void visit(Multiplication prod) {
    prod.getFirst().accept(this);
    prod.getSecond().accept(this);
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
  public void visit(Exponentiation pow) {
    pow.getFirst().accept(this);
    pow.getSecond().accept(this);
  }

  @Override
  public void visit(Function function) {
    function.getRootSymbol().accept(this);
  }
}
