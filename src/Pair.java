import java.util.Objects;

public class Pair<T, T1> {

    private T shape;
    private T1 color;

    public Pair(T shape, T1 color) {
        this.shape = shape;
        this.color = color;
    }

    public T getShape() {
        return shape;
    }

    public void setShape(T shape) {
        this.shape = shape;
    }

    public T1 getColor() {
        return color;
    }

    public void setColor(T1 color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(shape, pair.shape) && Objects.equals(color, pair.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shape, color);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "shape=" + shape +
                ", color=" + color +
                '}';
    }
}
