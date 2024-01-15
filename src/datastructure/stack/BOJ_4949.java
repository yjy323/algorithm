package datastructure.stack;

import java.util.*;
import java.io.*;

public class BOJ_4949 {

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String input = bf.readLine();
      if (input.equals(".")) {
        break;
      }

      Stack<Character> stack = new Stack<>();
      char sentence[] = input.toCharArray();
      for (char word : sentence) {
        switch (word) {
          case '(':
          case '[':
            stack.push(word);
            break;
          case ')':
            if (!stack.isEmpty() && stack.peek() == '(') {
              stack.pop();
            } else {
              stack.push(word);
            }
            break;
          case ']':
            if (!stack.isEmpty() && stack.peek() == '[') {
              stack.pop();
            } else {
              stack.push(word);
            }
            break;
        }
      }
      if (stack.isEmpty()) {
        System.out.println("yes");
      } else {
        System.out.println("no");
      }
    }
    bf.close();
  }
}
