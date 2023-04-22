package datastructures.linkedlist;

public class LinkedList
{
  public Node head;

  public LinkedList() {
    this.head = null;
  }

  public void insert(int value) {
    Node newNode = new Node(value);
    newNode.next = head;
    head = newNode;
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
  public String toString()
   {
     StringBuilder sb = new StringBuilder();
     Node current = head;
     while (current != null) {
       sb.append("{");
       sb.append(current.value);
       sb.append(" } -> ");
       current = current.next;
     }
     sb.append("NULL");
       return sb.toString();
    }
}
