package org.example.test250713;

public class Test3 {
  public static int solution(String phone_number) {
    // 정규식 기반으로 각 유형 확인
    String pattern1 = "^010-\\d{4}-\\d{4}$";       // 유형 1
    String pattern2 = "^010\\d{8}$";               // 유형 2
    String pattern3 = "^\\+82-10-\\d{4}-\\d{4}$";  // 유형 3

    if (phone_number.matches(pattern1)) {
      return 1;
    } else if (phone_number.matches(pattern2)) {
      return 2;
    } else if (phone_number.matches(pattern3)) {
      return 3;
    } else {
      return -1;
    }
  }

  public static void main(String[] args) {
    System.out.println(solution("01012345678"));       // 2
    System.out.println(solution("010-1212-333"));      // -1
    System.out.println(solution("+82-10-3434-2323"));  // 3
    System.out.println(solution("+82-010-3434-2323")); // -1
    System.out.println(solution("010-1234-5678"));      // 1
  }
}
