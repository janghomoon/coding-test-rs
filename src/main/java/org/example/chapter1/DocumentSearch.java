package org.example.chapter1;

import java.util.Scanner;

public class DocumentSearch {

  //ababababa
  //aba
  //결과값 2

  //3가지 방법
  //이중 for 문
  //indexOf
  //replace 이용

  //next 사용시 공백 인식안됨
  //nextLine
  //1. 이중for문 활용
//  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    String document = scanner.nextLine();
//    String input = scanner.nextLine();
//    int output = 0;
//    for (int idx = 0; idx < document.length(); idx++) {
//      boolean isMatch = true;
//      for (int index = 0; index < input.length(); index++) {
//        if ( idx+ index >= document.length()
//            ||  document.charAt(idx + index) != input.charAt(index) ) { isMatch = false; break;}
//      }
//      if (isMatch) {
//        output++;
//        idx = idx + input.length() - 1;
//      }
//    }
//    System.out.println(output);
//  }

  //2 indexOf 활용
//  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    String document = scanner.nextLine();
//    String input = scanner.nextLine();
//    int output = 0;
//    int startIndex = 0;
//    while (true) {
//      int resultIdx = document.indexOf(input, startIndex);
//      if (resultIdx < 0) break;
//      startIndex = resultIdx + input.length();
//      output++;
//    }
//    System.out.println(output);
//  }
  //3. replace
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String document = scanner.nextLine();
    String input = scanner.nextLine();
    String replaceDoc = document.replace(input,"");
    int length = document.length() - replaceDoc.length();
    int output = length / input.length();
    System.out.println(output);
  }
}
