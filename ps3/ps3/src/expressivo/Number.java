package expressivo;

import java.util.Objects;

/**
 * Represents a numeric value in the expression.
 */
public class Number implements Expression {
    private final double value;

    // Abstraction Function:
    //   represents a numeric constant in the expression
    // Rep Invariant:
    //   value is a finite number
    // Safety from rep exposure:
    //   value is immutable and final

    public Number(double value) {
        this.value = value;
        checkRep();
    }

    private void checkRep() {
        assert Double.isFinite(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object thatObject) {
        if (!(thatObject instanceof Number)) return false;
        Number that = (Number) thatObject;
        return Double.compare(this.value, that.value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
