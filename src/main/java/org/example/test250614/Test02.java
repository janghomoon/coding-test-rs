package org.example.test250614;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//신입사원 이메일 문제
public class Test02 {
//  company = "example"
//  string = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker"

  public static void main(String[] args) {
    String result = solution("John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker", "company");
    System.out.println(result);
  }
  public static String solution(String S, String C) {
    String[] people = S.split("; ");
    Map<String, Integer> mailMap = new HashMap<>();
    List<String> result = new ArrayList<>();
    for (String person : people) {
      String[] parts = person.trim().split(" ");
      String first = parts[0].toLowerCase();
      String last = parts[parts.length - 1].toLowerCase().replaceAll("-", "");
      if (last.length() > 8) {
        last = last.substring(0, 8);
      }

      String emailBase = first + "." + last;
      String emailKey = emailBase;
      int count = mailMap.getOrDefault(emailBase, 0) + 1;

      if (count > 1) {
        emailKey = emailBase + count;
      }

      mailMap.put(emailBase, count);

      String email = emailKey + "@" + C.toLowerCase() + ".com";
      result.add(person + " <" + email + ">");
    }

    return String.join("; ", result);
  }

}
// you can also use imports, for example:
// import java.util.*;
//
//// you can write to stdout for debugging purposes, e.g.
//// System.out.println("this is a debug message");
//
//class Solution {
//  public String solution(String S, String C) {
//    // Implement your solution here
//    String[] people = S.split("; ");
//    Map<String, Integer> mailMap = new HashMap<>();
//    List<String> result = new ArrayList<>();
//    for(String person : people) {
//      String[] parts = person.trim().split(" ");
//      String first = parts[0].toLowerCase();
//      String last = parts[parts.length - 1].toLowerCase().replaceAll("-", "");
//
//      if (last.length() > 8) last = last = last.substring(0, 8);
//
//      String emailName = first + "." + last;
//      String emailKey = emailName;
//      int count = mailMap.getOrDefault(emailName, 0) + 1;
//
//      if (count > 1)  emailKey = emailName + count;
//
//      mailMap.put(emailName, count);
//      String email = emailKey + "@" + C.toLowerCase() + ".com";
//      result.add(person + " <" + email + ">")
//    }
//
//    return String.join("; ", result);
//  }
//}
//import java.util.*;
//
//class Solution {
//  public String solution(String S, String C) {
//    String[] people = S.split("; ");
//    Map<String, Integer> emailCount = new HashMap<>();
//    List<String> result = new ArrayList<>();
//
//    for (String person : people) {
//      String[] parts = person.trim().split(" ");
//      String first = parts[0].toLowerCase();
//      String last = parts[parts.length - 1].toLowerCase().replaceAll("-", "");
//      if (last.length() > 8) {
//        last = last.substring(0, 8);
//      }
//
//      String emailBase = first + "." + last;
//      String emailKey = emailBase;
//      int count = emailCount.getOrDefault(emailBase, 0) + 1;
//
//      if (count > 1) {
//        emailKey = emailBase + count;
//      }
//
//      emailCount.put(emailBase, count);
//
//      String email = emailKey + "@" + C.toLowerCase() + ".com";
//      result.add(person + " <" + email + ">");
//    }
//
//    return String.join("; ", result);
//  }
//}
