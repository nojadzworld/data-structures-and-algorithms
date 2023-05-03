package datastructures.queue;

import datastructures.queue.Node;

public class Queue<T> {

  Node<T> front;
  Node<T> back;

  public void enqueue(T valueToEnqueue)
  {
   Node<T> newNode = new Node<>(valueToEnqueue);
   if (back != null) {
     back.next = newNode;
   }
   back = newNode;
   if (isEmpty()) {
     front = back;
   }
  }

  public T dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Queue is empty");
    }

    Node<T> dequeuedNode = front;
    front = front.next;
    dequeuedNode.next = null;

    return dequeuedNode.value;
  }

  public T peek() {
    if (isEmpty()) {
      throw new RuntimeException("Queue is empty.");
    }
    return front.value;
  }

  public boolean isEmpty()
  {

    return front == null;
  }
}
