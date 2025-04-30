package org.example.test_preparation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindInteger {
  public static  void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(scanner.nextInt());
    }

    int m = scanner.nextInt();
    for (int i = 0; i < m; i++) {
      int x = scanner.nextInt();
      if (set.contains(x)) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }

    scanner.close();

  }
}
