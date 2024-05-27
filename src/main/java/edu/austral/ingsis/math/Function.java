package edu.austral.ingsis.math;

import java.util.List;

public interface Function extends Symbol {
  List<String> getAllVariables();

  Double compute();

  Symbol getRootSymbol();
}
