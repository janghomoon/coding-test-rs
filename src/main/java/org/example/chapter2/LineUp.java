package org.example.chapter2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LineUp {

  //줄 세우기 오름차순
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("src/main/java/org/example/file/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int cnt = 0;
    for (int i = 0; i < s.length; i++) {
      for (int j = 0; j < i; j++) {
        if (Integer.parseInt(s[j]) > Integer.parseInt(s[i])) {
          int curVal = Integer.parseInt(s[i]);
          for (int k = i; k > j; k--) {// 거꾸로
            s[k] = s[k - 1];
            cnt++;
          }
          s[j] = String.valueOf(curVal);
        }
      }

    }
    System.out.println(cnt);
  }
//  public static void main(String[] args) {
////    Sca
//    Scanner sc = new Scanner(System.in);
//    int P = sc.nextInt();
//
//    while (P-- > 0) {
//      int T = sc.nextInt();
//      int[] h = new int[20];
//
//
//      for (int i = 0; i < 20; i++)//20
//        h[i] = sc.nextInt();
//
//      int cnt = 0;
//      for (int i = 0; i < 20; i++) {
//
//        for (int j = 0; j < i; j++) {
//
//          if (h[j] > h[i]) {
//            int myH = h[i];
//
//            for (int k = i; k > j; k--) {
//              h[k] = h[k - 1];
//              cnt++;
//            }
//
//            h[j] = myH;
//            break;
//          }
//
//        }
//
//      }
//
//      System.out.println(T + " " + cnt);
//    }
//
//
//  }
}
