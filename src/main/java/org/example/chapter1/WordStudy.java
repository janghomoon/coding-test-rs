package org.example.chapter1;

import java.util.Scanner;

public class WordStudy {

  //예제 ? 실패
  //
//  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    String input = scanner.next();
//    //1.sort
//    //2.가장 많은 문자 담기
//    //다르면 문자 바꿈? 이것도 안됨
//    //같으면 cnt ++
//    //다르고 cnt 가 1일때 문자 바꾸고 1로 초기화
//    //중복되는 문자가 같은 경우 ? 출력되어야함
//    String sortInput = Stream.of(input.split(""))
//        .sorted()
//        .collect(Collectors.joining());
//    System.out.println(sortInput);
//    Integer duplicateCnt = 0;
//    Character compareChar = sortInput.charAt(0);
//    char[] outputArray = new char[sortInput.length()];
//    String output = "";
//    for (int idx = 0; idx < sortInput.length() - 1; idx++) {
//      if (sortInput.charAt(idx) == sortInput.charAt(idx++)) ;
//      else if (compareChar != sortInput.charAt(idx++) && duplicateCnt == 0) {
//        output = sortInput.charAt(idx++);
//        duplicateCnt = 0;
//      }
//    }
//    System.out.println(Character.toUpperCase(output));
//  }


  //알파뱃 갯수와 최대값 구하기
  public static void main(String[] args) {
    //회사 깃 테스트
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next().toUpperCase();
    int[] inputArr = getAlphabetCnt(input);
    int maxCount = -1;
    char output = '?';
    for (int idx =0; idx< 26; idx++) {
      if (inputArr[idx] > maxCount) {
        maxCount = inputArr[idx];
        output = (char) ('A' + idx);
      } else if (inputArr[idx] == maxCount) {
        output = '?';
      }
    }
    System.out.println(output);
  }
  public static int[] getAlphabetCnt(String input) {
    int[] inputArr = new int[26];
    for (int idx = 0; idx < input.length(); idx ++) {
      inputArr[input.charAt(idx) - 'A']++;
    }
    return inputArr;
  }
}
