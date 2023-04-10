package org.example.chapter1;

import java.util.Scanner;

public class Anagram {
  //잘 모르겠음
  //해설 들어보기
  //ex aabbcc xxyybb  -> 8
  //A aa cc  b 없으니 지워야함
  //B xx yy가 A에 없으니 지워야만함
  // 없애야만 하는 문자  공통 문자 제외 전부
  public static void main(String[] args) {
    //애너그램
    Scanner scanner = new Scanner(System.in);
    String inputOne = scanner.next();
    String inputTwo = scanner.next();
    int[] countA = getCountArray(inputOne);
    int[] countB = getCountArray(inputTwo);
//    for (int idx = 0; idx < inputOne.length(); idx++) {
//      countA[inputOne.charAt(idx) - 'a'] ++;
//    }
//
//    for (int idx = 0; idx < inputTwo.length(); idx++) {
//      countB[inputTwo.charAt(idx) - 'a'] ++;
//    }
    int output = 0;
    for (int idx = 0; idx < 26; idx++) {//알파벳 Math.abs 절대값
      output += Math.abs(countA[idx] - countB[idx]);
//      if (countA[idx] > countB[idx]) output += countA[idx] - countB[idx];
//      if (countB[idx] > countA[idx]) output += countB[idx] - countA[idx];
    }
    System.out.println(output);
  }
  public static int[] getCountArray(String input) {
    int[] countArray = new int[26];
    for (int idx = 0; idx < input.length(); idx++) {
      countArray[input.charAt(idx) - 'a'] ++;

    }
    return countArray;
  }
  
}
