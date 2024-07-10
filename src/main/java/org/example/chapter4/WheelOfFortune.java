package org.example.chapter4;

import java.util.Arrays;
import java.util.Scanner;

public class WheelOfFortune {


  //1. 바퀴의 커서 인덱스를 S만큼 움직인다.
  //1-0. 커서 인덱스가 배열 범위를 넘어갔다면 조정한다.
  //1-1. 도착한 칸이 아직 알아내지 못한 글자라면 기록한다
  //추가 글자가 다른 칸에 기록된 글자라면 바퀴는 존재하지 않는다 (!)
  //1-2. 도착한 칸의 글자가 적힌 글자와 다르다면 바퀴는 존재하지 않는다.
  //1-3. 도착한 칸의 글자가 적힌 글자와 같다면 넘어간다.
  //2. 바퀴에 출력된 글자를 마지막으로 도착한 글자부터 출력한다.
  //*바퀴에 같은 글자는 두 번 이상 등장하지 않는다.
  //*바퀴는 시계방향으로만 돌아간다.
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    char[] wheel = new char[N];
    Arrays.fill(wheel, '?');
    int curIndex = 0;
    while (K-- > 0) {
      int step = sc.nextInt();
      char nextAlphabet = sc.next().charAt(0);
      int nextIndex = ((curIndex -step) % N +N) % N;
      if(wheel[nextIndex] == '?') wheel[nextIndex] = nextAlphabet;
      else if (wheel[nextIndex] != nextAlphabet) {
        System.out.println("!");
        return;
      }
      curIndex = nextIndex;



    }
    boolean[] isUsed = new boolean[26];//알파벳 갯수
    for( int i=0; i<N; i++) {
      if (wheel[i] == '?') continue;
      if (isUsed[wheel[i]-'A']) {
        System.out.println("!");
        return;
      }
      isUsed[wheel[i]-'A'] = true;
    }
    for (int i = 0; i< N; i++) {
      System.out.print(wheel[(curIndex+i) % N]);
    }

  }



}
