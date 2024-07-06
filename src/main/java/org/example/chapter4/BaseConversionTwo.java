package org.example.chapter4;

import java.util.Arrays;
import java.util.Scanner;

public class BaseConversionTwo {

  public static void main(String[] args) {
    //10진수 N
    //B 진법  진법의 수를 넘어가는 경우 알파벳 대문자 사용
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    int targetNumber = scanner.nextInt();
    String result = toTargetFormation(number, targetNumber);
    System.out.println(toSort(result));
  }

  static String toSort(String result) {
    char[] resultArray = result.toCharArray();
    StringBuilder sortResult = new StringBuilder();
    for (int idx = resultArray.length-1; idx >= 0; idx--) {
      sortResult.append(resultArray[idx]);
    }
//    Arrays.sort(resultArray);
//    StringBuilder sortResult = new StringBuilder();
//    for (int idx =0; idx < resultArray.length; idx++) {
//      sortResult.append(resultArray[idx]);
//    }
    return sortResult.toString();
  }
  static String toTargetFormation(int number, int targetNumber) {//target number  B 진법
     StringBuilder result = new StringBuilder();
     if (number == 0 ) return "0";
     while (number > 0) {
       int share = number / targetNumber;//몫
       int remainder = number % targetNumber;//나머지
       // 만약 N이 10보다 큰 경우, N으로 나누었는데 10 이상이면 A, B등으로 표현하므로 기존 숫자는 10진법이므로 10만큼 빼고 'A'를 더한다.
       // 왜냐면 1~9까지는 숫자로 표기하지만, 10 부터는 'A', 'B' 순서로 나타내기 때문이다.
       // 나머지가 10이라면 'A' + 10이 아니라 'A'로 나타내야 하기 때문

       if (remainder > 9) {
         result.append((char) (remainder + 'A' - 10));
       } else {
         result.append(remainder);
       }
       number = share;
     }
    return result.toString();
  }
  //10진수 주어 질때 B 진법으로 바꿔 출력하라
  //N을 B진법으로 나타냈을때 가장 큰 자릿수의 지수 K를 찾는다.
  //N에 들어갈 수 있는 b항의 자릭밧을 k를 구한다.
  //다음  자릿수의 표헌 범위를 넘는 부분을 제외 하고 2로 돌아가 다음 자릿구 구한다.



}
