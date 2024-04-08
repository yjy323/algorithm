package simulation;

import java.io.*;
import java.util.*;
public class BOJ_20920 {

  static class Word implements Comparable<Word>{
    String word;
    int len;
    int cnt;

    Word(String word, int len){
      this.word = word;
      this.len = len;
      this.cnt = 0;
    }

    @Override
    public int compareTo(Word o) {
      if (this.cnt != o.cnt){
        return Integer.compare(o.cnt, this.cnt);
      } else if (this.len != o.len){
        return Integer.compare(o.len, this.len);
      } else {
        return this.word.compareTo(o.word);
      }
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashMap<String, Word> words = new HashMap();
    for (int i = 0; i < n; i++) {
      String word = br.readLine();
      int len = word.length();
      if (len < m){
        continue;
      }

      if (!words.containsKey(word)){
        words.put(word, new Word(word, len));
      } else {
        words.get(word).cnt += 1;
      }
    }

    List<Word> wordList = new ArrayList<>(words.values());
    Collections.sort(wordList);
    for (Word w : wordList) {
      bw.write(w.word);
      bw.newLine();
    }
    bw.flush();
    br.close();
  }
}
