package org.example.chapter1;

import java.util.Scanner;

public class Ant {

  //2차원 배열  우측 / 좌측 끝에 도달 하면 상단
  //2차원 배열  상단 도달 시 아래로 이동
//  public static void main(String[] args) {
//
//    Scanner scanner = new Scanner(System.in);
//    String totalPoint = scanner.nextLine();
//    String startPoint = scanner.nextLine();
//    int moveTime = scanner.nextInt();
//
//    String[] totalPointArray = totalPoint.split("");
//    String[] startPointArray = startPoint.split("");
//    int [][] totalArray = new int[Integer.parseInt(totalPointArray[0])][Integer.parseInt(
//        totalPointArray[1])];
////    int [][] startArray = new int[startPointArray[0]][startPointArray[1]];
////    int startX = startPointArray[0];
////    int startY = startPointArray[1];
//
////    int moveCount = 0;
//    int currentX = Integer.parseInt(startPointArray[0]);
//    int currentY = Integer.parseInt(startPointArray[1]);
//    int deltaX = 1;//이동시 더해줄 값
//    int deltaY = 1;//이동시 더해줄 값
//
//    for (int idx =0; idx < moveTime; idx ++ ) {
//      if (currentX == Integer.parseInt(totalPointArray[0])) deltaX = -1;
//      else if (currentX == 0) deltaX = 1;
//      else if (currentY == Integer.parseInt(totalPointArray[1])) deltaY = 1;
//      else if(currentY == 0) deltaY = -1;
//
//      currentX += deltaX;
//      currentY += deltaY;
//
//    }
//    System.out.printf(currentX + " " + currentY);
//
//  }

  //X 축증감 감소
  // Y 축 증감 감소
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int maxWidth = scanner.nextInt();
    int maxHeight = scanner.nextInt();
    int inputWidth = scanner.nextInt();
    int inputHeight = scanner.nextInt();
    int time = scanner.nextInt();



    //사이클 주기
    int timeX = time % (2*maxWidth);
    int deltaX = 1;
    int currentX = inputWidth;
    while (timeX-- > 0) {
      if(currentX == inputWidth) deltaX = -1;
      else if (currentX == 0) deltaX = 1;
      currentX += deltaX;
    }


    int timeY = time % (2*maxHeight);
    int deltaY = 1;
    int currentY = inputHeight;

    while (timeY-- > 0) {
      if (currentY == inputHeight) deltaY = -1;
      else if (currentY == 0) deltaY = 1;
      currentY += deltaY;
    }

    System.out.printf(currentX +  " " + currentY);



  }

//  public static void t() {
//    Scanner scanner = new Scanner(System.in);
//    int maxWidth = scanner.nextInt();
//    int maxHeight = scanner.nextInt();
//    int inputWidth = scanner.nextInt();
//    int inputHeight = scanner.nextInt();
//    int time = scanner.nextInt();
//    int currentX = (time+ inputWidth) %(2*maxWidth);
//    int currentY = (time+ inputHeight) %(2*maxHeight);
//    if (currentX > maxWidth) currentX = 2 * maxWidth - currentX;
//    if (currentY > maxHeight) currentY = 2 * maxHeight - currentY;
//    System.out.printf(currentX +  " " + currentY);
//  }


}
