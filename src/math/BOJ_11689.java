package math;

import java.util.Scanner;

public class BOJ_11689 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    long pi = n;

    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        pi = pi / i * (i - 1);
      }

      // i의 배수 중 n의 소인수가 있다면 연산
      while (n % i == 0) {
        n /= i;
      }
    }

    /*
      1. 초기값 n이 소수인 경우
      2. 초기값 n이 소수가 아니지만, n의 소인수가 소수인 경우
    * */
    if (n != 1) {
      pi = pi / n * (n - 1);
    }
    System.out.println(pi);
  }
}
