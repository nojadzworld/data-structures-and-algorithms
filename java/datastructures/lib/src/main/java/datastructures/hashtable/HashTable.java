package datastructures.hashtable;

import java.util.*;

public class HashTable<K, V> {

    private ArrayList<LinkedList<Node>> array;
    private static final int INITIAL_CAPACITY = 187751;

    public HashTable() {
        array = new ArrayList<>(Collections.nCopies(INITIAL_CAPACITY, null));
    }


    int hash(K key) {

        long hashValue = (long) key.hashCode();


        hashValue = hashValue < 0 ? hashValue * -1 : hashValue;


        int prime = 31;

        return Math.abs((int) (prime * hashValue % array.size()));

    }

    public void set(K key, V value) {
        int index = hash(key);
        if (array.get(index) == null) {
            array.set(index, new LinkedList<>());
        }

        LinkedList<Node> items = array.get(index);

        for (Node item : items) {
            if (item.key.equals(key)) {
                item.value = value; // Replace existing value
                return;
            }
        }

        items.add(new Node(key, value)); // Add new node if key not found
    }

    public V get(K key) {
        int index = hash(key);
        if (array.get(index) == null) {
            return null;
        }

        LinkedList<Node> items = array.get(index);

        for (Node item : items) {
            if (item.key.equals(key)) {
                return item.value;
            }
        }

        return null; // Return null if key not found
    }

    public boolean has(K key) {
        return get(key) != null;
    }

    public List<K> keys() {
        List<K> keysList = new ArrayList<>();
        for (LinkedList<Node> items : array) {
            if (items != null) {
                for (Node item : items) {
                    keysList.add(item.key);
                }
            }
        }
        return keysList;
    }

    private class Node {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
