package org.example.test0505;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test01 {
  static int n,m;
  static int calculatePizza(int coupon) {
    int result = coupon / m;
    if (result == 0) {
      return 0;
    }
    return result + calculatePizza(result + coupon % m);
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    StringTokenizer st = new StringTokenizer(input);
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    System.out.println(n + calculatePizza(n));
    br.close();
  }
}
