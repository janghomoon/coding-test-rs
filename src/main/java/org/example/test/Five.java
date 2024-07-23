package org.example.test;

public class Five {
//  static int maxRowNum =0;
//  static int maxColNum =0;
//  static int rowRightStartNum=0;
//  static int rowLeftStartNum=0;
//  static int rowStartNum =0;
//  static int rowEndNum =0;
  static int[][] answer;
  public static void main(String[] args) {
    int[] length = {3,2};
    int n = 1;
    for (int idx=0; idx< length.length;idx++) {
      n *=length[idx];
    }
    answer = new int[n][n];//정사각형
    //9번 돌아야함
    //nn
    int boxCount = (n*n)/ (length[0]*length[0]);
    System.out.println(boxCount);
    //4번 그림
    int MaxRowNum=length[0];
    int MaxColNum=length[0];
    int startRowNum=length[0];
    int startColNum=length[0];
    for (int idx =0; idx< boxCount; idx++) {//4번 반복
      if (idx != 0) {
        //col <
        MaxRowNum=length[0];
//        MaxColNum=length[0]*;
      }

          //박스 그리기
//        if(idx ==0) {
//          //오른쪽 이동 시
////          MaxRowNum=length[0]*2;
////          MaxColNum=length[0]*2;
//          //우측 하단 이독 시
//          //
//        }
        //rowNum
      //colnum
//      for (int i=)
    }

  }
  private static void fillSnail() {

  }
  private static boolean isRightEnd(int n, int maxRowNum, int maxColNum) {

    return false;
  }



}
