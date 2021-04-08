package kata.christmastree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * Requirements
 *
 * Write a method that returns an ASCII christmas tree. The tree can be of different heights.
 *
 * Given zero height should return just the tree stomp "|".
 *
 * Given a height of 1 should return the stomp with just one leaf:
 *
 *      #
 *      |
 *
 * Given a height of n should return a tree of height n (eg., 3):
 *
 *      #
 *     ###
 *    #####
 *      |
 *
 * Given a star should draw a star!
 *
 *      +
 *      #
 *     ###
 *    #####
 *      |
 *
 * Given christmas tree balls should place them randomly on the tree.
 *   - a tree of height <=1 should not have balls
 *   - no more than 33% of the leaves may be balls
 *
 *      +
 *      #
 *     o##
 *    ###o#
 *      |
 */
final class ChristmasTreeTest {

    @Test
    void givenZeroHeight_shouldJustReturnTheTreeStomp() {
        var tree = new ChristmasTree()
                .withLayers(0)
                .grow();

        assertThat(tree).isEqualTo("""
                                   |
                                   """);
    }

    @Test
    void givenHeight_1_shouldReturnTreeWithOneLeaf() {
        var tree = new ChristmasTree()
                .withLayers(1)
                .grow();

        assertThat(tree).isEqualTo("""
                                   #
                                   |
                                   """);
    }

    @Test
    void givenHeight_2_shouldReturnSmallTree() {
        var tree = new ChristmasTree()
                .withLayers(2)
                .grow();

        assertThat(tree).isEqualTo("""
                                    #
                                   ###
                                    |
                                   """);
    }

    @Test
    void givenHeight_3_shouldReturnLittleGrownTree() {
        var tree = new ChristmasTree()
                .withLayers(3)
                .grow();

        assertThat(tree).isEqualTo("""
                                     #
                                    ###
                                   #####
                                     |
                                   """);
    }

    @Test
    void givenStar_shouldDrawStar() {
        var tree = new ChristmasTree()
                .withLayers(3)
                .withTopping('+')
                .grow();

        assertThat(tree).isEqualTo("""
                                     +
                                     #
                                    ###
                                   #####
                                     |
                                   """);
    }

}
