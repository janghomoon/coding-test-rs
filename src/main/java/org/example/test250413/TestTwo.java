package org.example.test250413;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Pizza {
  public String name;
  public int price_S;
  public int price_M;
  public int price_L;

  public Pizza(String name, int price_s, int price_M, int price_L) {
    this.name = name;
    this.price_S = price_s;
    this.price_M = price_M;
    this.price_L = price_L;
  }
}
  class OrderItem {
    public String name;
    public String size;
    public int quantity;

    public OrderItem(String name, String size, int quantity) {
      this.name = name;
      this.size = size;
      this.quantity = quantity;
    }
  }
class TestTwo {


  public void main(String[] args) {
    Pizza[] menu = {
        new Pizza("boston", 7, 5, 10),
        new Pizza("hawaii", 8, 9, 12),
        new Pizza("newyorker", 8, 9, 13),
        new Pizza("philadelphia", 5, 10, 13)
    };

    OrderItem[] order = {
        new OrderItem("boston", "Small", 3),
        new OrderItem("hawaii", "Large", 3),
        new OrderItem("newyorker", "Large", 1),
        new OrderItem("boston", "Large", 2),
        new OrderItem("philadelphia", "Large", 2)
    };
    solution(menu, order);
  }

  public int solution(Pizza[] menu, OrderItem[] order) {
    Map<String, Pizza> menuMap = new HashMap<>();
    for (Pizza p : menu) {
      menuMap.put(p.name, p);
    }

    List<OrderItem> allOrderItems = new ArrayList<>();
    for (OrderItem item : order) {
      IntStream.range(0, item.quantity)
          .forEach(i -> allOrderItems.add(new OrderItem(item.name, item.size, 1)));
    }

    int originalTotal = allOrderItems.stream()
        .mapToInt(item -> getUnitPrice(item, menuMap))
        .sum();
    int minPrice = originalTotal;

    minPrice = Math.min(minPrice, applyDiscount1(new ArrayList<>(allOrderItems), menuMap));
    minPrice = Math.min(minPrice, applyDiscount2(new ArrayList<>(allOrderItems), menuMap));
    minPrice = Math.min(minPrice, applyDiscount3(new ArrayList<>(allOrderItems), menuMap));
    minPrice = Math.min(minPrice, applyDiscount4(new ArrayList<>(allOrderItems), menuMap));

    return minPrice;
  }

  private int getUnitPrice(OrderItem item, Map<String, Pizza> menuMap) {
    Pizza pizza = menuMap.get(item.name);
    if (item.size.equals("Small")) return pizza.price_S;
    if (item.size.equals("Medium")) return pizza.price_M;
    if (item.size.equals("Large")) return pizza.price_L;
    return 0;
  }

  private int applyDiscount1(List<OrderItem> orderItems, Map<String, Pizza> menuMap) {
    if (orderItems.size() < 3) return orderItems.stream().mapToInt(item -> getUnitPrice(item, menuMap)).sum();
    int minPrice = orderItems.stream().mapToInt(item -> getUnitPrice(item, menuMap)).min().orElse(0);
    return orderItems.stream().mapToInt(item -> getUnitPrice(item, menuMap)).sum() - minPrice;
  }

  private int applyDiscount2(List<OrderItem> orderItems, Map<String, Pizza> menuMap) {

    List<Integer> allPrices = orderItems.stream()
        .map(item -> getUnitPrice(item, menuMap))
        .collect(Collectors.toList());

    int originalTotal = allPrices.stream().mapToInt(i -> i).sum();
    int bestTotal = originalTotal;

    Map<String, List<OrderItem>> grouped = orderItems.stream()
        .collect(Collectors.groupingBy(item -> item.name));

    for (String name : grouped.keySet()) {
      List<OrderItem> items = grouped.get(name);
      if (items.size() < 5) continue;

      items.sort((a, b) -> Integer.compare(getUnitPrice(b, menuMap), getUnitPrice(a, menuMap)));
      List<OrderItem> discountedItems = items.subList(0, 5);

      List<OrderItem> remaining = new ArrayList<>(orderItems);
      remaining.removeAll(discountedItems);

      int discountedTotal = 100 + remaining.stream()
          .mapToInt(item -> getUnitPrice(item, menuMap))
          .sum();

      bestTotal = Math.min(bestTotal, discountedTotal);
    }

    return bestTotal;
  }

  private int applyDiscount3(List<OrderItem> orderItems, Map<String, Pizza> menuMap) {
    Map<String, Long> largeCounts = orderItems.stream()
        .filter(item -> "Large".equals(item.size))
        .collect(Collectors.groupingBy(item -> item.name, Collectors.counting()));

    Map<String, List<OrderItem>> smallItemsByName = orderItems.stream()
        .filter(item -> "Small".equals(item.size))
        .collect(Collectors.groupingBy(item -> item.name));

    int discount = 0;

    for (Map.Entry<String, Long> entry : largeCounts.entrySet()) {
      String pizzaName = entry.getKey();
      long largeCount = entry.getValue();

      List<OrderItem> smallItems = smallItemsByName.getOrDefault(pizzaName, new ArrayList<>());
      smallItems.sort(Comparator.comparingInt(item -> getUnitPrice(item, menuMap)));

      for (int i = 0; i < Math.min(largeCount, smallItems.size()); i++) {
        discount += getUnitPrice(smallItems.get(i), menuMap);
      }
    }

    int total = orderItems.stream().mapToInt(item -> getUnitPrice(item, menuMap)).sum();
    return total - discount;
  }

  private int applyDiscount4(List<OrderItem> orderItems, Map<String, Pizza> menuMap) {
    List<OrderItem> largeItems = orderItems.stream().filter(item -> "Large".equals(item.size)).collect(Collectors.toList());
    if (largeItems.size() < 3) {
      return orderItems.stream().mapToInt(item -> getUnitPrice(item, menuMap)).sum();
    }

    int minDiscounted = Integer.MAX_VALUE;
    int n = largeItems.size();
    for (int i = 0; i < (1 << n); i++) {
      if (Integer.bitCount(i) == 3) {
        int currentTotal = orderItems.stream().mapToInt(item -> getUnitPrice(item, menuMap)).sum();
        int discount = 0;
        List<OrderItem> discountedItems = new ArrayList<>();
        for (int j = 0; j < n; j++) {
          if ((i >> j) % 2 == 1) {
            discountedItems.add(largeItems.get(j));
          }
        }
        int originalPrice = discountedItems.stream().mapToInt(item -> getUnitPrice(item, menuMap)).sum();
        int discountedPrice = discountedItems.stream()
            .mapToInt(item -> menuMap.get(item.name).price_M)
            .sum();
        minDiscounted = Math.min(minDiscounted, currentTotal - originalPrice + discountedPrice);
      }
    }
    return minDiscounted == Integer.MAX_VALUE ? orderItems.stream().mapToInt(item -> getUnitPrice(item, menuMap)).sum() : minDiscounted;
  }

}
