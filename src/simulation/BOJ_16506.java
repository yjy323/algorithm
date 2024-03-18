package simulation;

import java.util.*;
import java.io.*;

public class BOJ_16506 {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuffer sb = new StringBuffer();


    HashMap opcodeMap = new HashMap<String, String>();
    final String[] opcodeList = {"ADD", "ADDC", "SUB", "SUBC", "MOV", "MOVC", "AND", "ANDC", "OR", "ORC",
        "NOT", "MULT", "MULTC", "LSFTL", "LSFTLC", "LSFTR", "LSFTRC", "ASFTR", "ASFTRC", "RL", "RLC", "RR",
        "RRC"};

    int bit = 0;
    for (int i = 0 ; i < opcodeList.length; i++){
      opcodeMap.put(opcodeList[i], String.format("%05d", Integer.parseInt(Integer.toBinaryString(bit))));
      if (opcodeList[i].equals("NOT")){
        ++bit;
      }
      ++bit;
    }

    int n = Integer.parseInt(bf.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(bf.readLine());
      String opcode = st.nextToken();
      int rD = Integer.parseInt(st.nextToken());
      int rA = Integer.parseInt(st.nextToken());
      int rBC = Integer.parseInt(st.nextToken());

      sb.append(opcodeMap.get(opcode));
      sb.append("0");
      sb.append(String.format("%03d", Integer.parseInt(Integer.toBinaryString(rD))));
      sb.append(String.format("%03d", Integer.parseInt(Integer.toBinaryString(rA))));
      if (opcodeMap.get(opcode).toString().charAt(4) == '0'){
        sb.append(String.format("%03d", Integer.parseInt(Integer.toBinaryString(rBC))) + "0");
      } else {
        sb.append(String.format("%04d", Integer.parseInt(Integer.toBinaryString(rBC))));
      }
      sb.append("\n");
    }
    System.out.print(sb);
    bf.close();
  }
}