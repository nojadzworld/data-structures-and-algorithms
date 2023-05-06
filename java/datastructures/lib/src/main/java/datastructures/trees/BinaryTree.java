package datastructures.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {
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

  public Node<T> getRoot() {
    return root;
  }
}
