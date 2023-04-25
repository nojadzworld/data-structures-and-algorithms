package datastructures.linkedlist;

public class LinkedList {
  public Node head;

  public LinkedList() {
    this.head = null;
  }


  public void insert(int value) {
    Node newNode = new Node(value);
    newNode.next = head;
    head = newNode;
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

  public boolean insertBefore(int valueToInsertBefore, int newValue) {
    Node newNode = new Node(newValue);

    if (this.head == null) {
      return false;
    }

    Node current = this.head;

    if (current.value == valueToInsertBefore) {
      insert(newValue);
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

  public boolean includes(int value) {
    Node current = head;
    while (current != null) {
      if (current.value == value) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  @Override
  public String toString() {
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
}
