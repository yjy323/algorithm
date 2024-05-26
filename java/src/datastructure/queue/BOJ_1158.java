package datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    StringBuffer sb = new StringBuffer("<");
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++){
      queue.add(i + 1);
    }

    int delIdx = k;
    while (n > 1) {

      if (n < k) {
        delIdx = k % n;
        delIdx = (delIdx == 0) ? n : delIdx;
      }

      for (int i = 1; i < delIdx; i++){
        queue.add(queue.poll());
      }
      sb.append(queue.poll() + ", ");
      n--;
    }
    sb.append(queue.poll() + ">");

    System.out.println(sb);
  }
}