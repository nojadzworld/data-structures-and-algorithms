package datastructures.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class LinkedList
{
  public Node head = null;

  public void insertAtBeginning(int value) {
    Node newNode = new Node(value);

    if (this.head == null) {
      this.head = newNode;
      return;
    }

    newNode.next = this.head;
    this.head = newNode;
  }

  public void append(int value) {
    Node newNode = new Node(value);

    if (this.head == null) {
      this.head = newNode;
      return;
    }

    Node current = this.head;

    while (current.next != null) {
      current = current.next;
    }

    current.next = newNode;
  }

  // We'll make this method return a boolean for whether the operation was successful or not
  public boolean insertBefore(int valueToInsertBefore, int newValue) {
    Node newNode = new Node(newValue);

    if (this.head == null) {
      return false;
    }

    Node current = this.head;

    if (current.value == valueToInsertBefore) {
      insertAtBeginning(newValue);
      return true;
    }

    while (current.next != null) {
      if (current.next.value == valueToInsertBefore) {
        newNode.next = current.next;
        current.next = newNode;
        return true;
      } else {
        current = current.next;
      }
    }

    return false;
  }

  // We'll make this method return a boolean for whether the operation was successful or not
  public boolean insertAfter(int valueToInsertAfter, int newValue) {
    Node newNode = new Node(newValue);

    if (this.head == null) {
      return false;
    }

    if (this.head.value == valueToInsertAfter) {
      this.append(newValue);
    }

    Node current = this.head;

    while (current != null) {
      if (current.value == valueToInsertAfter) {
        newNode.next = current.next;
        current.next = newNode;
        return true;
      }
      current = current.next;
    }

    return false;
  }

  // We'll make this method return a boolean for whether the operation was successful or not
  public boolean deleteNode(int valueToDelete) {

    if (this.head == null) {
      return false;
    }

    if (this.head.value == valueToDelete) {
      this.head = this.head.next;
      return true;
    }

    Node current = this.head;

    while (current.next != null) {
      if (current.next.value == valueToDelete) {
        current.next = current.next.next;
        return true;
      }
      current = current.next;
    }

    return false;
  }

  public boolean includes(int value) {
    Node current = this.head;

    while (current != null) {
      if (current.value == value) {
        return true;
      }
      current = current.next;
    }

    return false;
  }


  public int kthFromEnd(int k) {
    // Check that the head is not null
    if (this.head == null) {
      throw new NoSuchElementException("The list is empty");
    }

    // Check that k is a positive integer or 0
    if (k < 0) {
      throw new IllegalArgumentException("k must be greater than or equal to 0");
    }

    Map<Integer, Integer> nodeValueMap= new HashMap<>();
    Node current = this.head;
    int index = 0;

    while (current != null) {
      nodeValueMap.put(index, current.value);
      index++;
      current = current.next;
    }


    if (k >= index) {
      throw new IllegalArgumentException("k must be less than the linked list size");
    }
    int size = index;
    int desiredIndex = size - k - 1;

    return nodeValueMap.get(desiredIndex);
  }

  @Override
  public String toString()
  {
    Node current = this.head;
    String values = "";
    while (current != null) {
      values += String.format("{ %d } -> ", current.value);
      current = current.next;
    }
    values += "NULL";
    return values;
  }
}