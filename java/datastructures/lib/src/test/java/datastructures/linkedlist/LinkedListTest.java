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

  @Test
  public void testAppendOneNode() {
    LinkedList list = new LinkedList();
    list.append(3);
    Assertions.assertEquals(3, list.head.value);

  }
  @Test void testAppendMultipleNode()
  {
    LinkedList list = new LinkedList();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.append(4);
    Assertions.assertEquals(4, list.head.next.next.next.value);
  }

  @Test void testLinkedListInsertBeforeInMiddle()
  {
    LinkedList list = new LinkedList();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insertBefore(1, 4);
    Assertions.assertEquals(list.head.next.next.value, 4);
  }

  @Test void testLinkedListInsertBeforeAtHead()
  {
    LinkedList list = new LinkedList();
    list.insert(1);
    list.insertBefore(1, 4);
    Assertions.assertEquals(list.head.value, 4);
  }

  @Test void testLinkedListInsertBeforeFails()
  {
    LinkedList list = new LinkedList();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    boolean result = list.insertBefore(5, 4);
    Assertions.assertFalse(result);
  }

  @Test void testLinkedListAfterInMiddle()
  {
    LinkedList list = new LinkedList();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insertAfter(2, 3);
    Assertions.assertEquals(list.head.next.next.value, 3);
  }

  @Test void testLinkedListAfterLast()
  {
    LinkedList list = new LinkedList();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insertAfter(1, 4);
    Assertions.assertEquals(list.head.next.next.next.value, 4);
    Assertions.assertNull(list.head.next.next.next.next);
  }

  @Test void testLinkedListInsertAfterFails()
  {
    LinkedList list = new LinkedList();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    boolean result = list.insertAfter(5, 4);
   Assertions.assertFalse(result);
  }

}
