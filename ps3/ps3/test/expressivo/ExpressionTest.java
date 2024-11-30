package expressivo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the Expression abstract data type and its concrete variants.
 */
public class ExpressionTest {

    // Testing strategy for Number:
    // - Test creation with integer and floating-point values
    // - Test toString() for proper string representation
    // - Test equals() for structural equality of numbers
    // - Test hashCode() for consistency with equals()

    // Testing strategy for Variable:
    // - Test creation with valid variable names
    // - Test toString() for proper string representation
    // - Test equals() for structural equality of variables
    // - Test hashCode() for consistency with equals()

    // Testing strategy for Sum:
    // - Test creation with two expressions
    // - Test toString() for proper formatting with parentheses
    // - Test equals() for structural equality of sums
    // - Test hashCode() for consistency with equals()

    // Testing strategy for Product:
    // - Test creation with two expressions
    // - Test toString() for proper formatting with parentheses
    // - Test equals() for structural equality of products
    // - Test hashCode() for consistency with equals()

    @Test
    public void testNumber() {
        Expression num1 = new Number(5);
        Expression num2 = new Number(5.0);
        Expression num3 = new Number(3.14);

        assertEquals("5.0", num1.toString());
        assertEquals("3.14", num3.toString());

        assertTrue(num1.equals(num2)); // Structural equality
        assertFalse(num1.equals(num3));

        assertEquals(num1.hashCode(), num2.hashCode());
        assertNotEquals(num1.hashCode(), num3.hashCode());
    }

    @Test
    public void testVariable() {
        Expression var1 = new Variable("x");
        Expression var2 = new Variable("x");
        Expression var3 = new Variable("y");

        assertEquals("x", var1.toString());
        assertEquals("y", var3.toString());

        assertTrue(var1.equals(var2)); // Structural equality
        assertFalse(var1.equals(var3));

        assertEquals(var1.hashCode(), var2.hashCode());
        assertNotEquals(var1.hashCode(), var3.hashCode());
    }

    @Test
    public void testSum() {
        Expression num1 = new Number(3);
        Expression num2 = new Number(4);
        Expression var1 = new Variable("x");

        Expression sum1 = new Sum(num1, var1);
        Expression sum2 = new Sum(new Number(3), new Variable("x"));
        Expression sum3 = new Sum(num1, num2);

        assertEquals("(3.0 + x)", sum1.toString());
        assertEquals("(3.0 + 4.0)", sum3.toString());

        assertTrue(sum1.equals(sum2)); // Structural equality
        assertFalse(sum1.equals(sum3));

        assertEquals(sum1.hashCode(), sum2.hashCode());
        assertNotEquals(sum1.hashCode(), sum3.hashCode());
    }

    @Test
    public void testProduct() {
        Expression num1 = new Number(2);
        Expression num2 = new Number(3);
        Expression var1 = new Variable("y");

        Expression product1 = new Product(num1, var1);
        Expression product2 = new Product(new Number(2), new Variable("y"));
        Expression product3 = new Product(num1, num2);

        assertEquals("(2.0 * y)", product1.toString());
        assertEquals("(2.0 * 3.0)", product3.toString());

        assertTrue(product1.equals(product2)); // Structural equality
        assertFalse(product1.equals(product3));

        assertEquals(product1.hashCode(), product2.hashCode());
        assertNotEquals(product1.hashCode(), product3.hashCode());
    }

    @Test
    public void testComplexExpressions() {
        Expression num1 = new Number(3);
        Expression num2 = new Number(4);
        Expression var1 = new Variable("x");
        Expression var2 = new Variable("y");

        Expression sum = new Sum(var1, new Product(num1, num2)); // x + (3 * 4)
        Expression product = new Product(new Sum(var1, var2), num2); // (x + y) * 4

        assertEquals("(x + (3.0 * 4.0))", sum.toString());
        assertEquals("((x + y) * 4.0)", product.toString());

        Expression sumCopy = new Sum(new Variable("x"), new Product(new Number(3), new Number(4)));
        assertTrue(sum.equals(sumCopy));
        assertEquals(sum.hashCode(), sumCopy.hashCode());
    }

    @Test(expected = AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // Ensure assertions are enabled with VM argument: -ea
    }
}
