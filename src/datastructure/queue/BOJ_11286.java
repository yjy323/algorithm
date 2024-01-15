package datastructure.queue;

/*
 * Heap, Priority Queue
 * */

import java.util.*;
import java.io.*;

public class BOJ_11286 {

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
      int first = Math.abs(o1);
      int second = Math.abs(o2);
      if (first == second) {
        return o1 > o2 ? 1 : -1;
      } else {
        return Math.abs(o1) - Math.abs(o2);
      }
    });

    int n = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) {
      int input = Integer.parseInt(bf.readLine());
      if (input == 0) {
        if (priorityQueue.isEmpty()) {
          System.out.println("0");
        } else {
          System.out.println(priorityQueue.poll());
        }
      } else {
        priorityQueue.add(input);
      }
    }
  }
}
