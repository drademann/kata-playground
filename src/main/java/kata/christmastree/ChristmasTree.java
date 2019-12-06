package kata.christmastree;

import java.util.Arrays;

public class ChristmasTree {

    public static final String STOMP = "|\n";

    private int layers;
    private String topping;

    public ChristmasTree withLayers(int layers) {
        this.layers = layers;
        return this;
    }

    public ChristmasTree withTopping(char topping) {
        this.topping = String.valueOf(topping);
        return this;
    }

    public String grow() {
        var tree = new StringBuilder();
        if (hasTopping()) {
            placeTopping(tree);
        }
        for (int layer = 0; layer < layers; layer++) {
            growLayer(tree, layer);
        }
        return treeWithStomp(tree);
    }

    private boolean hasTopping() {
        return topping != null;
    }

    private void growLayer(StringBuilder tree, int layer) {
        tree
                .append(spaceAt(layer))
                .append(branchAt(layer))
                .append('\n');
    }

    private String treeWithStomp(StringBuilder tree) {
        return tree
                .append(spaceAt(0))
                .append(STOMP)
                .toString();
    }

    private void placeTopping(StringBuilder tree) {
        tree.append(spaceAt(0))
                .append(topping)
                .append('\n');
    }

    private String branchAt(int layer) {
        return nchars('#', numberOfLeavesAt(layer));
    }

    private String spaceAt(int layer) {
        return nchars(' ', numberOfSpacesAt(layer));
    }

    private int numberOfSpacesAt(int layer) {
        return layers - layer - 1;
    }

    private int numberOfLeavesAt(int layer) {
        return layer * 2 + 1;
    }

    private String nchars(char ch, int n) {
        if (n <= 0) return "";
        var chars = new char[n];
        Arrays.fill(chars, ch);
        return new String(chars);
    }

}
