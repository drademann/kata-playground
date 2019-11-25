package kata.christmastree;

public class ChristmasTree {

    public static String ofHeight(int height) {
        var tree = new StringBuilder();
        var spaces = height - 1;
        var leaves = 1;
        while (spaces >= 0) {
            tree.append(ntimes(" ", spaces))
                    .append(ntimes("X", leaves))
                    .append("\n");
            spaces--;
            leaves += 2;
        }
        tree.append(ntimes(" ", height - 1)).append("|").append("\n");
        return tree.toString();
    }

    private static String ntimes(String ch, int times) {
        if (times <= 0) return "";
        if (times > 1)
            return ch + ntimes(ch, times - 1);
        else
            return ch;
    }

}
