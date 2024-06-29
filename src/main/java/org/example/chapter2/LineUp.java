package org.example.chapter2;

import java.util.Scanner;

public class LineUp {

  //줄 세우기 오름차순

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int P = sc.nextInt();

    while (P-- > 0) {
      int T = sc.nextInt();
      int[] h = new int[20];


      for (int i = 0; i < 20; i++)
        h[i] = sc.nextInt();

      int cnt = 0;
      for (int i = 0; i < 20; i++) {

        for (int j = 0; j < i; j++) {

          if (h[j] > h[i]) {
            int myH = h[i];

            for (int k = i; k > j; k--) {
              h[k] = h[k - 1];
              cnt++;
            }

            h[j] = myH;
            break;
          }

        }

      }

      System.out.println(T + " " + cnt);
    }


  }
}
