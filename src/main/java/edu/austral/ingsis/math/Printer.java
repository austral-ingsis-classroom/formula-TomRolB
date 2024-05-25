package edu.austral.ingsis.math;

public class Printer implements Visitor {
  private StringBuilder printResult = new StringBuilder();

  public String getResult() {
    // Cannot use isEmpty() for compatibility reasons
    if (printResult.length() == 0) {
      throw new IllegalStateException("There is no formula to print");
    }

    String result = eraseOuterBracesIfNeeded(printResult.toString());
    printResult = new StringBuilder();

    return result;
  }

  private String eraseOuterBracesIfNeeded(String string) {
    String result = string;
    if (result.charAt(0) == '(' && result.charAt(result.length() - 1) == ')') {
      result = result.substring(1, result.length() - 1);
    }

    return result;
  }

  @Override
  public void visit(Constant constant) {
    printResult.append((int) constant.getValue());
  }

  @Override
  public void visit(Variable variable) {
    printResult.append(variable.getName());
  }

  @Override
  public void visit(Addition addition) {
    printResult.append("(");
    addition.getFirst().accept(this);
    printResult.append(" + ");
    addition.getSecond().accept(this);
    printResult.append(")");
  }

  @Override
  public void visit(Substraction diff) {
    printResult.append("(");
    diff.getFirst().accept(this);
    printResult.append(" - ");
    diff.getSecond().accept(this);
    printResult.append(")");
  }

  @Override
  public void visit(Multiplication prod) {
    printResult.append("(");
    prod.getFirst().accept(this);
    printResult.append(" * ");
    prod.getSecond().accept(this);
    printResult.append(")");
  }

  @Override
  public void visit(Division div) {
    printResult.append("(");
    div.getFirst().accept(this);
    printResult.append(" / ");
    div.getSecond().accept(this);
    printResult.append(")");
  }

  @Override
  public void visit(Module mod) {
    printResult.append("|");
    mod.getSubSymbol().accept(this);
    printResult.append("|");
  }

  @Override
  public void visit(Exponentiation pow) {
    pow.getFirst().accept(this);
    printResult.append(" ^ ");
    pow.getSecond().accept(this);
  }

  @Override
  public void visit(Function function) {
    function.getRootSymbol().accept(this);
  }
}
