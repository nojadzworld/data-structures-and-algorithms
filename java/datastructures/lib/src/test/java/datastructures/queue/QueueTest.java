package datastructures.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

  private Queue<Integer> sut;

  @BeforeEach
  public void setUp() {
    sut = new Queue<>();
  }

  @Test
  public void canEnqueueIntoQueue() {
    sut.enqueue(1);
    assertFalse(sut.isEmpty());

  }

  @Test
  public void canEnqueueMultipleValuesIntoQueue() {
    Queue<Integer> queue = new Queue<>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    assertFalse(queue.isEmpty());
  }

  @Test
  public void  canDequeueOutOfQueue() {
    Queue<Integer> queue = new Queue<>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    int dequeued = queue.dequeue();
    assertEquals(1, dequeued);
    assertFalse(queue.isEmpty());

  }

  @Test
  public void canPeekIntoQueue() {
    sut.enqueue(1);
    sut.enqueue(2);

    assertEquals(1, sut.peek());


  }


  @Test
  public void canEmptyQueueAfterMultipleDequeues() {
    Queue<Integer> queue = new Queue<>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    assertTrue(queue.isEmpty());
  }

  @Test
  public void canInstantiateEmptyQueue() {
    Queue<Integer> queue = new Queue<>();
    assertTrue(queue.isEmpty());
  }

  @Test
  public void dequeueOnEmptyQueueRaisesException() {
    assertThrows(RuntimeException.class, () -> sut.dequeue());
  }

  @Test
  public void peekOnEmptyQueueRaisesException() {
    assertThrows(RuntimeException.class, () -> sut.peek());
  }

}
