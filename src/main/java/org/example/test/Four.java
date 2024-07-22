package org.example.test;

public class Four {
//  RxC크기의 흑백 이미지가 있습니다. 1x1 크기의 각 칸은 한개의 픽셀을 나타내며, 검은색 또는 흰색으로 이루어져 있고, 검은색 부분은 0, 흰색 부분은 1로 표현됩니다. 이때 우라는 흰색으로만 이루어진 영ㅇ역이 몇개인지 찾으려 고합니다. 영역이란 픽셀들이 가로 또는 세로로 서로 연결되어 있을때 1개의 영역이라고 하며 픽셀의 개수가 그 영역의 넓이가 됩니다, 단 대각선으로 연결된것은 같은 영역이 아닙니다. 영역의 수와 가장 큰 영역의 픽셀 수를 자바로 구현
//  설명:
//
//  image 2차원 배열은 이미지 데이터를 저장합니다. 각 픽셀은 0 (검정색) 또는 1 (흰색) 값으로 표현됩니다.
//  whiteAreaCount 변수는 흰색 영역 개수를 저장합니다.
//  maxWhiteAreaSize 변수는 가장 큰 흰색 영역 크기를 저장합니다.
//  main 함수는 다음과 같은 작업을 수행합니다.
//  이미지 데이터를 초기화합니다.
//  흰색 영역 개수와 가장 큰 영역 크기를 계산합니다.
//  결과를 출력합니다.
//  countWhiteArea 함수는 픽셀 (row, col)을 시작으로 흰색 영역을 재귀적으로 탐색하고 개수를 반환합니다.
//  현재 픽셀을 방문한 픽셀로 표시하고, 상, 하, 좌,
  static int[][] image; // 이미지 데이터를 저장하는 2차원 배열
  static int whiteAreaCount; // 흰색 영역 개수
  static int maxWhiteAreaSize; // 가장 큰 흰색 영역 크기

  public static void main(String[] args) {
    // 이미지 데이터를 초기화합니다. (예시 코드)
    image = new int[][]{
        {1, 1, 0, 1, 1},
        {0, 1, 1, 0, 0},
        {0, 0, 0, 0, 0},
        {1, 1, 0, 1, 1},
        {1, 0, 1, 1, 1},
        {1, 0, 1, 1, 1}
    };

    // 흰색 영역 개수와 가장 큰 영역 크기를 계산합니다.
    whiteAreaCount = 0;
    maxWhiteAreaSize = 0;
    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[row].length; col++) {
        if (image[row][col] == 1 && !isVisited(row, col)) {
          int whiteAreaSize = countWhiteArea(row, col);
          whiteAreaCount++;
          maxWhiteAreaSize = Math.max(maxWhiteAreaSize, whiteAreaSize);
        }
      }
    }

    // 결과 출력
    System.out.println("흰색 영역 개수: " + whiteAreaCount);
    System.out.println("가장 큰 흰색 영역 크기: " + maxWhiteAreaSize);
  }

  // 픽셀 (row, col)을 시작으로 흰색 영역을 재귀적으로 탐색하고 개수를 증가시킵니다.
  private static int countWhiteArea(int row, int col) {
    if (image[row][col] != 1 || isVisited(row, col)) {
      return 0;
    }

    image[row][col] = 2; // 방문한 픽셀 표시
    int size = 1; // 현재 영역 크기

    // 상, 하, 좌, 우 방향 픽셀을 재귀적으로 탐색합니다.
    if (row > 0) {
      size += countWhiteArea(row - 1, col);
    }
    if (row < image.length - 1) {
      size += countWhiteArea(row + 1, col);
    }
    if (col > 0) {
      size += countWhiteArea(row, col - 1);
    }
    if (col < image[0].length - 1) {
      size += countWhiteArea(row, col + 1);
    }

    return size;
  }

  // 픽셀 (row, col)이 이미 방문되었는지 확인합니다.
  private static boolean isVisited(int row, int col) {
    return image[row][col] == 2;
  }

}
