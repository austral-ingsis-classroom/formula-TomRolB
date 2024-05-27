package edu.austral.ingsis.math;

import java.util.Map;

public class Sqrt implements UnaryOperation {
  private final Symbol subSymbol;

  public Sqrt(Symbol subSymbol) {
    this.subSymbol = subSymbol;
  }

  @Override
  public Symbol getSubSymbol() {
    return subSymbol;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public Double computeWithValues(Map<String, Double> values) {
    return Math.sqrt(subSymbol.computeWithValues(values));
  }
}
