package org.example.chapter4;

import java.util.Scanner;

public class ACMHotel {
  //시뮬레이션
  //
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    while (T-- > 0) {
      int H = scanner.nextInt();
      int W = scanner.nextInt();
      int N = scanner.nextInt();
      int distance = (N-1) / H +1;
      int floor = (N-1) % H +1;

      System.out.printf("%d%02d\n", floor, distance);

    }

  }

}
