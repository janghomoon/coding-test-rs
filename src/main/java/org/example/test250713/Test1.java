package org.example.test250713;
import java.util.*;
import java.util.Scanner;

public class Test1 {
  //문자열 s에는 \알파벳 중
  public static int solution(String s) {
    int n = s.length();
    int count = 0;

    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == 'a' || s.charAt(i) == 'z') {
        for (int j = i + 1; j < n; j++) {
          if ((s.charAt(i) == 'a' && s.charAt(j) == 'z') || (s.charAt(i) == 'z' && s.charAt(j) == 'a')) {
            boolean valid = true;
            for (int k = i + 1; k < j; k++) {
              if (s.charAt(k) == 'a' || s.charAt(k) == 'z') {
                valid = false;
                break;
              }
            }
            if (valid) {
              count++;
            }
          }
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(solution("abcz"));        // 1
    System.out.println(solution("zabzczxa"));    // 3
    System.out.println(solution("abcd"));        // 0
  }



}
//
//import java.util.Scanner;
//
//public class SelectRangeCount {
//  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    String s = sc.nextLine();
//    System.out.println(countValidRanges(s));
//  }
//
//  public static int countValidRanges(String s) {
//    int n = s.length();
//    int count = 0;
//
//    for (int i = 0; i < n; i++) {
//      boolean[] visited = new boolean[26];
//      char minChar = s.charAt(i);
//      char maxChar = s.charAt(i);
//      visited[s.charAt(i) - 'a'] = true;
//
//      for (int j = i + 1; j < n; j++) {
//        char c = s.charAt(j);
//
//        // 중복 문자 체크
//        if (visited[c - 'a']) break;
//        visited[c - 'a'] = true;
//
//        if (c < minChar) minChar = c;
//        if (c > maxChar) maxChar = c;
//
//        int expectedLength = maxChar - minChar + 1;
//        int actualLength = j - i + 1;
//
//        if (expectedLength == actualLength) {
//          count++;
//        }
//      }
//    }
//    return count;
//  }
//}


//import java.util.Scanner;
//
//public class SelectRangeCount {
//  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    String s = sc.nextLine();
//    System.out.println(countValidWays(s));
//  }

//  public static int countValidWays(String s) {
//    int n = s.length();
//    int result = 0;
//
//    for (int i = 0; i < n; i++) {
//      for (int j = i + 1; j < n; j++) {
//        char startChar = s.charAt(i);
//        char endChar = s.charAt(j);
//
//        if (startChar == endChar) continue;
//
//        char minChar = (char) Math.min(startChar, endChar);
//        char maxChar = (char) Math.max(startChar, endChar);
//
//        if (isValidRange(s, i, j, minChar, maxChar)) {
//          result++;
//        }
//      }
//    }
//    return result;
//  }
//
//  private static boolean isValidRange(String s, int i, int j, char minChar, char maxChar) {
//    boolean[] seen = new boolean[26];
//
//    for (int k = i; k <= j; k++) {
//      char c = s.charAt(k);
//
//      // 범위 밖 알파벳 있으면 안 됨
//      if (c < minChar || c > maxChar) return false;
//
//      // 중복 알파벳 있으면 안 됨
//      if (seen[c - 'a']) return false;
//      seen[c - 'a'] = true;
//    }
//
//    // 모든 알파벳이 연속인지 확인
//    for (char c = minChar; c <= maxChar; c++) {
//      if (!seen[c - 'a']) return false;
//    }
//
//    return true;
//  }
//}

//import java.util.*;
//
//public class Solution {
//  public static int solution(String s) {
//    int n = s.length();
//    List<Integer> aPositions = new ArrayList<>();
//    List<Integer> zPositions = new ArrayList<>();
//
//    // 'a'와 'z' 위치 저장
//    for (int i = 0; i < n; i++) {
//      if (s.charAt(i) == 'a') {
//        aPositions.add(i);
//      } else if (s.charAt(i) == 'z') {
//        zPositions.add(i);
//      }
//    }
//
//    if (aPositions.isEmpty() || zPositions.isEmpty()) {
//      return 0;
//    }
//
//    Set<Integer> azPositions = new HashSet<>();
//    azPositions.addAll(aPositions);
//    azPositions.addAll(zPositions);
//
//    int count = 0;
//
//    // a와 z쌍 만들기
//    for (int aPos : aPositions) {
//      for (int zPos : zPositions) {
//        if (aPos < zPos) {
//          boolean valid = true;
//          for (int pos : azPositions) {
//            if (pos > aPos && pos < zPos) {
//              valid = false;
//              break;
//            }
//          }
//          if (valid) {
//            count++;
//          }
//        }
//      }
//    }
//
//    return count;
//  }
//
//  public static void main(String[] args) {
//    System.out.println(solution("abcz"));        // 1
//    System.out.println(solution("zabzczxa"));    // 3
//    System.out.println(solution("abcd"));        // 0
//  }
//}



