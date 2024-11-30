package org.example.progammers.sort;

import java.util.Arrays;

public class KthNumber {

  //배열 array 의 i번째 숫자부터 j번재 쑷자까지 자르고 정렬핼
  public static void main(String[] args) {
    int[] arr = {1, 5, 2, 6, 3, 7, 4};
    int[][] command = {
        {2, 5, 3}
        , {4, 4, 1}
        , {1, 7, 3}
    };
     solution(arr, command);
  }

  public static int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];
    int answerIndex = 0;
    for (int i=0;i<commands.length;i++) {
      int[] command = commands[i];

      int[] extract = new int[command[1] - command[0] + 1];
      int addIdx = 0;
      for (int j = command[0]-1; j<command[1]; j++) {
        extract[addIdx] = array[j];
        addIdx++;
      }
      Arrays.sort(extract);
      answer[answerIndex] = extract[command[2]-1];
      answerIndex++;
    }


    return answer;
  }

}
