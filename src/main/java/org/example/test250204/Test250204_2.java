package org.example.test250204;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test250204_2 {
//  public static void main(String[] args) {
//    // 예제 입력
//    String[] arr1 = {"()", "(()", ")()", "()"};
//    String[] arr2 = {")()", "()", "(()"};
//
//    // 결과 출력
//    System.out.println(countValidPairs(arr1, arr2)); // Expected output: 3
//  }
//
//  public static int countValidPairs(String[] arr1, String[] arr2) {
//    int count = 0;
//
//    // 모든 arr1과 arr2 조합을 확인
//    for (String s1 : arr1) {
//      for (String s2 : arr2) {
//        String combined = s1 + s2; // 두 문자열을 연결
//        if (isValidParentheses(combined)) { // 유효한 괄호 문자열인지 확인
//          count++;
//        }
//      }
//    }
//
//    return count;
//  }
//
//  // 스택을 이용한 올바른 괄호 문자열 체크
//  public static boolean isValidParentheses(String s) {
//    Stack<Character> stack = new Stack<>();
//    for (char ch : s.toCharArray()) {
//      if (ch == '(') {
//        stack.push(ch);
//      } else {
//        if (stack.isEmpty()) return false;
//        stack.pop();
//      }
//    }
//    return stack.isEmpty(); // 스택이 비어있으면 유효한 괄호 문자열
//  }
public static void main(String[] args) {
  // 예제 입력
  String[] arr1 = {"()", "(()", ")()", "()"};
  String[] arr2 = {")()", "()", "(()"};

  // 결과 출력
  System.out.println(countValidPairs(arr1, arr2)); // Expected output: 3
}

  public static int countValidPairs(String[] arr1, String[] arr2) {
    Map<String, Integer> balanceMap = new HashMap<>();
    int count = 0;

    // 1️⃣ arr1의 괄호 균형 정보 저장
    for (String s : arr1) {
      int[] balance = getBalance(s);
      String key = balance[0] + "," + balance[1]; // (left, right) 형태
      balanceMap.put(key, balanceMap.getOrDefault(key, 0) + 1);
    }

    // 2️⃣ arr2에서 필요한 조합을 찾아서 매칭 (한 번 매칭된 조합을 제거)
    for (String s : arr2) {
      int[] balance = getBalance(s);
      String neededKey = balance[1] + "," + balance[0]; // 반대되는 균형 찾기

      if (balanceMap.getOrDefault(neededKey, 0) > 0) {
        count++;
        balanceMap.put(neededKey, balanceMap.get(neededKey) - 1); // 한 번 사용하면 줄이기
      }
    }

    return count;
  }

  // 괄호 문자열에서 필요한 왼쪽, 오른쪽 괄호 개수 계산
  private static int[] getBalance(String s) {
    int left = 0, right = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '(') {
        left++;
      } else {
        if (left > 0) left--; // 짝 맞추기
        else right++; // 닫는 괄호가 많음
      }
    }
    return new int[]{left, right};
  }

}
