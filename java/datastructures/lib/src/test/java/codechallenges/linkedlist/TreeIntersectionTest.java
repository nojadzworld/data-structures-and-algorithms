package codechallenges.linkedlist;

import datastructures.trees.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeIntersectionTest {
    BinaryTree<Integer> tree1;
    BinaryTree<Integer> tree2;
    BinaryTree<Integer> emptyTree;
    TreeIntersection<Integer> sut;
    @BeforeEach
    void setUp() {

        sut = new TreeIntersection<Integer>();

        tree1 = new BinaryTree<Integer>(1);
        tree1.add(2);
        tree1.add(3);

        tree2 = new BinaryTree<>(2);
        tree2.add(3);
        tree2.add(4);

        emptyTree = new BinaryTree<>(null);
    }

    @Test
    void testTreeIntersectionWithNonEmptyTrees() {
        List<Integer> result = sut.treeIntersection(tree1.getRoot(), tree2.getRoot());
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 3));
        assertEquals(expected, result);
    }

    @Test
    void testTreeIntersectionWithOneEmptyTree() {
        List<Integer> result = sut.treeIntersection(tree1.getRoot(), emptyTree.getRoot());
        ArrayList<Integer> expected = new ArrayList<>();
        assertEquals(expected, result);
    }

    @Test
    void testTreeIntersectionWithBothEmptyTrees() {
        List<Integer> result = sut.treeIntersection(emptyTree.getRoot(), emptyTree.getRoot());
        ArrayList<Integer> expected = new ArrayList<>();
        assertEquals(expected, result);
    }
}
