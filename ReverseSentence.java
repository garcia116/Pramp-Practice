/*
Reverse a Sentence

You are given an array of characters arrthat consists of sequences of characters separated by space characters. Each space-delimited sequence of characters defines a word. Implement a function reverseWords that reverses the order of the words in the array in the most efficient manner.

Explain your solution and analyze its time and space complexities.

Example:

input:  arr = [ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ',
                'm', 'a', 'k', 'e', 's', '  ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]

output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', '  ',
          'm', 'a', 'k', 'e', 's', '  ',
          'p', 'e', 'r', 'f', 'e', 'c', 't' ]

*/


import java.util.*;

public class MyClass {
   public static char[] reverseWords(char[] arr){
       mirrorReverse(arr, 0, arr.length-1);
       
       int wordStart = -1;
       for(int i=0; i < arr.length; i++){
           if(arr[i] == ' '){
               if(wordStart != -1){
                   mirrorReverse(arr, wordStart, i-1);
                   wordStart = -1;
               }
           }
           else if(i == arr.length-1){
               if(wordStart != -1){
                   mirrorReverse(arr, wordStart, i);
               }
           }
           else{
               if(wordStart == -1) wordStart = i;
           }
       }
       return arr;
   }
   
   public static void mirrorReverse(char[] arr, int start, int end){
       
       while(start < end){
           char tmp = arr[start];
           arr[start++] = arr[end];
           arr[end--] = tmp;
       }
   }
    
    
    public static void main(String args[]) {
        char[] arr = new char[]{'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', ' ',
								'm', 'a', 'k', 'e', 's', ' ', 
								'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
		System.out.println("original sentence: " + Arrays.toString(arr));
		System.out.println("reversed sentence: " + Arrays.toString(reverseWords(arr)));
    }
}
