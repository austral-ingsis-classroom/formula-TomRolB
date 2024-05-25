package edu.austral.ingsis.math;

import java.util.Map;
import java.util.Optional;

public class Variable implements Symbol {
  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public Double computeWithValues(Map<String, Double> values) {
    return Optional.ofNullable(values.get(name))
        .orElseThrow(
            () -> new IllegalArgumentException("No value was passed for variable " + name));
  }
}
