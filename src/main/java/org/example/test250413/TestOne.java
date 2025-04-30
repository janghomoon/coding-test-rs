package org.example.test250413;

public class TestOne {
  public static void main(String[] args) {
    String aaaa ="123_123_123";
    solution(aaaa);
  }

  public static boolean solution(String S) {
    // Implement your solution here
    if (S.length() < 9 || S.length() > 30) {
      return false;
    }

    for (char c : S.toCharArray()) {
      if (!Character.isDigit(c) && c != '-') {
        return false;
      }
    }
    int hyphenCount = 0;
    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == '-') {
        hyphenCount++;
        if (i == 0 || i == S.length() - 1) {
          return false;
        }
        if (i > 0 && S.charAt(i - 1) == '-') {
          return false;
        }
      }
    }

    if (hyphenCount != 2 && hyphenCount != 3) {
      return false;
    }

    String[] parts = S.split("-");
    for (String part : parts) {
      if (part.length() != 3 && part.length() != 2) {
        return false;
      }
    }

    if (hyphenCount == 3 && parts[3].length() != 2) {
      return false;
    }

    return true;

  }

}
