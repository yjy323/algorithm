package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1940_two_pointer {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    int start = 0;
    int end = n -1;
    int count = 0;
    int sum = 0;

    while (start < end){
      sum = arr[start] + arr[end];
      if(sum == m) {
        start++;
        end--;
        count++;
      }
      else if (sum < m){
        start++;
      }
      else {
        end--;
      }
    }
    System.out.println(count);
  }
}
