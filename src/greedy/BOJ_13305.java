package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    StringTokenizer distToken = new StringTokenizer(bf.readLine());
    StringTokenizer priceToken = new StringTokenizer(bf.readLine());
    long sumDist = Long.parseLong(distToken.nextToken());
    long minPrice = Long.parseLong(priceToken.nextToken());
    long sumPrice = 0;
    for (int i = 1; i < n - 1; ++i) {
      long dist = Long.parseLong(distToken.nextToken());
      long price = Long.parseLong(priceToken.nextToken());

      if (price < minPrice){
        sumPrice += sumDist * minPrice;
        minPrice = price;
        sumDist = dist;
      } else {
        sumDist += dist;
      }
    }
    sumPrice += sumDist * minPrice;
    System.out.println(sumPrice);
    bf.close();
  }
}
