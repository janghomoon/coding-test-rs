package org.example.test_preparation;
import java.util.Arrays;
import java.util.HashMap;


public class Athletes {
  public static void main(String[] args) {
    String[] participant = {"A", "B", "C", "D", "E", "F", "G", "H"};
    String[] completion = new String[5];

    solution(participant, completion);
  }

  public static String solution(String[] participant, String[] completion) {
    HashMap<String, Integer> participantMap = new HashMap<>();

    // 참가자 명단을 HashMap에 저장 (동명이인 처리)
    for (String p : participant) {
      participantMap.put(p, participantMap.getOrDefault(p, 0) + 1);
    }
    // 완주자 명단을 순회하며 참가자 HashMap에서 인원수 감소
    for (String c : completion) {
      if (participantMap.containsKey(c)) {
        participantMap.put(c, participantMap.get(c) - 1);
        // 완주자 수가 참가자 수와 같아지면 HashMap에서 제거 (최적화)
        if (participantMap.get(c) == 0) {
          participantMap.remove(c);
        }
      }
    }
    // HashMap에 남아있는 key가 완주하지 못한 선수
    return participantMap.keySet().iterator().next();
  }

}
