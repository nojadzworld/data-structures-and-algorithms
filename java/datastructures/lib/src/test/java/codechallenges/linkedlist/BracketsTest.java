package codechallenges.linkedlist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BracketsTest {

  private Brackets brackets;

  @BeforeEach
  void setUp() {
    brackets = new Brackets();
  }

  @Test
  public void testEmptyString() {
    assertTrue(brackets.validateString(""));
  }

  @Test
  public void testValidBrackets() {
    assertTrue(brackets.validateString("{}"));
    assertTrue(brackets.validateString("{}(){}"));
    assertTrue(brackets.validateString("()[[Extra Characters]]"));
    assertTrue(brackets.validateString("(){}[[]]"));
    assertTrue(brackets.validateString("{}{Code}[Fellows](())"));
  }

  @Test
  public void testInvalidBrackets() {
    assertFalse(brackets.validateString("[({}]"));
    assertFalse(brackets.validateString("(]("));
    assertFalse(brackets.validateString("{(})"));
    assertFalse(brackets.validateString("{"));
    assertFalse(brackets.validateString(")"));
    assertFalse(brackets.validateString("[}"));
  }
}
