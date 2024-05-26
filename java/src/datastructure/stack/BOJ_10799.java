package datastructure.stack;

import java.io.*;
import java.util.*;

public class BOJ_10799 {

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    char input[] = bf.readLine().toCharArray();
    Stack<Character> stack = new Stack<>();

    int cnt = 0;
    for (int i = 0; i < input.length; i++) {
      if (input[i] == '(') {
        stack.push('(');
      } else {
        stack.pop();
        if (input[i - 1] == '('){
          cnt += stack.size();
        } else {
          cnt++;
        }
        System.out.println(cnt);
      }
    }
    System.out.println(cnt);
  }
}
