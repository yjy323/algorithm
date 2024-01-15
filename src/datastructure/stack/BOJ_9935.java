package datastructure.stack;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class BOJ_9935 {

  static BufferedReader bf;

  public static void main(String[] args) throws IOException {
    bf = new BufferedReader(new InputStreamReader(System.in));

    char input[] = bf.readLine().toCharArray();
    char bomb[] = bf.readLine().toCharArray();
    int inputLen = input.length;
    int bombLen = bomb.length;
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < inputLen; i++) {

      int cnt = 0;
      stack.push(input[i]);

      if (stack.size() >= bombLen) {
        for (int j = 0; j < bombLen; j++) {
          if (stack.get(stack.size() - bombLen + j) == bomb[j]) {
            cnt++;
          }
        }
        if (cnt == bombLen) {
          for (int j = 0; j < bombLen; j++) {
            stack.pop();
          }
        }
      }
    }
    if (stack.isEmpty()) {
      System.out.println("FRULA");
    } else {
      System.out.println(stack.stream().map(c -> c.toString()).collect(Collectors.joining("")));
    }
    bf.close();
  }
}
