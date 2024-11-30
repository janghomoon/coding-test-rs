package org.example.progammers.bruteforce;

public class Carpet {
  //1.약수를 구하고
  //2.가라가 큰값으로

  public static void main(String[] args) {
    solution(10, 2);
  }
  public static int[] solution(int brown, int yellow) {
    int[] answer = new int[2];

    for(int i=3;i<brown+yellow;i++){
      int width = (brown+yellow)/i;
      if(width>=i){
        if ((i - 2) * (width - 2) == yellow) {
          answer[0] = width;
          answer[1] = i;
          break;
        }
      }
    }
    return answer;
  }
}
