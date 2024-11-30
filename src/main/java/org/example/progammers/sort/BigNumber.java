package org.example.progammers.sort;

import java.util.Arrays;
import java.util.Comparator;

public class BigNumber {
  //가장 큰수
  public static void main(String[] args) {
    int[] numbers = {6,10 ,2};
    solution(numbers);

  }
  public static String solution(int[] numbers) {
    String[] strNums = new String[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      strNums[i] = String.valueOf(numbers[i]);
    }

    Arrays.sort(strNums, (a, b) -> {
      for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
        if (a.charAt(i) != b.charAt(i)) {
          return b.charAt(i) - a.charAt(i);
        }
      }
      return b.length() - a.length();
    });

    StringBuilder sb = new StringBuilder();
    for (String str : strNums) {
      sb.append(str);
    }

    return sb.toString();
  }

}
//import java.util.Arrays;
//import java.util.Comparator;

class Solution {
  public String solution(int[] numbers) {
    String[] strNums = new String[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      strNums[i] = String.valueOf(numbers[i]);
    }

    // 두 문자열을 이어붙였을 때 더 큰 값이 되는 문자열을 기준으로 내림차순 정렬
    Arrays.sort(strNums, new Comparator<String>() {
      @Override
      public int compare(String a, String b) {
        return (b + a).compareTo(a + b);
      }
    });

    // 0으로만 이루어진 경우 예외 처리
    if (strNums[0].equals("0")) {
      return "0";
    }

    // 정렬된 문자열을 이어붙여 결과 생성
    StringBuilder sb = new StringBuilder();
    for (String str : strNums) {
      sb.append(str);
    }

    return sb.toString();
  }
}
