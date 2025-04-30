package org.example.test_preparation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShortestPath {
  private static final int INF = Integer.MAX_VALUE;
  private static ArrayList<ArrayList<Node>> graph;
  private static int n;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    int e = scanner.nextInt();

    graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < e; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int c = scanner.nextInt();
      graph.get(a).add(new Node(b, c));
      graph.get(b).add(new Node(a, c));
    }

    int v1 = scanner.nextInt();
    int v2 = scanner.nextInt();

    // 1 -> v1 -> v2 -> n 경로와 1 -> v2 -> v1 -> n 경로를 비교
    int path1 = 0;
    int dist1_1 = dijkstra(1, v1);
    int dist1_2 = dijkstra(v1, v2);
    int dist1_3 = dijkstra(v2, n);

    if (dist1_1 == INF || dist1_2 == INF || dist1_3 == INF) {
      path1 = INF;
    } else {
      path1 = dist1_1 + dist1_2 + dist1_3;
    }

    int path2 = 0;
    int dist2_1 = dijkstra(1, v2);
    int dist2_2 = dijkstra(v2, v1);
    int dist2_3 = dijkstra(v1, n);

    if (dist2_1 == INF || dist2_2 == INF || dist2_3 == INF) {
      path2 = INF;
    } else {
      path2 = dist2_1 + dist2_2 + dist2_3;
    }

    int result = Math.min(path1, path2);

    if (result == INF) {
      System.out.println(-1);
    } else {
      System.out.println(result);
    }

    scanner.close();
  }

  private static int dijkstra(int start, int end) {
    int[] dist = new int[n + 1];
    Arrays.fill(dist, INF);
    dist[start] = 0;
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node current = pq.poll();
      int u = current.vertex;
      int d = current.distance;

      if (d > dist[u]) {
        continue;
      }

      for (Node neighbor : graph.get(u)) {
        int v = neighbor.vertex;
        int weight = neighbor.distance;
        if (dist[u] + weight < dist[v]) {
          dist[v] = dist[u] + weight;
          pq.offer(new Node(v, dist[v]));
        }
      }
    }
    return dist[end];
  }

  static class Node implements Comparable<Node> {
    int vertex;
    int distance;

    public Node(int vertex, int distance) {
      this.vertex = vertex;
      this.distance = distance;
    }

    @Override
    public int compareTo(Node other) {
      return this.distance - other.distance;
    }
  }
}
