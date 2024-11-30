package expressivo;

import java.util.Objects;

/**
 * Represents the sum of two expressions.
 */
public class Sum implements Expression {
    private final Expression left;
    private final Expression right;

    // Abstraction Function:
    //   represents the sum of two sub-expressions
    // Rep Invariant:
    //   left and right are non-null
    // Safety from rep exposure:
    //   left and right are immutable and final

    public Sum(Expression left, Expression right) {
        this.left = left;
        this.right = right;
        checkRep();
    }

    private void checkRep() {
        assert left != null && right != null;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }

    @Override
    public boolean equals(Object thatObject) {
        if (!(thatObject instanceof Sum)) return false;
        Sum that = (Sum) thatObject;
        return this.left.equals(that.left) && this.right.equals(that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
