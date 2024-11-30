package expressivo;

import java.util.Objects;

/**
 * Represents a variable in the expression.
 */
public class Variable implements Expression {
    private final String name;

    // Abstraction Function:
    //   represents a variable by its name
    // Rep Invariant:
    //   name is nonempty and contains only letters
    // Safety from rep exposure:
    //   name is immutable and final

    public Variable(String name) {
        this.name = name;
        checkRep();
    }

    private void checkRep() {
        assert name != null && !name.isEmpty() && name.matches("[a-zA-Z]+");
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object thatObject) {
        if (!(thatObject instanceof Variable)) return false;
        Variable that = (Variable) thatObject;
        return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
