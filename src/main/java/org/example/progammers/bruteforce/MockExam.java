package org.example.progammers.bruteforce;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MockExam
{
  public static void main( String[] args ) {
    int[] naswsers = {1,2,3,4,5};
    solution(naswsers);
  }
  public static int[] solution(int[] answers) {
    int[] answer = {};
    List<Integer> list = new ArrayList<Integer>();
    int[] arr1 = {1,2,3,4,5};
    int[] arr2 = {2,1,2,3,2,4,2,5};
    int[] arr3 = {3,3,1,1,2,2,4,4,5,5,};
    int[] cnt = new int[3];

    for(int i = 0 ; i < answers.length ; i++){
      if(answers[i] == arr1[i%arr1.length]) cnt[0]++;
      if(answers[i] == arr2[i%arr2.length]) cnt[1]++;
      if(answers[i] == arr3[i%arr3.length]) cnt[2]++;
    }

    int[] tmp = new int[cnt.length];
    for(int i = 0 ; i < cnt.length; i++){
      tmp[i] = cnt[i];
    }

    Arrays.sort(tmp);

    for(int i = 0 ; i < cnt.length; i++){
      if(cnt[i] == tmp[2]){
        list.add(i + 1);
      }
    }

    answer = new int[list.size()];

    for(int i = 0 ; i < answer.length; i++){
      answer[i] = list.get(i);
    }
    return answer;
  }

}
