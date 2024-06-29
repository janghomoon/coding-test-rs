package org.example.chapter1;

import java.util.Scanner;

public class SaltBomb {

  //소금폭탄 문제  예제 문제 중에 가장 어려움 @@@@@
  //
//  첫째 줄에는 현재 시각이 hh:mm:ss로 주어진다. 시간의 경우 0≤h≤23 이며, 분과 초는 각각 0≤m≤59, 0≤s≤59 이다.
//  두 번째 줄에는 소금 투하의 시간이 hh:mm:ss로 주어진다.
//  로봇팔이 소금을 투하할때까지 필요한 시간을 hh:mm:ss로 출력한다. 이 시간은 1초보다 크거나 같고, 24시간보다 작거나 같다.
  // 첫 줄 현 재시작
  // 두번째 줄 투하 시간
  //결과 값은 시간차이

//  public void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    String nowTimeInput = scanner.next();
//    String dropTimeInput = scanner.next();
//    String[] nowTimeArr = nowTimeInput.split(":");
//    String[] dropTimeArr = dropTimeInput.split(":");
//    int nowHour = Integer.parseInt(nowTimeArr[0]);
//    int nowMin = Integer.parseInt(nowTimeArr[1]);
//    int nowSec = Integer.parseInt(nowTimeArr[2]);
//
//    int dropHour = Integer.parseInt(dropTimeArr[0]);
//    int dropMin = Integer.parseInt(dropTimeArr[1]);
//    int dropSec = Integer.parseInt(dropTimeArr[2]);
//
//    int compareHour = nowHour - dropHour;
//    int compareMin = nowMin - dropMin;
//    int compareSec = nowSec - dropSec;
//    //방법 1
//    //각 단위  음수가 나오면 더 큰 단위에서 내림하여 가져온다
//    if (compareSec < 0) {
//      compareSec += 60;
//      compareMin--;
//    }
//    if (compareMin < 0) {
//      compareMin += 60;
//      compareHour--;
//    }
//    if (compareHour < 0) {
//      compareHour += 24;
//    }
//    String output = "";
//    if (compareHour < 10) {
//      output += "0" + compareHour + ":";
//    }
//    if (compareMin < 10) {
//      output += "0" + compareMin + ":";
//    }
//
//    if (compareSec < 10) {
//      output += "0" + compareSec;
//    }
//    System.out.println(output);
//  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String nowTimeInput = scanner.next();
    String dropTimeInput = scanner.next();
    String[] nowTimeArr = nowTimeInput.split(":");
    String[] dropTimeArr = dropTimeInput.split(":");

    //모두 초로 환산
    int nowHour = Integer.parseInt(nowTimeArr[0]);
    int nowMin = Integer.parseInt(nowTimeArr[1]);
    int nowSec = Integer.parseInt(nowTimeArr[2]);
    int nowTotalSec = (nowHour*60*60) + (nowMin*60) + nowSec;

    int dropHour = Integer.parseInt(dropTimeArr[0]);
    int dropMin = Integer.parseInt(dropTimeArr[1]);
    int dropSec = Integer.parseInt(dropTimeArr[2]);

    int dropTotalSec = (dropHour*60*60) + (dropMin*60) + dropSec;// 하루 뒤 시간 계산시 맞지 않음

    int compareSec = dropTotalSec - nowTotalSec;
    if (compareSec <= 0) compareSec += 24*3600;

    int hour = compareSec / 3600;
    int min =  (compareSec % 3600)/ 60;
    int sec =  (compareSec % 3600) % 60;

    System.out.printf(String.format("%s:%s:%s", addZero(hour), addZero(min), addZero(sec)));

  }
  public static  String addZero(int target) {
    if (target < 10) return "0" + target;
    return String.valueOf(target);
  }

//  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    String nowTimeInput = scanner.next();
//    String dropTimeInput = scanner.next();
//    String[] nowTimeArr = nowTimeInput.split(":");
//    String[] dropTimeArr = dropTimeInput.split(":");
//    int nowHour = Integer.parseInt(nowTimeArr[0]);
//    int nowMin = Integer.parseInt(nowTimeArr[1]);
//    int nowSec = Integer.parseInt(nowTimeArr[2]);
//    int nowAmountSec = nowHour * 3600 + nowMin * 60 + nowSec;
//    int dropHour = Integer.parseInt(dropTimeArr[0]);
//    int dropMin = Integer.parseInt(dropTimeArr[1]);
//    int dropSec = Integer.parseInt(dropTimeArr[2]);
//
//    int dropAmountSec = dropHour * 3600 + dropMin * 60 + dropSec;
//    int compareAmountSec = dropAmountSec - nowAmountSec;
//    //어렵다
//    if (compareAmountSec <= 0) {
//      compareAmountSec += 24 * 3600;
//    }
//
//    int outputHour = compareAmountSec / 3600;
//    int outputMin = (compareAmountSec % 3600) / 60;
//    int outputSec = compareAmountSec % 60;
//
//    //smart 출력 법
//    String output = String.format("%02d:%02d:%02d", outputHour, outputMin, outputSec);
//    System.out.println(output);
//  }

  private String setOutput(int hour, int min, int sec) {
    String output = "";
    if (hour < 10 ) {
      output += "0" + hour + ":";
    }
    if (min < 10) {
      output += "0" + min + ":";
    }
    if (sec < 10 ) {
      output += "0" + sec;
    }
    return output;
  }

}
