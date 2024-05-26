package simulation;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1157 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String word = sc.next();

    int[] alphaMap = new int[27];
    Arrays.fill(alphaMap, 0);
    word = word.toLowerCase();

    for (char c : word.toCharArray()) {
      alphaMap[c - 'a'] += 1;
    }

    int maxIdx = 0;
    boolean flag = true;
    for (int i = 1; i < 27; ++i){
      if (alphaMap[maxIdx] < alphaMap[i]){
        maxIdx = i;
        flag = true;
      } else if(alphaMap[maxIdx] == alphaMap[i]){
        flag = false;
      }
    }
    System.out.println(flag ? (char)(maxIdx + 'A') : '?');
  }
}
