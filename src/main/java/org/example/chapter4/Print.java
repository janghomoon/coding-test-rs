package org.example.chapter4;

import java.util.Scanner;

public class Print {
  //판화문제
  //무시되는 명령 포함 XX
  //N 행 열
  //U 위
  //D 왼쪽
  //이동은 L
  //오른쪽은 R

  //문자열 최대 250
  //로봇팔이 지나지 않은 곳은.  수직과 수평 모두로 지난 점은 + 로 표기

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String command = sc.hasNext() ? sc.next() : "";

    boolean[][] passVertical = new boolean[N][N];
    boolean[][] passHorizontal = new boolean[N][N];

    int curR = 0, curC = 0;
    for (int i = 0; i < command.length(); i++) {
      char cmd = command.charAt(i);
      if (cmd == 'D') {
        if (curR == N - 1) continue;;
        passVertical[curR][curC] = passVertical[curR + 1][curC] = true;
        curR++;
      }
      else if (cmd == 'U') {
        if (curR == 0) continue;
        passVertical[curR][curC] = passVertical[curR - 1][curC] = true;
        curR--;
      }
      else if (cmd == 'L') {
        if (curC == 0) continue;;
        passHorizontal[curR][curC] = passHorizontal[curR][curC - 1] = true;
        curC--;
      }
      else {
        if (curC == N - 1) continue;;
        passHorizontal[curR][curC] = passHorizontal[curR][curC + 1] = true;
        curC++;
      }
    }

    for (int i = 0; i < N; i++) {
      String ans = "";
      for (int j = 0; j < N; j++) {
        if (passHorizontal[i][j] && passVertical[i][j]) ans += "+";
        else if (passVertical[i][j]) ans += "|";
        else if (passHorizontal[i][j]) ans += "-";
        else ans += ".";
      }
      System.out.println(ans);
    }
  }

}
