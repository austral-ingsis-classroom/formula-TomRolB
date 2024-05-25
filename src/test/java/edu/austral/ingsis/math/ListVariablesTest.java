package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final Function function = new FunctionImpl(new Addition(new Constant(1), new Constant(6)));

    final List<String> result = function.getAllVariables();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final Function function = new FunctionImpl(new Division(new Constant(12), new Variable("div")));
    final List<String> result = function.getAllVariables();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final Function function =
        new FunctionImpl(
            new Multiplication(
                new Division(new Constant(9), new Variable("x")), new Variable("y")));
    final List<String> result = function.getAllVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final Function function =
        new FunctionImpl(
            new Exponentiation(
                new Division(new Constant(27), new Variable("a")), new Variable("b")));
    final List<String> result = function.getAllVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final Function function =
        new FunctionImpl(new Exponentiation(new Variable("z"), new Constant(0.5)));
    final List<String> result = function.getAllVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final Function function =
        new FunctionImpl(new Substraction(new Module(new Variable("value")), new Constant(8)));
    final List<String> result = function.getAllVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final Function function =
        new FunctionImpl(new Substraction(new Module(new Variable("value")), new Constant(8)));
    final List<String> result = function.getAllVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final Function function =
        new FunctionImpl(
            new Multiplication(
                new Substraction(new Constant(5), new Variable("i")), new Constant(8)));
    final List<String> result = function.getAllVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}
