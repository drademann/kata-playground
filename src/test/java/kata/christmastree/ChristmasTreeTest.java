package kata.christmastree;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChristmasTreeTest {

    private String growTreeOfHeight(int height) {
        return ChristmasTree.ofHeight(height);
    }

    @Test
    public void givenZeroHeight_shouldDrawTreeStomp() {
        assertThat(growTreeOfHeight(0)).isEqualTo("""
        |
        """);
    }

    @Test
    public void givenHeightOfOne_shouldDrawMinimalTree() {
        assertThat(growTreeOfHeight(1)).isEqualTo("""
        X
        |
        """);
    }

    @Test
    public void givenHeightOfTwo_shouldDrawLittleTree() {
        assertThat(growTreeOfHeight(2)).isEqualTo("""
         X
        XXX
         |
        """);
    }

    @Test
    public void givenHeightOf5_shouldDrawLittleTree() {
        assertThat(growTreeOfHeight(5)).isEqualTo("""
            X
           XXX
          XXXXX
         XXXXXXX
        XXXXXXXXX
            |
        """);
    }

}
