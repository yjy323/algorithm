package datastructure;

import java.util.Scanner;

public class BOJ_1546_array {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int value;

    long sum = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      value = sc.nextInt();
      sum += value;
      max = value > max ? value : max;
    }
    System.out.println(sum * 100.0 / max / n);
  }
}
