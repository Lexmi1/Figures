import java.util.Objects;

public class Figure {

    private String shape;
    private String color;
    private int weight;
    private boolean glow;

    public Figure(String shape, String color, int weight, boolean light) {
        this.shape = shape;
        this.color = color;
        this.weight = weight;
        this.glow = light;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isGlow() {
        return glow;
    }

    public void setGlow(boolean light) {
        this.glow = light;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return weight == figure.weight && glow == figure.glow && Objects.equals(shape, figure.shape) && Objects.equals(color, figure.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shape, color, weight, glow);
    }

    @Override
    public String toString() {
        return "Figure{" +
                "shape='" + shape + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", glow=" + glow +
                '}';
    }
}
