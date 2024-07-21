package org.example.chapter5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CoordinateCompression {
  //좌표 압축
  //N개 좌표
  //입력된 좌표 중 몇 번째 좌표인지 출력
  //좌 표 입력됨
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    // coordinate

    int[][] coordinateArr = new int[N][2];
    //입력된 좌표를 작은 순으로 정렬 (인덱스와 함께)
    for (int i = 0; i < N; i++) {
      coordinateArr[i][0] = scanner.nextInt();//입력 값
      coordinateArr[i][1] = i;//입력순서
    }
    Arrays.sort(coordinateArr, Comparator.comparingInt(o -> o[0]));


    //정렬된 좦쇼를 중복을 제거 압출된 인덱스를 기록
//    (이때 ans에 해당 좌표의 압출 인덱스를 저장)
    int [] answoerArr = new int[N];
    int idx = 0;
    answoerArr[coordinateArr[0][1]] = idx;//0번 값
    for (int i = 1; i < N; i++) {
      if(coordinateArr[i][0] != coordinateArr[i-1][0]) {
        idx ++;
      }
      answoerArr[coordinateArr[i][1]] = idx;
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for(int i = 0; i < N; i++) {
      bw.write(answoerArr[i] + " ");
//      System.out.print(answoerArr[i] + " ");
    }
    bw.write("\n");
    bw.flush();
  }

  //set을 이용한 중복제거
  //
  public void toSet (int N) {
    Scanner sc= new Scanner(System.in);
    Set<Integer> set = new TreeSet<>();
    //tress set 순회 , set 중복 제거
    int[] xs = new int[N];
    for (int i = 0; i < N; i++) {
      xs[i] = sc.nextInt();
      set.add(xs[i]);
    }
    Map<Integer, Integer> sortedmap = new HashMap<>();
    int idx = 0;
    for(int x : set) {
      sortedmap.put(x, idx++);
    }
    for( int i=0; i < N; i++) {
      System.out.print(sortedmap.get(xs[i]) + " ");
    }
  }


}
