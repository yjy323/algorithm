package array.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2531 {

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int n = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int[] arrInput = new int[n];
    int[] arrKind = new int[d + 1];
    arrKind[c] = 1;

    for (int i = 0; i < n; i++) {
      arrInput[i] = Integer.parseInt(bf.readLine());
    }

    int cnt = 1;
    for (int i = 0; i < k; i++) {
      arrKind[arrInput[i]] += 1;
      if (arrKind[arrInput[i]] == 1) {
        cnt++;
      }
    }

    int maxCnt = cnt;
    int idxPush = 0;
    int idxPop = 0;
    int j = 0;
    for (int i = 0; i < n - 1; i++) {

      j = (i + k) % n;
      idxPop = arrInput[i];
      arrKind[idxPop] -= 1;
      if (arrKind[idxPop] == 0) {
        cnt--;
      }

      idxPush = arrInput[j];
      arrKind[idxPush] += 1;
      if (arrKind[idxPush] == 1) {
        cnt++;
      }

      if (cnt > maxCnt) {
        maxCnt = cnt;
      }
    }
    System.out.print(maxCnt);
  }
}
