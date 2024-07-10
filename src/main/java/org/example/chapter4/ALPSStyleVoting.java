package org.example.chapter4;

import java.util.Scanner;

public class ALPSStyleVoting {
  //알프스 식
  //1. 전체 득표수의 5% 미만의 스태프를 후보에서 제외한다.
  //2. 남은 스태프마다 받은 득표수를 1-14로 나눈 점수를 구한다.
  //3. 전체 점수 집합에서 점수가 큰 1-14번째 스태프에게 칩을 1개씩 지급한다.
  //4 스태프 이름에 대해 사전순으로 후보 스태프와 받은 칩의 수를 출력한다.
  static class Score {
    int staffIndex;
    double scr;

    public Score(int staffIndex, double scr) {
      this.staffIndex = staffIndex;
      this.scr = scr;
    }
  }



  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int X = sc.nextInt();
    int N = sc.nextInt();

    //1. 전체 득표수의 5% 미만의 스태프를 후보에서 제외한다.
    double validCut = X * 0.05;
    boolean[] validCandidate = new boolean[26];//알파벳 수
    int[] staffVote = new int[26];
    int candidateCount = 0;
    for (int i = 0; i< N; i++) {
      String name = sc.next();
      int vote = sc.nextInt();
      if (vote >= validCut) {
        int index = name.charAt(0) - 'A';
        validCandidate[index] = true;
        staffVote[index]= vote;
        candidateCount++;
      }
    }
    //2. 남은 스태프마다 받은 득표수를 1-14로 나눈 점수를 구한다.
    Score[] scores = new Score[candidateCount * 14];
    int scoreIndex = 0;
    for (int i=0; i< 26; i++) {
      if (validCandidate[i]) {
        for (int j=1; j <=14; j++) {
          scores[scoreIndex++] = new Score(i, (double) staffVote[i] / j);
        }
      }
    }


    //3. 전체 점수 집합에서 점수가 큰 1-14번째 스태프에게 칩을 1개씩 지급한다.
    //sort
    sortScoresDescendingOrder(scores);
    int[] ans = new int[26];

    for (int i =0; i< 14; i++) {
      ans[scores[i].staffIndex]++;

    }

    for (int i=0; i< 25; i++) {
      if (validCandidate[i]) {
        System.out.println((char) (i+ 'A') + " " + ans[i]);
      }
    }

  }

  private static void sortScoresDescendingOrder(Score[] scores) {
    for (int i =0; i < scores.length; i++) {
      for (int j=0; j< i; j++) {
        if (scores[i].scr > scores[j].scr) {
          Score cur = scores[i];
          for(int k=i; k> j; k--) {
            scores[k] = scores[k-1];
          }
          scores[j] = cur;
        }
      }
    }
  }

}
