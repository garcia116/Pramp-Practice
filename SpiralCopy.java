/*
Matrix Spiral Copy
Given a 2D array (matrix) inputMatrix of integers, create a function spiralCopy that copies inputMatrix’s values into a 1D array in a spiral order, clockwise. Your function then should return that array. Analyze the time and space complexities of your solution.

Example:

input:  inputMatrix  = [ [1,    2,   3,  4,    5],
                         [6,    7,   8,  9,   10],
                         [11,  12,  13,  14,  15],
                         [16,  17,  18,  19,  20] ]

output: [1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12]
See the illustration below to understand better what a clockwise spiral order looks like.

altClockwise spiral order

Constraints:

[time limit] 5000ms

[input] array.array.integer inputMatrix

1 ≤ inputMatrix[0].length ≤ 100
1 ≤ inputMatrix.length ≤ 100
[output] array.integer
*/

class Solution {

  static int[] spiralCopy(int[][] inputMatrix) {
    // your code goes here  
    int[] result = new int[inputMatrix.length * inputMatrix[0].length];
    int index = 0;
    int rowBegin = 0;
    int rowEnd = inputMatrix.length-1;
    int colBegin = 0;
    int colEnd = inputMatrix[0].length - 1;

    while(rowBegin <= rowEnd && colBegin <= colEnd) {
        // Traverse Right
        for(int j = colBegin; j <= colEnd; j ++) {
            result[index++] = inputMatrix[rowBegin][j];
        }
        rowBegin++;

        // Traverse Down
        for(int j = rowBegin; j <= rowEnd; j ++) {
            result[index++] = inputMatrix[j][colEnd];
        }
        colEnd--;
      
        if(rowBegin <= rowEnd) {
            // Traverse Left
            for (int j = colEnd; j >= colBegin; j --) {
                result[index++] = inputMatrix[rowEnd][j];
            }
        }
        rowEnd--;

        if(colBegin <= colEnd) {
            // Traverse Up
            for (int j = rowEnd; j >= rowBegin; j --) {
                result[index++] = inputMatrix[j][colBegin];
            }
        }
        colBegin++;
    }

    return result;
  }

  public static void main(String[] args) {
      int[][] inputMatrix  =  { {1,    2,   3,  4,    5},
                               {6,    7,   8,  9,   10},
                               {11,  12,  13,  14,  15},
                               {16,  17,  18,  19,  20} };
    int[] result = spiralCopy(inputMatrix);
    for(int i=0; i < result.length; i++){
      System.out.println(result[i]);
    }
  }

}
