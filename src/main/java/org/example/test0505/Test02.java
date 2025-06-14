package org.example.test0505;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test02 {
  //점심은 햄버거
  static class Buger {
    int heatTime;
    int eatTime;
    Buger(int heatTime, int eatTime) {
      this.heatTime = heatTime;
      this.eatTime = eatTime;
    }
  }

  static long calculateTime(Buger[] bugerArr, int n) {
    Arrays.sort(bugerArr, (a, b) -> {
      if (b.eatTime != a.eatTime) {
        return Integer.compare(b.eatTime, a.eatTime);
      } else {
        return Integer.compare(a.heatTime, b.heatTime);
      }
    });

    int currentTime = 0;
    long maxTime = 0;

    for (int i = 0; i< n; i++) {
      currentTime += bugerArr[i].heatTime;
      long finishTime = currentTime + bugerArr[i].eatTime;
      maxTime = Math.max(maxTime, finishTime);
    }
    return maxTime;

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();
    int n = Integer.parseInt(input.trim());

    input = br.readLine();
    String[] eatTimeArr = input.split(" ");

    input = br.readLine();
    String[] heatTimeArr = input.split(" ");

    Buger[] bugerArr = new Buger[n];
    for (int i= 0; i < n; i++) {
      int eatTime = Integer.parseInt(eatTimeArr[i]);
      int heatTime = Integer.parseInt(heatTimeArr[i]);
      bugerArr[i] = new Buger(heatTime, eatTime);
    }



    System.out.println(calculateTime(bugerArr, n));
    br.close();
  }
}
