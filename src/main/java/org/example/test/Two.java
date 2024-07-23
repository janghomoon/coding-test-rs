package org.example.test;

import java.util.Arrays;
import java.util.Comparator;

public class Two {

  public static void main(String[] args) {
    int[][] inputArr =new int[2][2];
    inputArr[0][0] = 200;
    inputArr[0][1] = 300;
    inputArr[1][0] = 100;
    inputArr[1][1] = 200;
//    inputArr[2][0] = 8;
//    inputArr[2][1] = 10;
    Arrays.sort(inputArr, Comparator.comparingInt(o -> o[0]));
    int answer = 0;
    int start=inputArr[0][0];
    int end =inputArr[0][1];
    answer = end-start;
    for (int i=1;i <=inputArr.length-1;i++) {
      if (inputArr[i][0] < end && end <  inputArr[i][1]) {//시작이 이전 끝보다 작고  이전 마지막이 현재 마지막보다 작을때
        answer += inputArr[i][1] - end;
        start = end;
        end = inputArr[i][1];
      }else if (inputArr[i][0] > end || inputArr[i][0] == end) {
        start = inputArr[i][0];
        end = inputArr[i][1];
        answer += end - start;
      }
      //이전 시작보다 ㅇ
//      if (i==1) {
//        //값이 더클때
//        if (inputArr[i][0] < end && end <  inputArr[i][1]) {
//          answer+= inputArr[i][1] - end;
//          start = end;
//          end = inputArr[i][1];
//        } else if (end < inputArr[i][0]) {
//          start = inputArr[i][0];
//          end = inputArr[i][1];
//          answer+= end- start;
//        }
//      }

    }
    System.out.println(answer);



  }

}
