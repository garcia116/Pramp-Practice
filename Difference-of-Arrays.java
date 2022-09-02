/*
Difference of Arrays

Write a function diff(arrA, arrB) that accepts two arrays and returns a new array that contains all values that are not contained in both input arrays. The order of numbers in the result array does not matter.

Examples
a = [1, 2, 3, 4]
b = [3, 4, 5, 6]

diff(a, b) # => [1, 2, 5, 6]
Note: we don't care if numbers are out of order or repeated; for example, these two arrays are equivalent since they are re-arrangements of the same values:

a = [1, 2, 1]
b = [2, 1, 2]

diff(a, b) # => []


*/

import java.util.HashSet;
public class MyClass {
     public static void diff(int[] arrA, int[] arrB){
        HashSet<Integer> set = new HashSet<>();
        for(int num : arrA){
            set.add(num);
        }
        for(int num : arrB){
            if(!set.contains(num)){
                set.add(num);
            }
            else{
                set.remove(num);
            }
        }
        
        for(int i : set){
            System.out.println(i);
        }
    }
    
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {3, 4, 5, 6};
        diff(a, b);
    }
}
