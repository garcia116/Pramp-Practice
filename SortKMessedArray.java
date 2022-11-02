/*
K-Messed Array Sort

Given an array of integers arr where each element is at most k places away from its sorted position, code an efficient function sortKMessedArray that sorts arr. For instance, for an input array of size 10 and k = 2, an element belonging to index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.

Analyze the time and space complexities of your solution.

Example:

input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2

output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

*/


import java.util.*;

public class MyClass {
       
    public static int[] sortKMessedArray(int[] arr, int k){
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // Add first k+1 elements in heap
        for(int i=0; i <= k; i++){
            queue.add(arr[i]);
        }
        
        int index = 0;
        // Add elements from heap back to array and add new elements from array in heap
        for(int i=k+1; i < arr.length; i++){
            arr[index++] = queue.poll();
            queue.add(arr[i]);
        }
        
        // Add remaining elements in heap to end of the array
        while(!queue.isEmpty()){
            arr[index++] = queue.poll();
        }
        
        return arr;
    }
    
    public static void main(String[] main){

        int[] arr = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
        sortKMessedArray(arr, 2);
        
        for(int n: arr){
            System.out.println(n);
        }
    }
}
