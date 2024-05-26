package datastructure.stack;

import java.util.*;
import java.io.*;

public class BOJ_17298 {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int n = Integer.parseInt(st.nextToken());
    Stack<Integer> stack = new Stack<>();

    int arr[] = new int[n];
    st = new StringTokenizer(bf.readLine());
    for (int i = 0; i < n; i++) {

      arr[i] = Integer.parseInt(st.nextToken());
      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        arr[stack.pop()] = arr[i];
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      arr[stack.pop()] = -1;
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++) {
      sb.append(arr[i]).append(' ');
    }

    System.out.println(sb);
  }
}
