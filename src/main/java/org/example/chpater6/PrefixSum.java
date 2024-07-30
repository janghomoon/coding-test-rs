package org.example.chpater6;

import java.util.Scanner;

public class PrefixSum {
//N개의 수가 주어졌을때 I번째 수부터 J번까지 합을 구하는 프로그램 작성
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] arr = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      arr[i] = sc.nextInt();
    }

    int[] acc = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      acc[i] = acc[i - 1] + arr[i];
    }
    while (M-- > 0) {
      int i = sc.nextInt();
      int j = sc.nextInt();
      System.out.println(acc[j] - acc[i - 1]);
    }

  }
  //누적합 배열 사용시 원본 배열의 원소가 업데이트 된다면 이후 구간합 계싼을 위해 해당 원소부터의 누적합을 다시 계산해야 한다.
  //따라서 배열 원소 갱신 횟수 K가 크다면 누적합 배열을 사용하더라도 시간 복잡도가 개선되지 않을수 있다.

}
