package org.example.chpater6;

import java.util.Scanner;

public class GenericQueries {
// 관영이는 쿼리를 좋아하고, XOR도 좋아한다. 그래서 관영이는 XOR을 이용한 쿼리 문제를 좋아한다.
//
//길이가
//$N$인 수열
//$a_1 , a_2 , \cdots a_N$이 있다.
//
//이제 관영이는
//$Q$개의 쿼리에 답하려 한다. 각 쿼리는
//$s_i , e_i$ (
//$1 \le s_i \le e_i \le N$)의 형태로 들어오고, 그 쿼리의 답은
//$a_{s_i}, a_{s_i+1}, \cdots a_{e_i}$을 모두 XOR한 값이다.
//
// 
//$Q$개의 쿼리가 들어올 때, 각 쿼리의 답을 모두 XOR한 결과를 구하시오.

//  첫째 줄에는
//  $N, Q$가 공백을 사이에 두고 주어진다. (
//  $1 \le N \le 10^6$,
//  $1 \le Q \le 3 \cdot 10^6$)
//
//  둘째 줄에는
//  $a_1, a_2, \cdots a_N$이 공백을 사이에 두고 주어진다. (
//  $0 \le a_i \le 10^9$)
//
//  그 후,
//  $Q$개의 줄에 걸쳐서, 각 줄마다 하나의 쿼리
//  $s_i, e_i$가 공백을 사이에 두고 주어진다. (
//  $1 \le s_i \le e_i \le N$)

  //제네릭 쿼리즈

//  XOR 계싼  0 ^ 0 = 0
//  0 ^1 = 1
//  1^ 0 = 1
//  1^1 = 0
  //길이가 N 인 수열이 주얼질 때   개의 쿼리 ( S,e) 에 대해 S 번째 원소부터 e번 원소까지 XOR 한 값을 구하라
  //2진수로
  //구간합 연산 뿐만아니라 l,r 구간의 ㅇ녀산 결과를 구하기 위해 1,r 연산  1,l-1 구간의 연산
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int Q = scanner.nextInt();
    int [] arr = new int[N+1];

    for (int i = 1; i <=N; i++) {
      arr[i] = scanner.nextInt();
    }

    //1 누적 ㅇXOR 배열 구함
    int [] acc = new int[N+1];
    for (int i = 1; i <=N; i++) {
      acc[i] = acc[i-1]^arr[i];
    }
    //Q번 [S: E] 질문에 대해 누적XOR 배열을 사용해 구간 XOR 구함
    int ans = 0;
    while(Q-- > 0) {
      int i = scanner.nextInt();
      int j = scanner.nextInt();
      ans ^= acc[j] ^ acc[i-1];
    }
    System.out.println(ans);
  }

}
