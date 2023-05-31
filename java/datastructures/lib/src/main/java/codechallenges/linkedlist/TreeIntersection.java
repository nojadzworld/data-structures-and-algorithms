package codechallenges.linkedlist;

import datastructures.trees.Node;
import java.util.*;

public class TreeIntersection<T extends Comparable<T>> {

    public List<Integer> treeIntersection(Node<T> rootOne, Node<T> rootTwo) {
        List<Integer> output = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        if (rootOne == null || rootTwo == null) {
            return output;
        }
        queue.add(rootOne);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            map.put((Integer) current.value, Boolean.TRUE);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }

        }

        queue.add(rootTwo);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (map.containsKey(current.value)) {
                output.add((Integer) current.value);
            }

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return output;
    }

}
