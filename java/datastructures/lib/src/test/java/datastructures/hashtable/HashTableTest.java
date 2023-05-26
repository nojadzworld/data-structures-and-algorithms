package datastructures.hashtable;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {
    private static final int CAPACITY = 187751;

    @Test
    void testSetAndGet() {
        HashTable<String, Integer> hashtable = new HashTable<>();
        hashtable.set("key1", 1);
        assertEquals(1, hashtable.get("key1"));
    }

    @Test
    void testGetNonExistingKey() {
        HashTable<String, Integer> hashtable = new HashTable<>();
        assertNull(hashtable.get("nonExistingKey"));
    }

    @Test
    void testGetKeys() {
        HashTable<String, Integer> hashtable = new HashTable<>();
        hashtable.set("key1", 1);
        hashtable.set("key2", 2);
        assertEquals(Set.of("key1", "key2"), new HashSet<>(hashtable.keys()));
    }

    @Test
    void testHandleCollision() {
        HashTable<Integer, String> hashtable = new HashTable<>();
        hashtable.set(1, "value1");
        hashtable.set(1 + CAPACITY, "value2");
        assertEquals("value1", hashtable.get(1));
        assertEquals("value2", hashtable.get(1 + CAPACITY));
    }

    @Test
    void testGetValueFromBucketWithCollision() {
        HashTable<Integer, String> hashtable = new HashTable<>();
        hashtable.set(1, "value1");
        hashtable.set(1 + CAPACITY, "value2");
        assertEquals("value2", hashtable.get(1 + CAPACITY));
    }

    @Test
    void testHashInRange() {
        HashTable<String, Integer> hashtable = new HashTable<>();
        String key = "testKey";
        int hash = hashtable.hash(key);
        assertTrue(hash >= 0 && hash < CAPACITY);
    }
}