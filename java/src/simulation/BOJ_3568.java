package simulation;

import java.util.*;

public class BOJ_3568 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String variables[] = sc.nextLine().replaceAll("[,;]", "").split(" ");

    StringBuffer sb = new StringBuffer();
    for (int i = 1; i < variables.length; i++) {
      sb.append(variables[0]);
      for (int j = variables[i].length() - 1; j >= 0; j--) {
        char c = variables[i].charAt(j);
        if (c == '&' || c == '*') {
          sb.append(c);
        } else if (c == '[') {
          sb.append(']');
        } else if (c == ']') {
          sb.append('[');
        } else {
          sb.append(" " + variables[i].substring(0, j + 1));
          break;
        }
      }
      sb.append(";\n");
    }

    System.out.print(sb);
  }
}
