package org.example.test1201;

import java.util.*;
public class Test1201 {

  //문제 체크
  //행의 중앙값 계산:
  //각 행을 정렬한 후 중앙값을 구합니다.
  //열의 중앙값 계산:
  //각 열을 배열로 추출한 뒤 정렬하여 중앙값을 구합니다.
  //조건 일치 카운팅:
  //원소가 행의 중앙값과 열의 중앙값 둘 다 일치하는 경우를 찾습니다.
  //위 코드는 문제 조건을 충족하며, 테스트 케이스에 따라 정확한 결과를 반환합니다.
  //
  //추가 질문이 있으시면 언제든 알려주세요!


  public static void main(String[] args) {
    int[][] matrix1 = {
        {1, 19, 20, 8,25},
        {21, 4,3,17,24},
        {12, 5, 6, 16, 15},
        {11, 18, 10, 9,23},
        {7, 13, 14,22,2}
    };

//    int[][] matrix2 = {
//        {4, 2, 9, 1},
//        {5, 6, 8, 3},
//        {7, 1, 4, 9},
//        {6, 8, 7, 7}
//    };
    int ansmter = solution(matrix1);
    System.out.println(ansmter);
  }

  public static int solution(int[][] matrix) {
    int matrixLength = matrix.length;//NxN  가로세로 같음
    int answer = 0;
    int[] rowMidValue = new int[matrixLength]; //행 중앙값
    int[] colMidValue = new int[matrixLength];//열 중앙값

    for (int i = 0; i < matrixLength; i++) {
      int[] rowCopy = Arrays.copyOf(matrix[i], matrixLength);
      Arrays.sort(rowCopy); // 정렬
      rowMidValue[i] = rowCopy[matrixLength / 2]; // 중앙값 저장
    }
    for (int j = 0; j < matrixLength; j++) {
      int[] col = new int[matrixLength];
      for (int i = 0; i < matrixLength; i++) {
        col[i] = matrix[i][j];
      }
      Arrays.sort(col); // 열 정렬
      colMidValue[j] = col[matrixLength / 2]; // 중앙값 저장
    }
    for (int i = 0; i < matrixLength; i++) {
      for (int j = 0; j < matrixLength; j++) {
        if (matrix[i][j] == rowMidValue[i] && matrix[i][j] == colMidValue[j]) {
          answer++;
        }
      }
    }

    return answer;
  }


//  SELECT
//  p.name AS product_name,
//  COUNT(DISTINCT c.user_id) AS user_count
//  FROM
//  cart_products p
//  INNER JOIN carts c ON p.cart_id = c.id
//  GROUP BY
//  p.name
//  ORDER BY
//  user_count DESC,
//  p.name;


}
