import java.util.Objects;

public class Token {
    private int index1, index2;
    private int value;

    public Token(int index1, int index2, int value) {
        this.index1 = index1;
        this.index2 = index2;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return index1 == token.index1 && index2 == token.index2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index1, index2);
    }

    @Override
    public String toString() {
        return "Token{" +
                "(" + index1 +
                ", " + index2 +
                "), value=" + value +
                '}';
    }

    public int getIndex1() {
        return index1;
    }

    public void setIndex1(int index1) {
        this.index1 = index1;
    }

    public int getIndex2() {
        return index2;
    }

    public void setIndex2(int index2) {
        this.index2 = index2;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
