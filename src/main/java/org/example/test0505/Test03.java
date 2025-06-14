package org.example.test0505;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test03 {
  //[템플릿]예약정보 테이블 만들기

  static int getCyclength(int n) {
    int length = 1;
    while( n != 1) {
      if (n%2 ==0) {
        n /=2;
      } else {
        n = 3*n + 1;
      }
      length++;
    }


    return length;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String[] inputArr = input.split(" ");
    int n = Integer.parseInt(inputArr[0]);
    int m = Integer.parseInt(inputArr[1]);
    int maxCycle = 0;

    for (int i = n; i<=m; i++) {
      int cyclelength = getCyclength(i);
      if (cyclelength > maxCycle) {
        maxCycle = cyclelength;
      }
    }

    System.out.println(maxCycle);
    br.close();
  }
}
