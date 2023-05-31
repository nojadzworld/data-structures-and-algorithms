package codechallenges.linkedlist;

import datastructures.linkedlist.LinkedList;
import datastructures.linkedlist.Node;

public class LinkedListChallenges
{
  LinkedList linkedList;

public LinkedListChallenges() {
  linkedList = new LinkedList();
}
  public static LinkedList linkedListChallenge08(LinkedList list1, LinkedList list2) {
    if (list1 == null || list1.head == null) {
      return list2;
  }
    if (list2 == null || list2.head == null) {
      return list1;
}

    Node current1 = list1.head;
    Node current2 = list2.head;
    Node temp1;
    Node temp2;

    while (current1 != null && current2 != null) {
      temp1 = current1.next;
      temp2 = current2.next;


      current1.next = current2;
      if (temp1 != null) {
        current2.next = temp1;
      }

      current1 = temp1;
      current2 = temp2;
    }

    return list1;
  }
}
