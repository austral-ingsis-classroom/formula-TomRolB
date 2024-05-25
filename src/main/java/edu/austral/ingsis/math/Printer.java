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
    double value = constant.getValue();

    if (convertibleToInt(value)) printResult.append((int) value);
    else printResult.append(value);
  }

  private static boolean convertibleToInt(double value) {
    return value % 1 == 0;
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
  public void visit(Subtraction sub) {
    printResult.append("(");
    sub.getFirst().accept(this);
    printResult.append(" - ");
    sub.getSecond().accept(this);
    printResult.append(")");
  }

  @Override
  public void visit(Multiplication mult) {
    printResult.append("(");
    mult.getFirst().accept(this);
    printResult.append(" * ");
    mult.getSecond().accept(this);
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
  public void visit(Exponentiation exp) {
    exp.getFirst().accept(this);
    printResult.append(" ^ ");
    exp.getSecond().accept(this);
  }

  @Override
  public void visit(Function function) {
    function.getRootSymbol().accept(this);
  }
}
