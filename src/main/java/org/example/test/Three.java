package org.example.test;

import java.util.HashMap;
import java.util.Map;

public class Three {

  //3번
  public static void main(String[] args) {
    //많이등장하는 문자 삭제
    //counting
//    boolean[] countArr = new boolean[26];
    String input = "abcabca";
    String[] inputArr= input.split("");
    Map<String, Integer> countMap = new HashMap<>();
    for (int idx = 0; idx < inputArr.length; idx++) {
      countMap.put(inputArr[idx].toLowerCase(), countMap.getOrDefault(inputArr[idx].toLowerCase(),0)+1);
    }
    int maxCount = 0;
    for ( Map.Entry<String, Integer> entry : countMap.entrySet() ) {
      if (maxCount == 0) {
        maxCount = entry.getValue();
      } else if (maxCount < entry.getValue()) {
        maxCount = entry.getValue();
      }
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (int idx =0; idx< inputArr.length;idx++) {
      if(maxCount != countMap.get(inputArr[idx].toLowerCase())) {
        stringBuilder.append(inputArr[idx]);
      }
    }
    //가장 많이 등장한 문자열 삭제
//    StringBuilder stringBuilder = new StringBuilder();
//    for ( Map.Entry<String, Integer> entry : countMap.entrySet() ) {
//      if (entry.getValue()!=maxCount) {//1개 인경우만
//        stringBuilder.append(entry.getKey());
//      }
//    }
//    stringBuilder.toString();
//    System.out.println(stringBuilder.toString());
//    });
  }

}
