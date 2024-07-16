package org.example.chapter5;

import java.util.Arrays;
import java.util.Scanner;

public class SortByAge {
  //나이가 증가하는 순
  //나이가 같으면 먼저 가입한 사람이 앞에 오는 순서 (가입 순서)
  //온라인 회원수 N
  //
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();

    Member[] members = new Member[N];
    for (int i =0; i< members.length; i++) {
      members[i] = new Member(scanner.nextInt(), scanner.next(), i);
    }

    Arrays.sort(members);
    //sort rㅜ현체 통해서도 가능
    for (Member member: members) {
      System.out.println(member.age + " " + member.name);
    }
  }
// Comparable 인터페이스 구현을 위한 compareTo() 메소드는 아래 결과를 기대하며 사용됩니다.
// 이때 비교 대상 객체가 파라미터로 전달받은 o입니다.
// 1. 현재 객체와 비교 대상 객체가 같은 경우, 반환 값은 0입니다.
// 2. 현재 객체가 비교 대상 객체보다 작은 경우 (즉, 정렬 순서에서 앞에 위치하는 경우), 반환 값은 음수입니다.
// 3. 현재 객체가 비교 대상 객체보다 큰 경우 (즉, 정렬 순서에서 뒤에 위치하는 경우), 반환 값은 양수입니다.

}

class Member implements Comparable<Member> {
  int age;
  String name;
  int index;

  Member(int age, String name, int index) {
    this.age = age;
    this.name = name;
    this.index = index;
  }

  @Override
  public int compareTo(Member o) {
    if (age != o.age) {//dㅗ름 차순
      return age - o.age;
    }
    return index - o.index;//오름차순
  }
}