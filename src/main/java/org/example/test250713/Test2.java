package org.example.test250713;
import java.util.Arrays;
public class Test2 {


  public static int[][] rotate90Clockwise(int[][] matrix) {
    int n = matrix.length;
    int[][] rotated = new int[n][n];

    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        rotated[col][n - 1 - row] = matrix[row][col];
      }
    }
    return rotated;
  }

  public static int[][] solution(int[][] matrix, int r) {
    r = r % 4;
    for (int i = 0; i < r; i++) {
      matrix = rotate90Clockwise(matrix);
    }
    return matrix;
  }


  public static void main(String[] args) {
    int[][] matrix1 = {
        {1, 2},
        {3, 4}
    };
    System.out.println(Arrays.deepToString(solution(matrix1, 1)));

    int[][] matrix2 = {
        {1, 2},
        {3, 4}
    };
    System.out.println(Arrays.deepToString(solution(matrix2, 2)));

    int[][] matrix3 = {
        {4, 1, 2},
        {7, 3, 4},
        {3, 5, 6}
    };
    System.out.println(Arrays.deepToString(solution(matrix3, 3)));
  }
}
//import java.util.*;
//class Solution {
//  public int[][] solution(int[][] matrix, int r) {
//
//    int[][] copied = Arrays.stream(matrix)
//        .map(int[]::clone)
//        .toArray(int[][]::new);
//
//    r = r % 4;
//    for (int i = 0; i < r; i++) {
//      copied = rotate90Clockwise(copied);
//    }
//    return copied;
//
//
//  }
//
//  public static int[][] rotate90Clockwise(int[][] matrix) {
//    int n = matrix.length;
//    int[][] rotated = new int[n][n];
//
//    for (int row = 0; row < n; row++) {
//      for (int col = 0; col < n; col++) {
//        rotated[col][n - 1 - row] = matrix[row][col];
//      }
//    }
//    return rotated;
//  }
//}
