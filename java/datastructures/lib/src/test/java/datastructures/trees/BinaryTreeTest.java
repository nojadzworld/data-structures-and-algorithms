package datastructures.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
  BinaryTree<Integer> sut;

  @BeforeEach
  void setUp() {
    sut = new BinaryTree<>(10);
    sut.root.left = new Node<>(5);
    sut.root.right = new Node<>(15);
    sut.root.left.left = new Node<>(3);
    sut.root.left.right = new Node<>(8);
    sut.root.right.left = new Node<>(12);
    sut.root.right.right = new Node<>(18);
  }

  @Test
  void testInstantiateTreeWithSingleNode() {
    assertEquals(10, sut.getRoot().value);
  }

  @Test
  void testPreOrderTraversal() {
    List<Integer> preOrder = sut.preOrderTraversal();
    assertEquals(Arrays.asList(10, 5, 3, 8, 15, 12, 18), preOrder);
  }

  @Test
  void testInOrderTraversal() {
    List<Integer> inOrder = sut.inOrderTraversal();
    assertEquals(Arrays.asList(3, 5, 8, 10, 12, 15, 18), inOrder);
  }

  @Test
  void testPostOrderTraversal() {
    List<Integer> postOrder = sut.postOrderTraversal();
    assertEquals(Arrays.asList(3, 8, 5, 12, 18, 15, 10), postOrder);
  }
}
