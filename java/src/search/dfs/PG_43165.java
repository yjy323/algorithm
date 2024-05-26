package search.dfs;

public class PG_43165 {

  static int cnt = 0;
  static int sum = 0;
  static int n;

  public int solution(int[] numbers, int target) {
    n = numbers.length;

    dfs(0, numbers, target);
    return cnt;
  }

  private static void dfs(int i, int[] numbers, int target) {
    if (i == n) {
      if (target == sum) {
        cnt++;
      }
      return;
    }
    int val = numbers[i];
    sum += val;
    dfs(i + 1, numbers, target);
    sum -= val;

    sum -= val;
    dfs(i + 1, numbers, target);
    sum += val;
  }
}
