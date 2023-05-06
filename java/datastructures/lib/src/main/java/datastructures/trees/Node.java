package datastructures.trees;

public class Node<T> {
  public T value;
  public Node<T> left;
  public Node<T> right;

  Node(T value) {
    this.value = value;
    this.left = null;
    this.right =null;
  }

}
