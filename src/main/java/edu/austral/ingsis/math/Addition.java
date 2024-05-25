package edu.austral.ingsis.math;

import java.util.Map;

public class Addition implements BinaryOperation {
  private final Symbol first;
  private final Symbol second;

  public Addition(Symbol first, Symbol second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public Symbol getFirst() {
    return first;
  }

  @Override
  public Symbol getSecond() {
    return second;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public Double computeWithValues(Map<String, Double> values) {
    return first.computeWithValues(values) + second.computeWithValues(values);
  }
}
