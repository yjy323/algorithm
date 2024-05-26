package datastructure.stack;

import java.io.*;
import java.util.Stack;

public class BOJ_9012 {

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bf.readLine());
    String brackets;
    Stack<Character> stack;
    for (int i = 0; i < n; i++) {
      brackets = bf.readLine();
      stack = new Stack<>();
      for (int j = 0; j < brackets.length(); j++) {
        if (brackets.charAt(j) == '(') {
          stack.push('(');
        } else if (stack.isEmpty()) {
          stack.push(')');
          break;
        } else {
          stack.pop();
        }
      }
      if (stack.isEmpty()) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}
