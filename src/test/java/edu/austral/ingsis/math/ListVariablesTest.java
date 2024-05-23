package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.List;
import org.junit.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final Function function = new FunctionImpl(new Sum(
            new Constant(1),
            new Constant(6)
    ));

    final List<String> result = getResult(function);

    assertThat(result, empty());
  }

  private List<String> getResult(Function function) {
    VariableFinder varFinder = new VariableFinder();
    function.accept(varFinder);
    return varFinder.getResult();
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final Function function = new FunctionImpl(
            new Division(
                    new Constant(12),
                    new Variable("div")
            )
    );
    final List<String> result = getResult(function);

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final Function function = new FunctionImpl(
            new Product(
                    new Division(
                            new Constant(9),
                            new Variable("x")
                    ),
                    new Variable("y")
            )
    );
    final List<String> result = getResult(function);

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final Function function = new FunctionImpl(
            new Power(
                    new Division(
                            new Constant(27),
                            new Variable("a")
                    ),
                    new Variable("b")
            )
    );
    final List<String> result = getResult(function);

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final Function function = new FunctionImpl(
            new Sqrt(new Variable("z"))
    );
    final List<String> result = getResult(function);

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final Function function = new FunctionImpl(
            new Difference(
                    new Module(new Variable("value")),
                    new Constant(8)
            )
    );
    final List<String> result = getResult(function);

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final Function function = new FunctionImpl(
            new Difference(
                    new Module(new Variable("value")),
                    new Constant(8)
            )
    );
    final List<String> result = getResult(function);

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final Function function = new FunctionImpl(
            new Product(
                    new Difference(
                            new Constant(5),
                            new Variable("i")
                    ),
                    new Constant(8)
            )
    );
    final List<String> result = getResult(function);

    assertThat(result, containsInAnyOrder("i"));
  }
}
