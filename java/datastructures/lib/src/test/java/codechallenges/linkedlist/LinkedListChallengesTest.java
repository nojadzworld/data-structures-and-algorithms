package codechallenges.linkedlist;

import datastructures.linkedlist.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListChallengesTest
{
  @Test
  void testZipLists_bothNonEmpty()
  {
    LinkedList list1 = new LinkedList();
    list1.insertAtBeginning(3);
    list1.insertAtBeginning(1);

    LinkedList list2 = new LinkedList();
    list2.insertAtBeginning(4);
    list2.insertAtBeginning(9);
    list2.insertAtBeginning(5);

    String expected = "{ 1 } -> { 5 } -> { 3 } -> { 9 } -> { 4 } -> NULL";
    String actual = LinkedListChallenges.linkedListChallenge08(list1, list2).toString();
    assertEquals(expected, actual);
  }

  @Test
  void testZipLists_firstEmpty()
  {
    LinkedList list1 = new LinkedList();

    LinkedList list2 = new LinkedList();
    list2.insertAtBeginning(4);
    list2.insertAtBeginning(9);
    list2.insertAtBeginning(5);

    String expected = "{ 5 } -> { 9 } -> { 4 } -> NULL";
    String actual = LinkedListChallenges.linkedListChallenge08(list1, list2).toString();
    assertEquals(expected, actual);
  }

  @Test
  void testZipLists_secondEmpty()
  {
    LinkedList list2 = new LinkedList();

    LinkedList list1 = new LinkedList();
    list1.insertAtBeginning(4);
    list1.insertAtBeginning(9);
    list1.insertAtBeginning(5);

    String expected = "{ 5 } -> { 9 } -> { 4 } -> NULL";
    String actual = LinkedListChallenges.linkedListChallenge08(list1, list2).toString();
    assertEquals(expected, actual);
  }

  @Test
  void testZipLists_bothEmpty()
  {
    LinkedList list1 = new LinkedList();
    LinkedList list2 = new LinkedList();

    String expected = "NULL";
    String actual = LinkedListChallenges.linkedListChallenge08(list1, list2).toString();
    assertEquals(expected, actual);
  }
}
