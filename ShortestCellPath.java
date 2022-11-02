/*
Shortest Cell Path

In a given grid of 0s and 1s, we have some starting row and column sr, sc and a target row and column tr, tc. Return the length of the shortest path from sr, sc to tr, tc that walks along 1 values only.

Each location in the path, including the start and the end, must be a 1. Each subsequent location in the path must be 4-directionally adjacent to the previous location.

It is guaranteed that grid[sr][sc] = grid[tr][tc] = 1, and the starting and target positions are different.

If the task is impossible, return -1.

Examples:

input:
grid = [[1, 1, 1, 1], [0, 0, 0, 1], [1, 1, 1, 1]]
sr = 0, sc = 0, tr = 2, tc = 0
output: 8
(The lines below represent this grid:)
1111
0001
1111

grid = [[1, 1, 1, 1], [0, 0, 0, 1], [1, 0, 1, 1]]
sr = 0, sc = 0, tr = 2, tc = 0
output: -1
(The lines below represent this grid:)
1111
0001
1011
*/

import java.util.*;
import java.io.*;

public class MyClass {
    
    public static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
       
    
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        System.out.println(sr);
        queue.add(new int[]{sr, sc, 0});

        int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    
        while(!queue.isEmpty()){
            
            int[] curPos = queue.poll();
            int distance = curPos[2];
           
            if(curPos[0] == tr && curPos[1] == tc){
                return distance;
            }
           
            for(int[] dir: dirs){
                int nextX = curPos[0] + dir[0];
                int nextY = curPos[1] + dir[1];

                if(nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && grid[nextX][nextY] != 0){
                    queue.offer(new int[]{nextX, nextY, distance+1});
                    grid[nextX][nextY] = 0;
                }
            }
        }
        
        return -1;
    }
    public static void main(String args[]) {
        int[][] grid = new int[][] {
      		{1, 1, 1, 1}, 
      		{0, 0, 0, 1}, 
      		{1, 1, 1, 1}
    	};
    	System.out.println(shortestCellPath(grid, 0, 0, 2, 0));
    }
}
