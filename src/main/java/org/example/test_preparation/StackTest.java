package org.example.test_preparation;

import java.util.Scanner;
import java.util.Stack;

public class StackTest {
  public static void main(String[] args) {
    stackProgram();
  }

  public static void stackProgram() {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character after reading N
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      String line = scanner.nextLine();
      String[] parts = line.split(" ");
      String command = parts[0];

      switch (command) {
        case "push":
          int x = Integer.parseInt(parts[1]);
          stack.push(x);
          break;
        case "pop":
          if (stack.isEmpty()) {
            sb.append("-1\n");
          } else {
            sb.append(stack.pop()).append("\n");
          }
          break;
        case "size":
          sb.append(stack.size()).append("\n");
          break;
        case "empty":
          if (stack.isEmpty()) {
            sb.append("1\n");
          } else {
            sb.append("0\n");
          }
          break;
        case "top":
          if (stack.isEmpty()) {
            sb.append("-1\n");
          } else {
            sb.append(stack.peek()).append("\n");
          }
          break;
      }
    }
    System.out.println(sb);
    scanner.close();

  }

}
