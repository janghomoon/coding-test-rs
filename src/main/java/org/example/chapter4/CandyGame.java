package org.example.chapter4;

import java.util.Scanner;

public class CandyGame {
  //3058번

  //N 첫째줄에 보드크기 ( 3 <= N <= 50)

  //다음 N개 줄에는 보드에 채워져 있는 상타의 색이 주어진다.
  //빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y
  //사탕색이 다른 인접한 두칸이 존재하는 입력만 주어진다.
  //
  //증가는  방향으로 ㅇ  사탕을 서로 교환 한다 .
  //
  //가능한 모든 쌍의 사탕을 서로 교환한다.
  //교환한 상태에서 갖아 긴 연속 부분 행/열 을 찾는다
  //교환한 사탕을 원복한다.
  //

  //findMaxRow
  //findMaxCol

  //교환 가능한 쌍이 무조건 하나는 있을까(문제 지문 상  입력 주어짐
  //교환하지 않은 상태의 답이 더 클 수 있을까 ?
  //

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    char[][] map = new char[N][N];
    for (int idx = 0; idx < N; idx++) {
      map[idx] = scanner.next().toCharArray();
    }
    int ans = 0;
    for (int i =0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (j+1 < N && map[i][j] !=map[i][j+1]) {
          swapCandy(map, i, j, i, j+1);
          ans = Math.max(ans, Math.max(finMaxColumn(map), findMaxRow(map)));
          swapCandy(map, i, j, i, j+1);
        }

        if(i+1<N && map[i][j] != map[i+1][j] ) {
          swapCandy(map, i, j, i+1, j);
          ans = Math.max(ans, Math.max(finMaxColumn(map), findMaxRow(map)));
          swapCandy(map, i, j, i+1, j);
        }


      }
    }
    System.out.println(ans);
  }

  private static int finMaxColumn(char[][] map) {//하
    int N = map.length;
    int maxCol = 0;
    for (int j =0; j < N; j++) {
      int len = 1;
      for (int i = 1; i < N; i++) {
        if (map[i][j] == map[i-1][j]) {
          len++;
        } else {
          maxCol = Math.max(maxCol, len);
          len = 1;
        }

      }
      maxCol = Math.max(maxCol, len);
    }

    return maxCol;
  }

  private static int findMaxRow(char[][] map) {//좌
    int N = map.length;
    int maxRow = 0;
    for (int i =0; i < N; i++) {
      int len = 1;
      for (int j = 1; j < N; j++) {
        if (map[i][j] == map[i][j-1]) {
          len++;
        } else {
          maxRow = Math.max(maxRow, len);
          len = 1;
        }

      }
      maxRow = Math.max(maxRow, len);
    }

    return maxRow;

  }

  private static void swapCandy(char[][] map, int i1, int j1, int i2, int j2) {//변경대상, 첫좌표 1,2, 두번째 좌표 1, 2
    char temp = map[i1][j1];
    map[i1][j1] = map[i2][j2];
    map[i2][j2] = temp;
  }
}
