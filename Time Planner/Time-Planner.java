import java.io.*;
import java.util.*;

class Solution {

  static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
    int ptA = 0;
    int ptB = 0;
    
    while(ptA < slotsA.length && ptB < slotsB.length){
      int start = Math.max(slotsA[ptA][0], slotsB[ptB][0]);
      int end = Math.min(slotsA[ptA][1], slotsB[ptB][1]);
      
      if(end - start >= dur){
        return new int[] {start, start + dur};
      } 
      if(slotsA[ptA][1] < slotsB[ptB][1]){
        ptA++;
      }
      else{
        ptB++;
      }
    }
    return new int[] {};
  }

  public static void main(String[] args) {

  }

}
