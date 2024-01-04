package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891_sliding_window {

  static final int CATEGORIES_NUM = 4;
  static int[] passwordCntArr = new int[CATEGORIES_NUM];
  static int[] requiredCntArr = new int[CATEGORIES_NUM];

  static int isRequiredCnt = 0;
  static int resultCnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int S = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    char[] STR = br.readLine().toCharArray();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < CATEGORIES_NUM; i++) {
      requiredCntArr[i] = Integer.parseInt(st.nextToken());
      if (requiredCntArr[i] == 0) {
        isRequiredCnt++;
      }
    }

    init(STR, P);
    slide(STR, S, P);

    System.out.println(resultCnt);
    br.close();
  }

  private static void slide(char[] STR, int S, int P) {
    int j = 0;

    for (int i = P; i < S; i++) {
      j = i - P;
      Add(STR[i]);
      Remove(STR[j]);
      if (isRequiredCnt == CATEGORIES_NUM)
        resultCnt++;
    }
  }

  static void init(char[] STR, int P) {
    for (int i = 0; i < P; i++) {
      Add(STR[i]);
    }

    if (isRequiredCnt == CATEGORIES_NUM)
      resultCnt++;
  }

  private static void Add(char c) {
    switch (c) {
      case 'A':
        passwordCntArr[0]++;
        if (passwordCntArr[0] == requiredCntArr[0]) {
          isRequiredCnt++;
        }
        break;
      case 'C':
        passwordCntArr[1]++;
        if (passwordCntArr[1] == requiredCntArr[1]) {
          isRequiredCnt++;
        }
        break;
      case 'G':
        passwordCntArr[2]++;
        if (passwordCntArr[2] == requiredCntArr[2]) {
          isRequiredCnt++;
        }
        break;
      case 'T':
        passwordCntArr[3]++;
        if (passwordCntArr[3] == requiredCntArr[3]) {
          isRequiredCnt++;
        }
        break;
    }
  }

  private static void Remove(char c) {
    switch (c) {
      case 'A':
        if (passwordCntArr[0] == requiredCntArr[0]) {
          isRequiredCnt--;
        }
        passwordCntArr[0]--;
        break;
      case 'C':
        if (passwordCntArr[1] == requiredCntArr[1]) {
          isRequiredCnt--;
        }
        passwordCntArr[1]--;
        break;
      case 'G':
        if (passwordCntArr[2] == requiredCntArr[2]) {
          isRequiredCnt--;
        }
        passwordCntArr[2]--;
        break;
      case 'T':
        if (passwordCntArr[3] == requiredCntArr[3]) {
          isRequiredCnt--;
        }
        passwordCntArr[3]--;
        break;
    }
  }


}
