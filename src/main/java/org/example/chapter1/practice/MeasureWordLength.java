package org.example.chapter1.practice;

import java.util.regex.Pattern;

public class MeasureWordLength {
  public static void main(String[] args) {
    String digitAnd3DecimalPattern = "^[0-9]+(.)?[0-9]{0,3}$";
    System.out.println(Pattern.matches(digitAnd3DecimalPattern, "33.00"));
    System.out.println(Pattern.matches(digitAnd3DecimalPattern, "33.000"));
    System.out.println(Pattern.matches(digitAnd3DecimalPattern, "3333.000"));

  }

}
