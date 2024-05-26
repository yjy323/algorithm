package simulation;

import java.util.Scanner;

public class BOJ_23971 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int h = sc.nextInt() - 1;
    int w = sc.nextInt() - 1;
    int n = sc.nextInt();
    int m = sc.nextInt();

    h = h / (1 + n) + 1;
    w = w / (1 + m) + 1;
    System.out.println(h * w);
  }
}
