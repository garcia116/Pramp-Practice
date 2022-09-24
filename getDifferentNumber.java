/*
Smallest Missing Integer

Given an array arr of unique nonnegative integers, implement a function getDifferentNumber that finds the smallest nonnegative integer that is NOT in the array.

Even if your programming language of choice doesn’t have that restriction (like Python), assume that the maximum value an integer can have is MAX_INT = 2^31-1. So, for instance, the operation MAX_INT + 1 would be undefined in our case.

Solve first for the case when you’re NOT allowed to modify the input arr. If successful and still have time, see if you can come up with an algorithm with an improved space complexity when modifying arr is allowed. Do so without trading off the time complexity.

Analyze the time and space complexities of your algorithm.

Example:

input:  arr = [0, 2, 1, 3, 5]

output: 4
*/

import java.io.*;
import java.util.*;

public class MyClass {
    
    public static int getDifferentNumber(int[] arr){
        if(arr.length == 0) return 0;
        
        Set<Integer> set = new HashSet<>();
        for(int i=0; i < arr.length; i++){
            set.add(arr[i]);
        }
        for(int i=0; i < arr.length; i++){
            if(!set.contains(i)) return i;
        }
        
        return arr.length;
    }
    
    // in-place solution
    public static int getDifferentNumber2(int[] arr){
        if(arr.length == 0) return 0;
        
        for(int i=0; i < arr.length; i++){
            int temp = arr[i];
            if(temp < arr.length && temp != arr[temp]){
                int temp2 = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp2;
            }
        }
        int i = 0;
        while(i < arr.length){
            if(i != arr[i]){
                return i;
            }
            i++;
        }
        
        return i;
    }
    
    public static void main(String args[]) {
        System.out.println(getDifferentNumber(new int[]{0, 2, 1, 3, 5}));
		    System.out.println(getDifferentNumber2(new int[]{0, 2, 1, 3, 5}));
    }
}
