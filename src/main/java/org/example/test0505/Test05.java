package org.example.test0505;

import java.io.*;
import java.util.*;
public class Test05 {
//  컨테이너 문제는
//  컨테이너 박스로 이루어진 건물이 올라가고 있습니다.
//  건물주는 최대한 높은 건물이 세워지도록 지시를 내렸습니다.
//  건축가는 안정감을 위해 위층에 이쓴ㄴ 컨테이너일수록 크기가 작아지게 설계하였습니다.
//  다지이너는 컨테이너에 페인츠 칠을 시작하는데 2가지 색상을 층마다 교차로 칠하는 방식으로 칠할 예정입니다.
//  위의 조건을 만족시키는 건물의 최대 층스로 구하는 프로그램을 작성하시오.
//  컨테이너의 정보는 0이 아닌 정수로 표현된다.
//  정수의 값이 음수면 흰색, 양수면 검은색의 페인트칠로 칠하는것을 나타낸다.
//  컨테이너의 크기는 정수의 절대값이다.
//  컨테이너 모두 다른크기를 가지고 있습니다.
//  첫줄에 컨테이너 박스 수 입력
//  각 컨테이너의 색상과 크기 입력  (0은 불가)
//  위의 조건을 만족시키는 건물의 최대층 수
//8
//    11
//    -9
//    2
//    5
//    18
//    17
//    -15
//    4
//  2025043033142321
//      2025043033749631
//      2025043044257011

  static int getMaxBuildingHeight(int[] arr, int n) {
    int[] dp = new int[n];
    int maxLen = 1;

    for (int i = 0; i < n; i++) {
      dp[i] = 1; // 최소 1층부터 시작
      for (int j = 0; j < i; j++) {
        // 조건 1: 색상이 교차해야 함
        // 조건 2: 절댓값이 감소해야 함
        if ((arr[i] * arr[j] < 0) && (Math.abs(arr[i]) < Math.abs(arr[j]))) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      maxLen = Math.max(maxLen, dp[i]);
    }

    return maxLen;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] containers = new int[n];

    for (int i = 0; i < n; i++) {
      containers[i] = Integer.parseInt(br.readLine());
    }

    int result = getMaxBuildingHeight(containers, n);
    System.out.println(result);
  }


}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;

//public class Main {
//
//  static int getMaxBuildingHeight(int[] arr, int n) {
//    int[] dp = new int[n];
//    int maxLen = 1;
//
//    for (int i = 0; i < n; i++) {
//      dp[i] = 1; // 최소 길이 1
//      for (int j = 0; j < i; j++) {
//        // 부호가 다르고, 절댓값이 작아짐
//        if ((arr[i] * arr[j] < 0) && (Math.abs(arr[i]) < Math.abs(arr[j]))) {
//          dp[i] = Math.max(dp[i], dp[j] + 1);
//        }
//      }
//      maxLen = Math.max(maxLen, dp[i]);
//    }
//
//    return maxLen;
//  }
//
//  public static void main(String[] args) throws IOException {
//    // 입력 처리
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int n = Integer.parseInt(br.readLine()); // 컨테이너 수
//    int[] containers = new int[n];
//
//    for (int i = 0; i < n; i++) {
//      containers[i] = Integer.parseInt(br.readLine());
//    }
//
//    int result = getMaxBuildingHeight(containers, n);
//    System.out.println(result);
//  }
//}
