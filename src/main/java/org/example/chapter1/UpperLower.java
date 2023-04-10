package org.example.chapter1;

import java.util.Scanner;

public class UpperLower {

  //내가 푼 방식
//  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    String input = scanner.next();
//    String output = "";
//    for (int idx = 0; idx < input.length(); idx ++) {
//      char compareChar = input.charAt(idx);
//      if (Character.isUpperCase(compareChar)) {
//        output += String.valueOf(Character.toLowerCase(compareChar));
//      } else if (Character.isLowerCase(compareChar)) {
//        output += String.valueOf(Character.toUpperCase(compareChar));
//      }
//    }
//    System.out.println(output);
//  }


  //해설
  //아스키 코드 이용
  //Z - A  25가 됨
  public static void main(String[] args) {
    //거의 mandatory
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();
    String output = "";
//    char[] outputArr= input.toCharArray();
    for (int idx =0; idx< input.length(); idx ++) {
      //int dist =input.charAt(idx) -'A';
      //int lower_ascii = 'a' + dist;
      //base(소문자라면 a  대문자라면 A)로 부터 몇 번째 알파벳(idx)인지를 찾아서 더한다.
      char compareChar = input.charAt(idx);
      if('A' <= compareChar && compareChar <= 'Z') {// 대문자
//        System.out.print((char)('a' + compareChar - 'A'));
        output+= (char)('a' + compareChar - 'A');
      } //소문자
      else output+= (char)('A' +compareChar - 'a');//System.out.print((char)('A' + compareChar - 'a'));
      System.out.println(output);
    }



  }
}
