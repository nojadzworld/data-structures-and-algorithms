package codechallenges.linkedlist;

import datastructures.stack.Stack;

import java.util.HashMap;
import java.util.Map;

public class Brackets {

  private Stack<Character> stack;

  public Brackets() {
    this.stack = new Stack<>();
  }

  public boolean validateString(String string) {

    Map<Character, Character> hashMap = new HashMap<>();
    hashMap.put('}', '{');
    hashMap.put(']', '[');
    hashMap.put(')', '(');

    for (int i = 0; i < string.length(); i++) {
      char letter = string.charAt(i);
      if (letter == '{' || letter == '[' || letter == '(') {
        stack.push(letter);
      } else if (letter == '}' || letter == ']' || letter == ')') {
        if (hashMap.get(letter) == stack.peek()) {
          stack.pop();
        } else {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }
}
