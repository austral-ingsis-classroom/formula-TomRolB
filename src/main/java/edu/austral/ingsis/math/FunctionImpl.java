package edu.austral.ingsis.math;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FunctionImpl implements Function {
  private final Symbol root;

  public FunctionImpl(Symbol root) {
    this.root = root;
  }

  @Override
  public List<String> getAllVariables() {
    final VariableFinder varFinder = new VariableFinder();
    this.accept(varFinder);
    return varFinder.getResult();
  }

  @Override
  public Double compute() {
    return computeWithValues(Collections.emptyMap());
  }

  @Override
  public Double computeWithValues(Map<String, Double> values) {
    return root.computeWithValues(values);
  }

  @Override
  public Symbol getRootSymbol() {
    return root;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
