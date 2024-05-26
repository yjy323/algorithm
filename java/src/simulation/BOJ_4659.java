package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4659 {

  static String acc = "> is acceptable.\n";
  static String not = "> is not acceptable.\n";

  private static boolean isVowel(char c) {
    switch (c) {
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
        return true;
      default:
        return false;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    String s;
    while (!(s = bf.readLine()).equals("end")) {
      boolean isAcceptable = false;
      char prev = 0;
      int cnt = 0;
      for (char c : s.toCharArray()) {
        if (isVowel(c)) {
          isAcceptable = true;
        }

        if (isVowel(c) != isVowel(prev)) {
          cnt = 1;
        } else {
          cnt += 1;
        }

        if (cnt == 3 || (prev == c && c != 'e' && c != 'o')) {
          isAcceptable = false;
          break;
        }
        prev = c;
      }
      if (isAcceptable) {
        sb.append('<').append(s).append(acc);
      } else {
        sb.append('<').append(s).append(not);
      }
    }
    System.out.print(sb);
  }
}
