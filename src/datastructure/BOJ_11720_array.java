package datastructure;

import java.util.Scanner;

public class BOJ_11720_array {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String sNum = sc.next();
    char[] cNum = sNum.toCharArray();

    int sum = 0;
    for (int i = 0; i < N; i++){
      sum += cNum[i] - '0';
    }
    System.out.println(sum);
  }
}
