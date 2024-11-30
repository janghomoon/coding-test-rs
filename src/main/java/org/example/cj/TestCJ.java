package org.example.cj;

public class TestCJ {

  public static void main(String[] args) {
    String aaa= "people";

  }
  public void test(String aaa) {
    aaa= "people";
    char[] charStr = aaa.toCharArray();
    char[] result = new char[charStr.length];
    //Set
    for (int i=0; i<charStr.length; i++) {
      char c = charStr[i];
//      result[i] = c;
      for (int j=i+1; j<charStr.length; j++) {
        if (charStr[i] == charStr[j]) {//같다면 제거
          result[i] = charStr[j];
          break;
        }
      }


    }
  }

}
