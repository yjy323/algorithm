package greedy;

import java.util.Scanner;

public class BOJ_1541 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String eq = sc.nextLine();
    String[] newEq = eq.split("-");

    int answer = 0;
    for (int i = 0; i < newEq.length; i++) {
      String[] newNewEq = newEq[i].split("\\+");
      int sum = 0;
      for (int j = 0; j < newNewEq.length; j++) {
          sum += Integer.parseInt(newNewEq[j]);
      }
      if (i == 0) {
        answer += sum;
      } else {
        answer -= sum;
      }
    }
    System.out.println(answer);
  }
}
