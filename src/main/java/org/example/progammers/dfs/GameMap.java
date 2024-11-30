package org.example.progammers.dfs;
import java.util.*;
public class GameMap {
  // https://newbie-in-softengineering.tistory.com/entry/Lv2-%EA%B2%8C%EC%9E%84-%EB%A7%B5-%EC%B5%9C%EB%8B%A8%EA%B1%B0%EB%A6%AC-Java
//  사방탐색 좌표 (1, 0), (-1, 0), (0, 1), (0, -1)
  static int[] dX = {1, -1, 0, 0};
  static int[] dY = {0, 0, 1, -1};
  public static void main(String[] args) {

  }

  public static int solution(int[][] maps) {
    int answer = 0;

    int[][] visited = new int[maps.length][maps[0].length];

    bfs(maps, visited);
    answer = visited[maps.length - 1][maps[0].length - 1];

    if (answer == 0) {
      answer = -1;
    }

    return answer;
  }
  public static void bfs(int[][] maps, int[][] visited) {
    int x = 0;
    int y = 0;
    visited[x][y] = 1;

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y});

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int cX = current[0];
      int cY = current[1];

      for (int i = 0; i < 4; i++) {
        int nX = cX + dX[i];
        int nY = cY = dY[i];

        if (nX < 0 || nX > maps.length - 1 || nY < 0 || nY > maps[0].length - 1) {
          continue;
        }

        if (visited[nX][nY] == 0 && maps[nX][nY] == 1) {
          visited[nX][nY] = visited[cX][cY] + 1;
          queue.add(new int[]{nX, nY});
        }
      }
    }
  }

}
