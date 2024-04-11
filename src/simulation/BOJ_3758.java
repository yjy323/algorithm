package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3758 {

  static class Solution {

    int id;
    int submitCnt;
    int lastSubmitTime;
    int[] scores;
    int sumOfScores;

    int updateScore(int j, int s) {
      if (scores[j] < s) {
        sumOfScores = sumOfScores - scores[j] + s;
        scores[j] = s;
      }
      return this.scores[j];
    }

    Solution(int id, int k) {
      this.id = id;
      scores = new int[k];
      Arrays.fill(scores, 0);
      submitCnt = 0;
      lastSubmitTime = 0;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bf.readLine());
    StringBuffer sb = new StringBuffer();
    for (int tcIdx = 0; tcIdx < t; ++tcIdx) {
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int myTeam = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      Solution[] solutions = new Solution[n];
      for (int id = 0; id < n; ++id) {
        solutions[id] = new Solution(id + 1, k);
      }
      for (int logIdx = 0; logIdx < m; ++logIdx) {
        st = new StringTokenizer(bf.readLine());
        int i = Integer.parseInt(st.nextToken()) - 1;
        int j = Integer.parseInt(st.nextToken()) - 1;
        int s = Integer.parseInt(st.nextToken());

        solutions[i].submitCnt += 1;
        solutions[i].lastSubmitTime = logIdx;
        solutions[i].scores[j] = solutions[i].updateScore(j, s);
      }

      Arrays.sort(solutions, (o1, o2) -> {
        if (o1.sumOfScores != o2.sumOfScores) {
          return o2.sumOfScores - o1.sumOfScores;
        } else if(o1.submitCnt != o2.submitCnt){
          return o1.submitCnt - o2.submitCnt;
        } else {
          return o1.lastSubmitTime - o2.lastSubmitTime;
        }
      });

      for (int id = 0; id < n; ++id){
        if (solutions[id].id == myTeam){
          sb.append(id + 1 + "\n");
          break;
        }
      }
    }

    System.out.print(sb);
    bf.close();
  }
}
