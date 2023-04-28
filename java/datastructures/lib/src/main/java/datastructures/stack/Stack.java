package datastructures.stack;



public class Stack<T> {

  Node<T> top;

  void push(T valueToPush) {
    Node<T> newNode = new Node<T>(valueToPush);
    newNode.next = top;
    top = newNode;
  }

  T pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty.");
    }
    Node<T> poppedNode = top;
    top = top.next;
    poppedNode.next = null;
    return poppedNode.value;
  }

  T peek() {
   if (isEmpty()) {
     throw new RuntimeException("Stack is empty.");
   }
    return top.value;
  }

  boolean isEmpty() {
    return top == null;

  }

}
