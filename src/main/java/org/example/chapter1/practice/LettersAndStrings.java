package org.example.chapter1.practice;

import java.util.Scanner;

public class LettersAndStrings {
  //백준 단계별  문자열

  //1. 문자와 문자열

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String inputText = scanner.next();
    int inputIndex = scanner.nextInt();
    System.out.println(inputText.charAt(inputIndex-1));
  }

}
