package org.example.chapter4;

import java.util.Scanner;

public class NumberOfPalindromes {

  //풀이

  public static int[] convertBase(int x, int base) {

    int len = 0, copyX = x;
    while (copyX > 0) {
      copyX /= base;
      len++;
    }

    int[] digit = new int[len];
    len =0;
    while (x > 0) {
      digit[len++] = x% base;
      x = x/base;
    }

    return digit;


  }

  static boolean isPalindromeInBase(int[] digit) {
        for (int i = 0; i < digit.length / 2; i++)
      if (digit[i] != digit[digit.length - i - 1])
        return false;
    return true;
  }


  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int x = sc.nextInt();
      boolean ans = false;
      for (int i = 2; i <= 64; i++) {
        int[] digit = convertBase(x, i);
        if (isPalindromeInBase(digit)) {
          ans = true;
          break;
        }
      }
      System.out.println(ans ? 1 : 0);
    }
  }


  //내가 푼방식
  //회문인 수
  //앞 뒤로 읽어도 똑같은 숫자 문제
//  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//
//
//    //입력 T 테스틑 갯수
//    //각 테스트 데이터는 64 이상 1000000 이하인  하나의 정수로 주어진다.
//    //회문이 도리수 있다면 1 아니면0
//    int T = scanner.nextInt();
//    int[] targetArr = new int[T];
//    for (int idx = 0; idx < T; idx++) {
//      targetArr[idx] = scanner.nextInt();
//    }
//    int[] resultArr = new int[T];
//    for (int idx = 0; idx < targetArr.length; idx++) {
//      resultArr[idx] = 0;
//      if (isPalindrome(targetArr[idx])) {
//        resultArr[idx] = 1;
//      }
//    }
//    for (int idx=0; idx < resultArr.length; idx++) {
//      System.out.println(resultArr[idx]);
//    }
//  }
//
//  //convert
//  static String toTargetFormation(int number, int targetNumber) {//target number  B 진법
//    StringBuilder result = new StringBuilder();
//    if (number == 0 ) return "0";
//    while (number > 0) {
//      int share = number / targetNumber;//몫
//      int remainder = number % targetNumber;//나머지
//      // 만약 N이 10보다 큰 경우, N으로 나누었는데 10 이상이면 A, B등으로 표현하므로 기존 숫자는 10진법이므로 10만큼 빼고 'A'를 더한다.
//      // 왜냐면 1~9까지는 숫자로 표기하지만, 10 부터는 'A', 'B' 순서로 나타내기 때문이다.
//      // 나머지가 10이라면 'A' + 10이 아니라 'A'로 나타내야 하기 때문
//
//      if (remainder > 9) {
//        result.append((char) (remainder + 'A' - 10));
//      } else {
//        result.append(remainder);
//      }
//      number = share;
//    }
//    return result.toString();
//  }
//
//  static boolean isPalindrome(int target) {
//    //
//    boolean isTrue = false;
//    for (int idx =2; idx <= 64; idx++) {
//      String result = toTargetFormation(target, idx);
//      if (comparePalindrome(result)) {
//        isTrue =  true;
//        break;
//      }
//    }
//    return isTrue;
//  }
//
//  static boolean comparePalindrome(String result) {
//    char[] resultArr = result.toCharArray();
//    StringBuilder revertResult = new StringBuilder();
//    for(int idx = 0; idx < resultArr.length; idx++) {
//      revertResult.append(resultArr[idx]);
//    }
//    if (revertResult.toString().equals(result)) return true;
//    return false;
//  }

}
