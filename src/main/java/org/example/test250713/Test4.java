package org.example.test250713;
import java.util.*;
public class Test4 {
  //
  public static String solution(String compressed) {
    Stack<String> stack = new Stack<>();

    for (int i = 0; i < compressed.length(); i++) {
      char c = compressed.charAt(i);

      if (c == ')') {
        // 문자열 빼기
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && !stack.peek().equals("(")) {
          sb.insert(0, stack.pop());
        }

        // '(' 제거
        if (!stack.isEmpty() && stack.peek().equals("(")) {
          stack.pop();
        }

        // 숫자 찾기
        StringBuilder num = new StringBuilder();
        while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
          num.insert(0, stack.pop());
        }

        int count = Integer.parseInt(num.toString());
        String expanded = sb.toString().repeat(count);
        stack.push(expanded);
      } else {
        stack.push(String.valueOf(c));
      }
    }

    // 결과 조합
    StringBuilder result = new StringBuilder();
    for (String s : stack) {
      result.append(s);
    }

    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(solution("3(hi)"));                          // hhihihi
    System.out.println(solution("2(3(hi)co)"));                     // hihihicohihihico
    System.out.println(solution("10(p)"));                          // pppppppppp
    System.out.println(solution("2(2(hi)2(co))2(x2(bo))"));         // hhicocohhicocoxbooxboo
  }
}
