package org.example.chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencySorting {

  static class Message {
    int num;
    int index;

    Message(int num, int index) {
      this.num = num;
      this.index = index;
    }
  }
  static class Frequency {
    int num;
    int count;
    int firstIndex;

    Frequency(int num, int count, int firstIndex) {
      this.num = num;
      this.count = count;
      this.firstIndex = firstIndex;
    }
  }

  //빈도 정렬
  //N 입력 배열 수
  //C 수열  ex 3  1 2 3
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int C = scanner.nextInt();
    Message[] messages = new Message[N];
//    int[] C = new int[N];
    for (int i = 0; i < N; i++) {
      messages[i] = new Message(scanner.nextInt(), i);
    }
    Arrays.sort(messages, new Comparator<Message>() {
      @Override
      public int compare(Message o1, Message o2) {
        return o1.num - o2.num;
      }
    });

    Frequency[] frequency = new Frequency[N];
    int frequencyIndex = 0;
    frequency[frequencyIndex] = new Frequency(messages[0].num, 1, messages[0].index);
    for (int i = 1; i < N; i++) {
      if (messages[i].num != frequency[i-1].num) {
        frequency[++frequencyIndex] = new Frequency(messages[i].num, 0, messages[i].index);
        frequency[frequencyIndex].count++;
      }
    }
    //+1
    Arrays.sort(frequency, 0, frequencyIndex + 1, new Comparator<Frequency>() {
      @Override
      public int compare(Frequency o1, Frequency o2) {
        if (o1.count == o2.count) {return  o1.firstIndex - o2.firstIndex;}
        return o2.count - o1.count;
      }
    });
    for (int i = 0; i < frequencyIndex; i++) {
      while (frequency[i].count -- >0) {
        System.out.println(frequency[i].count + " ");
      }
    }








  }
  //LinnkHashMap을 사용하면 put한 순서대로 key가 유지되고 Integer[]로 Tim Sort를 사용하면 stable하기 때문에
  //frequency가 같다면 먼저put  된 key가 앞에 위치한다.
  //
  public static void mapWay() {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int C = sc.nextInt();
    Map<Integer, Integer> map = new LinkedHashMap<>();
    for (int i = 0; i < N; i++) {
      int message = sc.nextInt();
      map.put(message, map.getOrDefault(message, 0)+1);
    }

    //keyset 정렬
    Integer[] frequency = map.keySet().toArray(new Integer[map.size()]);
    Arrays.sort(frequency, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
  //        if ()
          //keyset 가져올떄 이미 ㄹ이크드 해쉬맵 통해 빈돗 같으면 앞에 입력이 먼저 나오게 되어 있음
          return map.get(o2)- map.get(o1);//빈도수 내림차순
        }
      });
    for(int frequency1 : frequency) {
      int count = map.get(frequency1);
      while (count-- > 0) {
        System.out.print(frequency1 + " ");
      }
    }

  }
  //
  //
  //
}
