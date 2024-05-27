package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Function function = new FunctionImpl(new Addition(new Constant(1), new Constant(6)));

    final Double result = function.compute();

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Function function = new FunctionImpl(new Division(new Constant(12), new Constant(2)));

    final Double result = function.compute();

    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Function function =
        new FunctionImpl(
            new Multiplication(new Division(new Constant(9), new Constant(2)), new Constant(3)));

    final Double result = function.compute();

    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Function function =
        new FunctionImpl(
            new Exponentiation(new Division(new Constant(27), new Constant(6)), new Constant(2)));

    final Double result = function.compute();

    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Function function = new FunctionImpl(new Sqrt(new Constant(36)));

    final Double result = function.compute();

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Function function = new FunctionImpl(new Module(new Constant(136)));

    final Double result = function.compute();

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Function function = new FunctionImpl(new Module(new Constant(-136)));

    final Double result = function.compute();

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Function function =
        new FunctionImpl(
            new Multiplication(new Subtraction(new Constant(5), new Constant(5)), new Constant(8)));

    final Double result = function.compute();

    assertThat(result, equalTo(0d));
  }
}
