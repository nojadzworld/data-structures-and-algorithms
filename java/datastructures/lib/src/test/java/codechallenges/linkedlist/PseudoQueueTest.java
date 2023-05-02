package codechallenges.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PseudoQueueTest {
  private PseudoQueue<Integer> pseudoQueue;

  @BeforeEach
  public void setUp() {
    pseudoQueue = new PseudoQueue<>();
    pseudoQueue.enqueue(20);
    pseudoQueue.enqueue(15);
    pseudoQueue.enqueue(10);
  }

  @Test
  public void testEnqueue() {
    pseudoQueue.enqueue(5);
    assertEquals(20, pseudoQueue.dequeue());
    assertEquals(15, pseudoQueue.dequeue());
    assertEquals(10, pseudoQueue.dequeue());
    assertEquals(5, pseudoQueue.dequeue());
  }

  @Test
  public void testDequeue() {
    assertEquals(20, pseudoQueue.dequeue());
    assertEquals(15, pseudoQueue.dequeue());
    assertEquals(10, pseudoQueue.dequeue());
    assertThrows(RuntimeException.class, () -> pseudoQueue.dequeue());
  }

  @Test
  public void testDequeueAfterEnqueue() {
    assertEquals(20, pseudoQueue.dequeue());
    assertEquals(15, pseudoQueue.dequeue());
    pseudoQueue.enqueue(5);
    assertEquals(10, pseudoQueue.dequeue());
    assertEquals(5, pseudoQueue.dequeue());
    assertThrows(RuntimeException.class, () -> pseudoQueue.dequeue());
  }
}
