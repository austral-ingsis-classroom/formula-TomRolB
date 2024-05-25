package edu.austral.ingsis.math;

import java.util.List;
import java.util.Map;

public interface Function extends Symbol {
  List<String> getAllVariables();

  Double compute();

  //TODO: isn't this actually sth specific of the implementation?
  Visitable getRootSymbol();
}
