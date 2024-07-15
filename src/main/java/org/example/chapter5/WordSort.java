package org.example.chapter5;

import java.util.Arrays;
import java.util.Scanner;

public class WordSort {

  //N 개의 단어
  //길이가 짧은 것 부터
  //길이가 같으면 사전 순으로
  //중복은 제거
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    String[] words = new String[N];
    for (int i = 0; i < N; i++) {
      words[i] = scanner.next();
    }


    Arrays.sort(words, (o1, o2) -> {
      if (o1.length() == o2.length()) return o1.compareTo(o2);//o2가 사전 순 빠른 지 비교
      return o1.length() - o2.length();
    });
    System.out.println(words[0]);
    for (int i = 1; i <N; i++) {
      if(!words[i].equals(words[i-1])) {
        System.out.println(words[i]);
      }
    }

  }
}
//sort 오름차순

//  Java String 클래스는 '-'연산자를 따로 지원하지 않습니다. (java: bad operand types for binary operator '-')
//    만약 '-' 연산이 지원되는 타입에 대한 정렬이라면 일반적으로 `o1- o2`
//    연산 결과를 리턴하면 오름차순이 됩니다. String의 compareTo 메소드는
//    두 문자열의 사전순으로 비교하며 a.compareTo(b) 의 값에 따라 아래와 같이 정의됩니다.
//    1. a와 b가 동일한 문자열인 경우, 결과는 0입니다.
//    2. a가 b보다 사전순으로 앞선 경우, 결과는 음수입니다.
//    3. a가 b보다 사전순으로 뒤따르는 경우, 결과는 양수입니다.
