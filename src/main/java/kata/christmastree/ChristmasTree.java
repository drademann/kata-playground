package kata.christmastree;

import static java.lang.Integer.max;

public class ChristmasTree {

    public static final String STOMP = "|\n";
    private int layers;
    private Character topping;

    public ChristmasTree withLayers(int layers) {
        this.layers = layers;
        return this;
    }

    public ChristmasTree withTopping(char topping) {
        this.topping = topping;
        return this;
    }

    public String grow() {
        if (topping != null) {
            return indentation(0) + topping + "\n" + grow(0);
        }
        return grow(0);
    }

    private String grow(int currentLayer) {
        if (currentLayer == layers) return indentation(0) + STOMP;
        return indentation(currentLayer)
                + branch(currentLayer) + "\n"
                + grow(currentLayer + 1);
    }

    private String indentation(int currentLayer) {
        return " ".repeat(max(layers - currentLayer - 1, 0));
    }

    private String branch(int currentLayer) {
        return "#".repeat(currentLayer * 2 + 1);
    }

}
