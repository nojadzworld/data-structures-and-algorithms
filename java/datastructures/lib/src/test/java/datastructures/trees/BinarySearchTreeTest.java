package datastructures.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
  BinarySearchTree<Integer> sut;

  @BeforeEach
  void setUp() {
    sut = new BinarySearchTree<>(10);
  }

  @Test
  void testAddLeftAndRightChild() {
    sut.add(5); // left child
    sut.add(15); // right child

    assertEquals(5, sut.getRoot().left.value);
    assertEquals(15, sut.getRoot().right.value);
  }

  @Test
  void testContains() {
    sut.add(5);
    sut.add(15);
    sut.add(3);
    sut.add(8);
    sut.add(12);
    sut.add(18);

    assertTrue(sut.contains(8));
    assertFalse(sut.contains(20));
  }
}
