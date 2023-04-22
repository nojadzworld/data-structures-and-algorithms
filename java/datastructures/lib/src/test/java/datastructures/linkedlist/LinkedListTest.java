//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package datastructures.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
  public LinkedListTest() {
  }

  @Test
  void testInstantiateEmptyList() {
    LinkedList list = new LinkedList();
    Assertions.assertNull(list.head);
  }

  @Test
  public void testInsert() {
    LinkedList list = new LinkedList();
    list.insert(1);
    Assertions.assertEquals(1, list.head.value);
  }

  @Test
  public void testInsertMultiple() {
    LinkedList list = new LinkedList();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    Assertions.assertEquals(3, list.head.value);
  }

  @Test
  public void testIncludesFalse() {
    LinkedList list = new LinkedList();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    Assertions.assertFalse(list.includes(4));
  }
  @Test
  public void testToString() {
    LinkedList list = new LinkedList();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    String expected = "{ 3 } -> { 2 } -> { 1 } -> NULL";
    String actual = list.toString();
    System.out.println("Expected: " + expected);
    System.out.println("Actual: " + actual);
    Assertions.assertEquals(expected, actual);
  }
}
