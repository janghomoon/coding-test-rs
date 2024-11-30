package org.example.progammers.dfs;

public class TargetNumber {
  public static void main(String[] args) {

  }

  static int answer = 0;
  public static int solution(int[] numbers, int target) {
    dfs(numbers, 0, target, 0);

    return answer;
  }
  public static void dfs(int[] numbers, int depth, int target, int sum){//깊이 우선 탐색 알고리즘
    // numbers : 알고리즘을 실행할 대상 배열
    // depth : 노드의 깊이   배열 LENGTH? d
    // target : 타겟 넘버  3
    // sum : 이전 노드 까지의 결과 값
    if(depth == numbers.length){//5
      if(target == sum) {
        answer++;
      }
    }else {//탐색 노드 남은 경우
      //재귀 근데 똑같은걸 왜 2번 호출하지?
      dfs(numbers, depth + 1, target, sum + numbers[depth]); // 해당 노드의 값을 더하고 다음 깊이 탐색
      dfs(numbers, depth + 1, target, sum - numbers[depth]); // 해당 노드의 값을 빼고 다음 깊이 탐색
    }
  }
}
