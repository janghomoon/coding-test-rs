package org.example.chapter2;

import java.util.Scanner;

public class GuardTheCastle {
  //성지키기
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    char[][] map = new char[n][m];
    for (int idx = 0; idx < n; idx++) {
      map[idx] = scanner.next().toCharArray();
    }
    //각 행/열 에 대해 경비원이 있는지 확인
    int existRowCount = 0;
    for (int idx = 0; idx < n; idx++) {
      boolean isExist = false;
      for (int i = 0; i< m; i++) {
        if (map[idx][i] == 'X') {
          isExist = true;
          break;
        }
      }
      if (isExist) existRowCount++;
    }

    int existColCount = 0;
    for (int idx =0; idx < m; idx++) {
      boolean isExist = false;
      for(int i = 0; i < n; i++ ) {
        if (map[n][m] == 'X') {
          isExist = true;
          break;
        }
      }
      if (isExist) existColCount++;
    }

    //보호받지 못한 행 열 개수 구함
    int needRowCount = 0;
    needRowCount = n - existRowCount;
    int needColCount = 0;
    needColCount = m - existColCount;
    //둘중 큰 값 출력
    System.out.println(Math.max(needRowCount, needColCount));
  }

  //
//  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    int height = scanner.nextInt();
//    int width = scanner.nextInt();
//    int count = 0;
//    String [][] inputArray = new String[height][width];//맞나?
//    for (int idx = 0; idx < height; idx++) {
//      for(int i = 0; i < inputArray[idx].length; i++) {
//        inputArray[idx][i] = scanner.next();
//      }
//    }
//
//    boolean [][] outputArray = new boolean[height][width];
//    for (int idx = 0; idx < height; idx++) {
//      for(int i = 0; i < inputArray[idx].length; i++) {
//        if(!inputArray[idx][i].equals("X")) outputArray[idx][i] = false;
//      }
//    }
//    for (int idx = 0; idx < height; idx++) {
//      for (int idx = 0; idx < height; idx++) {
//        inputArray[idx][WidthCnt];
//      }
//
//    }
//
//    for (int idx = 0; idx < height; idx++) {
//      for(int i = 0; i < inputArray[idx].length; i++) {
//        if(!inputArray[idx][i].equals("X")) outputArray[idx][i] = false;
//      }
//
//    }
//
//
////    for (int idx =0; idx < inputArray.length; idx++) {
////      if(!inputArray[idx].contains("X")) count++;
////    }
//    System.out.println(count);
//  }

 public static void t() {
   Scanner scanner = new Scanner(System.in);
   int n = scanner.nextInt();
   int m = scanner.nextInt();
   char[][] map = new char[n][m];
   for (int idx = 0; idx < n; idx++) {
     map[idx] = scanner.next().toCharArray();
   }
   boolean [] existRowArr = new boolean[n];
   boolean [] existColArr = new boolean[m];
   for (int idx = 0; idx < n; idx++) {
     for (int i = 0; i< m; i++) {
        if (map[idx][i] == 'X') {
          existRowArr[idx] = true;
          existColArr[i] = true;
        }
     }
   }

   int needRowCount = n;
   int needColCount = m;
   for (int idx = 0; idx < n; idx ++) {
     if (existRowArr[idx]) needRowCount --;
   }
   for (int idx = 0; idx < m; idx ++) {
     if (existColArr[idx]) needColCount --;
   }

   //둘중 큰 값 출력
   System.out.println(Math.max(needRowCount, needColCount));
 }


}
