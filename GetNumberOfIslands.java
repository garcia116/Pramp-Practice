/*
Island Count
Given a 2D array binaryMatrix of 0s and 1s, implement a function getNumberOfIslands that returns the number of islands of 1s in binaryMatrix.

An island is defined as a group of adjacent values that are all 1s. A cell in binaryMatrix is considered adjacent to another cell if they are next to each either on the same row or column. Note that two values of 1 are not part of the same island if they’re sharing only a mutual “corner” (i.e. they are diagonally neighbors).

Explain and code the most efficient solution possible and analyze its time and space complexities.

Example:

input:  binaryMatrix = [ [0,    1,    0,    1,    0],
                         [0,    0,    1,    1,    1],
                         [1,    0,    0,    1,    0],
                         [0,    1,    1,    0,    0],
                         [1,    0,    1,    0,    1] ]

output: 6 # since this is the number of islands in binaryMatrix.
          # See all 6 islands color-coded below.
alt

Constraints:

[time limit] 5000ms

[input] array.array.int binaryMatrix

1 ≤ binaryMatrix.length ≤ 100
1 ≤ binaryMatrix[i].length ≤ 100
[output] integer
*/

import java.io.*;
import java.util.*;

class Solution {

  static int getNumberOfIslands(int[][] binaryMatrix) {
    int m = binaryMatrix.length;
    int n = binaryMatrix[0].length;
    int count = 0;
    
    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){
        if(binaryMatrix[i][j] == 1){
          count += 1;
          merge(binaryMatrix, i, j);
        }
      }
    }
    return count;
  }
  
  static void merge(int[][] binaryMatrix, int i, int j){
    int m = binaryMatrix.length;
    int n = binaryMatrix[0].length;
    
    if(i<0 || i>=m || j<0 || j>=n || binaryMatrix[i][j] != 1) 
      return;
    
    binaryMatrix[i][j] = 0;
    
    merge(binaryMatrix, i-1, j);
    merge(binaryMatrix, i+1, j);
    merge(binaryMatrix, i, j-1);
    merge(binaryMatrix, i, j+1);
  }

  public static void main(String[] args) {
    int grid[][]={
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}};
    
   getNumberOfIslands(grid);
  }

}
