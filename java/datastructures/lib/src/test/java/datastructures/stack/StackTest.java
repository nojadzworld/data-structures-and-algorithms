package datastructures.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
  private Stack<Integer> sut;


  @BeforeEach
  public void setup() {
    sut = new Stack<>();
  }


  @Test
  public void canPushOntoStack() {
    sut.push(1);
    assertFalse(sut.isEmpty());

  }

  @Test
  public void canPushMultipleValuesOntoStack() {
    sut.push(1);
    sut.push(2);
    sut.push(3);

    assertEquals(3, sut.pop());
    assertEquals(2, sut.pop());
    assertEquals(1, sut.pop());
    assertTrue(sut.isEmpty());


  }

  @Test
  public void canPopOffStack() {
    sut.push(1);
    sut.push(2);
    sut.push(3);
    int popped = sut.pop();
    assertEquals(3, popped);
    assertEquals(2, sut.pop());
    assertEquals(1, sut.pop());
    assertTrue(sut.isEmpty());

  }

  @Test
  public void canEmptyStackAfterMultiplePops() {
    sut.push(1);
    sut.push(2);
    sut.push(3);
    sut.pop();
    sut.pop();
    sut.pop();
    assertTrue(sut.isEmpty());

  }

  @Test
  public void canPeekNextItemOnStack() {
    sut.push(1);
    sut.push(2);
    sut.push(3);
    int peeked = sut.peek();
    assertEquals(3, peeked);
    assertFalse(sut.isEmpty());

  }

  @Test
  public void canInstantiateEmptyStack() {
    assertTrue(sut.isEmpty());
  }

  @Test
  public void popOnEmptyStackRaisesException() {
    assertThrows(RuntimeException.class, () -> sut.pop());
  }

  @Test
  public void peekOnEmptyStackRaisesException() {
    assertThrows(RuntimeException.class, () -> sut.peek());
  }
}
