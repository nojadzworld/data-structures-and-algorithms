package codechallenges.linkedlist;


import java.util.Stack;

public class PseudoQueue<T> {

  private Stack<T> stack1;
  private Stack<T> stack2;

  public PseudoQueue() {
    stack1 = new Stack<>();
    stack2 = new Stack<>();
  }

  public void enqueue(T value) {
    while (!stack1.empty()) {
      stack2.push(stack1.pop());
    }
    stack1.push(value);
    while (!stack2.empty()) {
      stack1.push(stack2.pop());
    }
  }

  public T dequeue() {
    if (stack1.empty()) {
      throw new IllegalStateException("Cannot dequeue from an empty queue");
    }
    return stack1.pop();
  }
}
