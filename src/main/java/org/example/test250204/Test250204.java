package org.example.test250204;

import java.util.Scanner;

public class Test250204 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt(); // n 입력받기
    scanner.close();
    solution(n);
  }

  public static int solution(int n) {

    long left = 1, right = n;
    while (left < right) {
      long mid = left + (right - left) / 2;
      if (countDigits(mid) < n) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    // left가 원하는 숫자임
    String numberStr = Long.toString(left);
    long digitIndex = n - countDigits(left - 1) - 1;
    System.out.println(numberStr.charAt((int) digitIndex));
    int result = numberStr.charAt((int) digitIndex);
    return result;
  }
    // 1부터 num까지의 숫자 개수 합을 구하는 함수
  //
    private static long countDigits(long num) {
      long count = 0, length = 1, start = 1;
      while (start <= num) {
        long end = Math.min(num, start * 10 - 1);
        count += (end - start + 1) * length;
        length++;
        start *= 10;
      }
      return count;
    }

//  //문제 설명  1부터 자연수를 이어쓰면 1234567891011121314
//  public static void  solution(int n) {
//    long digitLength = 1;  // 현재 자리수 (1자리부터 시작)
//    long count = 9;        // 해당 자리수에서 총 숫자 개수
//    long start = 1;        // 현재 자리수의 시작 숫자
//
//
//    //
//
//    while (n > digitLength * count) {
//      n -= digitLength * count; // 현재 자리수의 총 길이를 빼줌
//      digitLength++;             // 자리수를 증가
//      count *= 10;                // 숫자 개수 증가 (9 → 90 → 900 ...)
//      start *= 10;                // 시작 숫자 증가 (1 → 10 → 100 ...)
//    }
//    // n이 속한 숫자 찾기
//    long targetNumber = start + (n - 1) / digitLength;
//    int targetIndex = (int) ((n - 1) % digitLength);
//    char result = String.valueOf(targetNumber).charAt(targetIndex);
//
//
//    System.out.println(result);
//  }

}
