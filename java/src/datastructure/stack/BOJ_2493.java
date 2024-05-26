package datastructure.stack;

import java.util.*;
import java.io.*;

public class BOJ_2493 {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bf.readLine());
    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(bf.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    StringBuilder answer = new StringBuilder("0 ");
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for (int i = 1; i < n; i++) {

      while (!stack.isEmpty()) {
        if (arr[stack.peek()] >= arr[i]) {
          answer.append(stack.peek() + 1 + " ");
          break;
        } else {
          stack.pop();
        }
      }
      if (stack.isEmpty())
        answer.append("0 ");
      stack.push(i);
    }

    System.out.println(answer);
  }
}
