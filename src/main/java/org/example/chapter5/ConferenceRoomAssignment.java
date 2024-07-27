package org.example.chapter5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ConferenceRoomAssignment {

  //회의실 배정 그리디
  //N개의 회의 시간이 주어질 때 한 회의실에서 진행될 수 이쓴ㄴ 최대 회의 개수
  //1. 회의를 종료시간이 빠른 순으로 정렬
  //1-1. 종료시간이 같다면 시작시간이 빠른 순으로 정렬
  //2.가능한 회의부터 차례로진행
  static class Meetting {
    int start;
    int end;

    public Meetting(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
  public static void main(String[] args) throws IOException {// throws IOException
    System.setIn(new FileInputStream("src/main/java/org/example/file/input.txt"));
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();//회의 수
    Meetting[] meetings = new Meetting[N];
    for (int i = 0; i < N; i++) {
      meetings[i] = new Meetting(scanner.nextInt(), scanner.nextInt());
    }

    //1. 종료시간이 빠른 회의먼저
    //2. 종료시간이 같다면 시작시간이 빠른 회의 먼저
    Arrays.sort(meetings, new Comparator<Meetting>() {
      @Override
      public int compare(Meetting o1, Meetting o2) {
        if(o1.end == o2.end) return o1.start - o2.start;
        return o1.end - o2.end;
      }
    });

    int cnt = 0;
    int ended = 0;
    for(Meetting meetting : meetings) {
      if(ended <= meetting.start) {
        cnt++;
        ended = meetting.end;
      }
    }
    System.out.println(cnt);

  }
  //끝나는 시간이 빠른 회의 + 같다면 시작 시간이 빠른 회의부터 배치 하면 항상 최적으 ㅣ답을 구할 수 있을까?
  //끝나는 시간이 빠른 회의부터 배치(시작과 끝이 같은 회의를 제외 하고)
}
