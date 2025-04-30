//package org.example.test250413;
//
//public class Test03 {
//
//}
//
//
//
//// you can also use imports, for example:
//// import java.util.*;
//
//// you can write to stdout for debugging purposes, e.g.
//// System.out.println("this is a debug message");
//
//class Solution {
//  public boolean solution(String S) {
//    // Implement your solution here
//    if (S.length() < 9 || S.length() > 30) {
//      return false;
//    }
//
//    for (char c : S.toCharArray()) {
//      if (!Character.isDigit(c) && c != '-') {
//        return false;
//      }
//    }
//    int hyphenCount = 0;
//    for (int i = 0; i < S.length(); i++) {
//      if (S.charAt(i) == '-') {
//        hyphenCount++;
//        if (i == 0 || i == S.length() - 1) {
//          return false;
//        }
//        if (i > 0 && S.charAt(i - 1) == '-') {
//          return false;
//        }
//      }
//    }
//
//    if (hyphenCount != 2 && hyphenCount != 3) {
//      return false;
//    }
//
//    String[] parts = S.split("-");
//    for (String part : parts) {
//      if (part.length() != 3 && part.length() != 2) {
//        return false;
//      }
//    }
//
//    if (hyphenCount == 3 && parts[3].length() != 2) {
//      return false;
//    }
//
//    return true;
//
//  }
//}
//
//
//
//
//
//import java.util.*;
//    import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//class Solution {
//  public int solution(Pizza[] menu, OrderItem[] order) {
//    Map<String, Pizza> menuMap = new HashMap<>();
//    for (Pizza p : menu) {
//      menuMap.put(p.name, p);
//    }
//
//    List<OrderItem> allOrderItems = new ArrayList<>();
//    for (OrderItem item : order) {
//      IntStream.range(0, item.quantity)
//          .forEach(i -> allOrderItems.add(new OrderItem(item.name, item.size, 1)));
//    }
//
//    int originalTotal = allOrderItems.stream()
//        .mapToInt(item -> getUnitPrice(item, menuMap))
//        .sum();
//    int minPrice = originalTotal;
//
//    minPrice = Math.min(minPrice, applyDiscount1(new ArrayList<>(allOrderItems), menuMap));
//    minPrice = Math.min(minPrice, applyDiscount2(new ArrayList<>(allOrderItems), menuMap));
//    minPrice = Math.min(minPrice, applyDiscount3(new ArrayList<>(allOrderItems), menuMap));
//    minPrice = Math.min(minPrice, applyDiscount4(new ArrayList<>(allOrderItems), menuMap));
//
//    return minPrice;
//  }
//
//  private int getUnitPrice(OrderItem item, Map<String, Pizza> menuMap) {
//    Pizza pizza = menuMap.get(item.name);
//    if (item.size.equals("Small")) return pizza.price_S;
//    if (item.size.equals("Medium")) return pizza.price_M;
//    if (item.size.equals("Large")) return pizza.price_L;
//    return 0;
//  }
//
//  private int applyDiscount1(List<OrderItem> orderItems, Map<String, Pizza> menuMap) {
//    if (orderItems.size() < 3) return orderItems.stream().mapToInt(item -> getUnitPrice(item, menuMap)).sum();
//    int minPrice = orderItems.stream().mapToInt(item -> getUnitPrice(item, menuMap)).min().orElse(0);
//    return orderItems.stream().mapToInt(item -> getUnitPrice(item, menuMap)).sum() - minPrice;
//  }
//
//  private int applyDiscount2(List<OrderItem> orderItems, Map<String, Pizza> menuMap) {
//
//    List<Integer> allPrices = orderItems.stream()
//        .map(item -> getUnitPrice(item, menuMap))
//        .collect(Collectors.toList());
//
//    int originalTotal = allPrices.stream().mapToInt(i -> i).sum();
//    int bestTotal = originalTotal;
//
//    Map<String, List<OrderItem>> grouped = orderItems.stream()
//        .collect(Collectors.groupingBy(item -> item.name));
//
//    for (String name : grouped.keySet()) {
//      List<OrderItem> items = grouped.get(name);
//      if (items.size() < 5) continue;
//
//      items.sort((a, b) -> Integer.compare(getUnitPrice(b, menuMap), getUnitPrice(a, menuMap)));
//      List<OrderItem> discountedItems = items.subList(0, 5);
//
//      List<OrderItem> remaining = new ArrayList<>(orderItems);
//      remaining.removeAll(discountedItems);
//
//      int discountedTotal = 100 + remaining.stream()
//          .mapToInt(item -> getUnitPrice(item, menuMap))
//          .sum();
//
//      bestTotal = Math.min(bestTotal, discountedTotal);
//    }
//
//    return bestTotal;
//  }
//
//  private int applyDiscount3(List<OrderItem> orderItems, Map<String, Pizza> menuMap) {
//    Map<String, Long> largeCounts = orderItems.stream()
//        .filter(item -> "Large".equals(item.size))
//        .collect(Collectors.groupingBy(item -> item.name, Collectors.counting()));
//
//    Map<String, List<OrderItem>> smallItemsByName = orderItems.stream()
//        .filter(item -> "Small".equals(item.size))
//        .collect(Collectors.groupingBy(item -> item.name));
//
//    int discount = 0;
//
//    for (Map.Entry<String, Long> entry : largeCounts.entrySet()) {
//      String pizzaName = entry.getKey();
//      long largeCount = entry.getValue();
//
//      List<OrderItem> smallItems = smallItemsByName.getOrDefault(pizzaName, new ArrayList<>());
//      smallItems.sort(Comparator.comparingInt(item -> getUnitPrice(item, menuMap)));
//
//      for (int i = 0; i < Math.min(largeCount, smallItems.size()); i++) {
//        discount += getUnitPrice(smallItems.get(i), menuMap);
//      }
//    }
//
//    int total = orderItems.stream().mapToInt(item -> getUnitPrice(item, menuMap)).sum();
//    return total - discount;
//  }
//
//  private int applyDiscount4(List<OrderItem> orderItems, Map<String, Pizza> menuMap) {
//    List<OrderItem> largeItems = orderItems.stream().filter(item -> "Large".equals(item.size)).collect(Collectors.toList());
//    if (largeItems.size() < 3) {
//      return orderItems.stream().mapToInt(item -> getUnitPrice(item, menuMap)).sum();
//    }
//
//    int minDiscounted = Integer.MAX_VALUE;
//    int n = largeItems.size();
//    for (int i = 0; i < (1 << n); i++) {
//      if (Integer.bitCount(i) == 3) {
//        int currentTotal = orderItems.stream().mapToInt(item -> getUnitPrice(item, menuMap)).sum();
//        int discount = 0;
//        List<OrderItem> discountedItems = new ArrayList<>();
//        for (int j = 0; j < n; j++) {
//          if ((i >> j) % 2 == 1) {
//            discountedItems.add(largeItems.get(j));
//          }
//        }
//        int originalPrice = discountedItems.stream().mapToInt(item -> getUnitPrice(item, menuMap)).sum();
//        int discountedPrice = discountedItems.stream()
//            .mapToInt(item -> menuMap.get(item.name).price_M)
//            .sum();
//        minDiscounted = Math.min(minDiscounted, currentTotal - originalPrice + discountedPrice);
//      }
//    }
//    return minDiscounted == Integer.MAX_VALUE ? orderItems.stream().mapToInt(item -> getUnitPrice(item, menuMap)).sum() : minDiscounted;
//  }
//}
//
//
//
//
//
//
//
//package com.codility;
//
//enum StateInfo {
//  LOGGED_IN, LOGGED_OUT, SUSPENDED, ERROR
//}
//
//interface BankAccountState {
//  public StateInfo login(String password);
//  public StateInfo logout();
//  public StateInfo unlock(int resetCode);
//  public StateInfo withdrawMoney(int amount);
//}
//
//class BankAccount {
//  private BankAccountState loggedIn;
//  private BankAccountState loggedOut;
//  private BankAccountState suspended;
//  private BankAccountState bankAccountState;
//  private int cashBalance;
//  private String password;
//  private int passwordRetries;
//  private int resetCode;
//
//  public BankAccount(int cashBalance, String password, int resetCode) {
//    // YOUR SOLUTION HERE
//    this.cashBalance = cashBalance;
//    this.password = password;
//    this.passwordRetries = 0;
//    this.resetCode = resetCode;
//    this.loggedIn = new LoggedIn(this);
//    this.loggedOut = new LoggedOut(this);
//    this.suspended = new Suspended(this);
//    this.bankAccountState = this.loggedOut; // Initial state is LoggedOut
//  }
//
//  public void setState(BankAccountState state) {
//    this.bankAccountState = state;
//  }
//
//  public BankAccountState getState() {
//    return this.bankAccountState;
//  }
//
//  public BankAccountState getLoggedInState() {
//    return this.loggedIn;
//  }
//
//  public BankAccountState getLoggedOutState() {
//    return this.loggedOut;
//  }
//
//  public BankAccountState getSuspendedState() {
//    return this.suspended;
//  }
//
//  public StateInfo login(String password) {
//    return this.bankAccountState.login(password);
//  }
//
//  public StateInfo logout() {
//    return this.bankAccountState.logout();
//  }
//
//  public StateInfo unlock(int resetCode) {
//    return this.bankAccountState.unlock(resetCode);
//  }
//
//  public StateInfo withdrawMoney(int amount) {
//    return this.bankAccountState.withdrawMoney(amount);
//  }
//
//  public void setCashBalance(int amount) {
//    this.cashBalance = amount;
//  }
//
//  public int getCashBalance() {
//    return this.cashBalance;
//  }
//
//  public String getPassword() {
//    return this.password;
//  }
//
//  public void setPasswordRetries(int passwordRetries) {
//    this.passwordRetries = passwordRetries;
//  }
//
//  public int getPasswordRetries() {
//    return this.passwordRetries;
//  }
//
//  public int getResetCode() {
//    return this.resetCode;
//  }
//}
//
//// YOUR SOLUTION HERE
//class LoggedIn implements BankAccountState {
//  private BankAccount bankAccount;
//
//  public LoggedIn(BankAccount bankAccount) {
//    this.bankAccount = bankAccount;
//  }
//
//  @Override
//  public StateInfo login(String password) {
//    System.out.println("Already logged in.");
//    return StateInfo.LOGGED_IN;
//  }
//
//  @Override
//  public StateInfo logout() {
//    bankAccount.setState(bankAccount.getLoggedOutState());
//    System.out.println("Logged out successfully.");
//    return StateInfo.LOGGED_OUT;
//  }
//
//  @Override
//  public StateInfo unlock(int resetCode) {
//    System.out.println("Cannot unlock while logged in.");
//    return StateInfo.LOGGED_IN;
//  }
//
//  @Override
//  public StateInfo withdrawMoney(int amount) {
//    if (amount > 0 && bankAccount.getCashBalance() >= amount) {
//      bankAccount.setCashBalance(bankAccount.getCashBalance() - amount);
//      System.out.println("Withdrew $" + amount + ". Current balance: $" + bankAccount.getCashBalance());
//      return StateInfo.LOGGED_IN;
//    } else if (amount <= 0) {
//      System.out.println("Withdrawal amount must be positive.");
//      return StateInfo.LOGGED_IN;
//    } else {
//      System.out.println("Insufficient funds.");
//      return StateInfo.LOGGED_IN;
//    }
//  }
//}
//
//// YOUR SOLUTION HERE
//class LoggedOut implements BankAccountState {
//  private BankAccount bankAccount;
//
//  public LoggedOut(BankAccount bankAccount) {
//    this.bankAccount = bankAccount;
//  }
//
//  @Override
//  public StateInfo login(String password) {
//    if (password.equals(bankAccount.getPassword())) {
//      bankAccount.setState(bankAccount.getLoggedInState());
//      bankAccount.setPasswordRetries(0);
//      System.out.println("Logged in successfully.");
//      return StateInfo.LOGGED_IN;
//    } else {
//      bankAccount.setPasswordRetries(bankAccount.getPasswordRetries() + 1);
//      System.out.println("Incorrect password. Attempts remaining: " + (3 - bankAccount.getPasswordRetries()));
//      if (bankAccount.getPasswordRetries() >= 3) {
//        bankAccount.setState(bankAccount.getSuspendedState());
//        System.out.println("Account suspended due to too many failed login attempts.");
//        return StateInfo.SUSPENDED;
//      }
//      return StateInfo.LOGGED_OUT;
//    }
//  }
//
//  @Override
//  public StateInfo logout() {
//    System.out.println("Already logged out.");
//    return StateInfo.LOGGED_OUT;
//  }
//
//  @Override
//  public StateInfo unlock(int resetCode) {
//    System.out.println("Cannot unlock while logged out. Please log in first.");
//    return StateInfo.LOGGED_OUT;
//  }
//
//  @Override
//  public StateInfo withdrawMoney(int amount) {
//    System.out.println("Please log in to withdraw money.");
//    return StateInfo.LOGGED_OUT;
//  }
//}
//
//
//// YOUR SOLUTION HERE
//class Suspended implements BankAccountState {
//  private BankAccount bankAccount;
//
//  public Suspended(BankAccount bankAccount) {
//    this.bankAccount = bankAccount;
//  }
//
//  @Override
//  public StateInfo login(String password) {
//    System.out.println("Account is suspended. Cannot log in.");
//    return StateInfo.SUSPENDED;
//  }
//
//  @Override
//  public StateInfo logout() {
//    System.out.println("Account is suspended. Cannot log out.");
//    return StateInfo.SUSPENDED;
//  }
//
//  @Override
//  public StateInfo unlock(int resetCode) {
//    if (resetCode == bankAccount.getResetCode()) {
//      bankAccount.setState(bankAccount.getLoggedOutState());
//      bankAccount.setPasswordRetries(0);
//      System.out.println("Account unlocked successfully. Please log in.");
//      return StateInfo.LOGGED_OUT;
//    } else {
//      System.out.println("Incorrect reset code.");
//      return StateInfo.SUSPENDED;
//    }
//  }
//
//  @Override
//  public StateInfo withdrawMoney(int amount) {
//    System.out.println("Account is suspended. Cannot withdraw money.");
//    return StateInfo.SUSPENDED;
//  }
//}
//
