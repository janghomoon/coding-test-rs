package org.example.chapter5;

import java.util.Arrays;
import java.util.Scanner;

public class BestSeller {

  //팔린 책의 수 N 1000 이하
  //책의 제목 길이 50 이하 (알파벳 소문자)
  //가장많이 팔린 책의 제목 출력, 여러개 일 경우 사전순으로 가장 앞서는 제목 출력
  //map 으로 해결
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    String[] titles = new String[N];
    for (int i = 0; i < N; i++) {
      titles[i] = scanner.next();
    }

    Arrays.sort(titles);//사전순 정렬 defualt
    String maxTitle = titles[0];
    int maxCount = 1;
    int currentCount = 1;
    for (int i = 1; i<N; i++) {
      if(!titles[i].equals(titles[i-1])) {
        currentCount = 0;
      }
      currentCount++;
      if (currentCount > maxCount ||
          (currentCount == maxCount && titles[i].compareTo(maxTitle) < 0)
      ) {

        maxTitle = titles[i];
        maxCount = currentCount;
      }
    }
    System.out.println(maxTitle);

  }

  //HashMap
  //해시 테이블 기반 unordered Colleciton
  // 삽입 /삭제 / 조회 연산 : O(1)
//  null 저장 기능
  // key의 순서가 보장되지 않음


  //TreeMap
  //Binary Search Tree를 기반으로 한 ordered Coleection
  // 삽입/삭제/조회 연산:  O(logn(size))
  //null 저장불가
  //key 순서 보장(숫자 오름 차순, string 사전순 빠른)

}
