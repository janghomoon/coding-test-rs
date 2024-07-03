package org.example.chapter2and3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NumberSort {

  public static void main(String[] args) throws IOException {
    //백만단위 이상 버퍼드 리더
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(bufferedReader.readLine());
    int [] cnt = new int[10001];
    for(int i = 0; i< n; i++) {
      cnt[Integer.parseInt(bufferedReader.readLine())]++;
    }
    for(int i = 1; i< 10001; i++) {
      while (cnt[i] --> 0) {
        bufferedWriter.write(i + "\n");
      }
    }
    bufferedWriter.flush();
  }
}
