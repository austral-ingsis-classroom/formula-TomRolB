package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Function function = new FunctionImpl(new Sum(new Constant(1), new Variable("x")));
    final Double result = function.computeWithValues(Map.of("x", 3d));

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Function function = new FunctionImpl(new Division(new Constant(12), new Variable("div")));
    final Double result = function.computeWithValues(Map.of("div", 4d));

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Function function =
        new FunctionImpl(
            new Product(new Division(new Constant(9), new Variable("x")), new Variable("y")));
    final Double result = function.computeWithValues(Map.of("x", 3d, "y", 4d));

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Function function =
        new FunctionImpl(
            new Power(new Division(new Constant(27), new Variable("a")), new Variable("b")));
    final Double result = function.computeWithValues(Map.of("a", 9d, "b", 3d));

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Function function = new FunctionImpl(
            new Power(
                    new Variable("z"),
                    new Constant(0.5)
            )
    );
    final Double result = function.computeWithValues(Map.of("z", 36d));

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Function function =
        new FunctionImpl(new Difference(new Module(new Variable("value")), new Constant(8)));
    final Double result = function.computeWithValues(Map.of("value", 8d));

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final Function function =
        new FunctionImpl(new Difference(new Module(new Variable("value")), new Constant(8)));
    final Double result = function.computeWithValues(Map.of("value", 8d));

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Function function =
        new FunctionImpl(
            new Product(new Difference(new Constant(5), new Variable("i")), new Constant(8)));
    final Double result = function.computeWithValues(Map.of("i", 2d));

    assertThat(result, equalTo(24d));
  }
}
