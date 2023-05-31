package datastructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {
  protected Node<T> root;

  public BinaryTree(T value) {
    root = new Node<>(value);
  }

  public List<T> preOrderTraversal() {
    List<T> output = new ArrayList<>();
    preOrderTraversal(this.root, output);
    return output;
  }

  private void preOrderTraversal(Node<T> node, List<T> output) {
    if (node == null) return;

    output.add(node.value);
    preOrderTraversal(node.left, output);
    preOrderTraversal(node.right, output);
  }

  public List<T> inOrderTraversal() {
    List<T> output = new ArrayList<>();
    inOrderTraversal(this.root, output);
    return output;
  }

  private void inOrderTraversal(Node<T> node, List<T> output) {
    if (node == null) return;

    inOrderTraversal(node.left, output);
    output.add(node.value);
    inOrderTraversal(node.right, output);
  }

  public List<T> postOrderTraversal() {
    List<T> output = new ArrayList<>();
    postOrderTraversal(this.root, output);
    return output;
  }

  private void postOrderTraversal(Node<T> node, List<T> output) {
    if (node == null) return;

    postOrderTraversal(node.left, output);
    postOrderTraversal(node.right, output);
    output.add(node.value);
  }

  public void add(T value) {
    Queue<Node<T>> queue = new LinkedList<>();
    this.root = add(this.root, value, queue);
  }

  private Node<T> add(Node<T> node, T value, Queue<Node<T>> queue) {
    if (node == null) {
      return new Node<>(value);
    }

    if (node.left == null) {
      node.left = new Node<>(value);
      return node;
    } else if (node.right == null) {
      node.right = new Node<>(value);
      return node;
    } else {
      queue.add(node.left);
      queue.add(node.right);
      add(queue.poll(), value, queue);
    }

    return node;
  }

  public List<T> breadthFirstTraversal() {
    List<T> output = new ArrayList<>();
    if (this.root == null) {
      return output;
    }

    Queue<Node<T>> queue = new LinkedList<>();
    queue.offer(this.root);

    while (!queue.isEmpty()) {
      Node<T> node = queue.poll();
      output.add(node.value);

      if (node.left != null) {
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
    }
    return output;
  }


  public T getMax() {
    if (this.root == null) {
      throw new RuntimeException("Tree is empty");
    }

    return getMax(this.root);
  }

  private T getMax(Node<T> node) {
    if (node == null) return null;

    T currentValue = node.value;
    T leftMax = getMax(node.left);
    T rightMax = getMax(node.right);

    T max = currentValue;
    if (leftMax != null && leftMax.compareTo(max) > 0) {
      max = leftMax;
    }
    if (rightMax != null && rightMax.compareTo(max) > 0) {
      max = rightMax;
    }

    return max;
  }


  public Node<T> getRoot() {
    return root;
  }
}


