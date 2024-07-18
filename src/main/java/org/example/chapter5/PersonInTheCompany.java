package org.example.chapter5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PersonInTheCompany {

  //
////  Entry register
//  public class EntryRegister {
//
//  }
  //1 이름 순서에 따라 출입기록을 차례로 정렬
  //2 각 사원마다 마지막 기록이 enter 인지 확인
  //2-1 마자막 기록이 enter라면 출력
  public static void main(String[] args)  {// throws FileNotFoundException
//    System.setIn(new FileInputStream("src/main/java/org/example/file/input.txt"));
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    String[][] records = new String[N][2];
    for (int i = 0; i < N; i++) {
      records[i][0] = scanner.next();
      records[i][1] = scanner.next();

    }
    //역순 출력
    //처음부터 역순 정렬
    Arrays.sort(records, new Comparator<String[]>() {
      @Override
      public int compare(String[] o1, String[] o2) {
        return o2[0].compareTo(o1[0]);
      }
    });
    for (int i = 0; i < N-1; i++) {
      if (records[i][1].equals("enter") && !records[i][0].equals(records[i+1][0])) {
        System.out.println(records[i][0]);
      }
    }
    //N-2 번 인덱스까지 완료



    //N-1 처리 필요!

    if (records[N-1][1].equals("enter")) {
      System.out.println(records[N-1][0]);
    }

//    Set<String> setString = new HashSet<>();
    //역순 출력
    //treeset 사용시 이름에대한 정렬 가능
    //엔터이면 add 없으면 remove
    //HashSet 해시 테이블을 기반으로 한 unordered Collection  삽입 /삭제 / 조회 연산 O(1) 기대  null 저장 가능
    //TreeSet Binary Search Tree를 기반으로 한 ordered Collection 삽입/삭제/조회 연산: O(log(size))
    //null 저장 불가
  }

  //

  //2번 방법  삽입 삭제 연산이 빠른 집합 자료구조
  //자바 유틸 set 이용하여 중복 없이 사용 가능

  public void enteredList() {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    Set<String> entered = new TreeSet<>();
    for (int i = 0; i < N; i++) {
      String name = scanner.next();
      String status = scanner.next();
      if (status.equals("enter")) entered.add(name);
      else entered.remove(name);
    }
    String[] ordered = entered.toArray(new String[entered.size()]);

    for (int i = ordered.length-1; i >= 0; i--) {
      System.out.println(ordered[i]);
    }

  }



}
