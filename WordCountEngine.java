/*
Word Count Engine
Implement a document scanning function wordCountEngine, which receives a string document and returns a list of all unique words in it and their number 
of occurrences, sorted by the number of occurrences in a descending order. If two or more words have the same count, they should be sorted according 
to their order in the original sentence. Assume that all letters are in english alphabet. You function should be case-insensitive, so for instance, 
the words “Perfect” and “perfect” should be considered the same word.

The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.

Analyze the time and space complexities of your solution. Try to optimize for time while keeping a polynomial space complexity.

Examples:

input:  document = "Practice makes perfect. you'll only
                    get Perfect by practice. just practice!"

output: [ ["practice", "3"], ["perfect", "2"],
          ["makes", "1"], ["youll", "1"], ["only", "1"], 
          ["get", "1"], ["by", "1"], ["just", "1"] ]
Important: please convert the occurrence integers in the output list to strings (e.g. "3" instead of 3). We ask this because in compiled languages 
such as C#, Java, C++, C etc., it’s not straightforward to create mixed-type arrays (as it is, for instance, in scripted languages like JavaScript,
Python, Ruby etc.). The expected output will simply be an array of string arrays.

Constraints:

[time limit] 5000ms
[input] string document
[output] array.array.string
*/

import java.io.*;
import java.util.*;

class Solution {

  public static String cleanUpWord(String word){
    StringBuilder builder = new StringBuilder();
    for(char ch : word.toCharArray()){
      if(Character.isLetterOrDigit(ch)){
        builder.append(Character.toLowerCase(ch));
      }
    }
    return builder.toString();
  }
  
  static String[][] wordCountEngine(String document) {
    // your code goes here
    String[] newDoc = document.split(" ");
    Map<String, Integer> map = new HashMap<>();
    List<String> listStr = new ArrayList<>();
    int maxCounter = 0;
    
    for(String token : newDoc){
      // remove punctuations, extra space & lowercase
      String word = cleanUpWord(token);
      if(word.length() == 0) continue;
      if(!map.containsKey(word)){
        listStr.add(word);
        map.put(word, 1);
      }
      else{
        map.put(word, map.get(word) + 1);
      }
      
      maxCounter = Math.max(map.get(word), maxCounter);
    }
    
    List<List<String>> list = new ArrayList<>();
    for(int i=0; i < maxCounter+1; i++){
      list.add(new ArrayList<String>());
    }
    
    for(String word : listStr){
      list.get(map.get(word)).add(word);
     // System.out.println(list);
    }
    
    String[][] result = new String[listStr.size()][2];
    int counter = 0;
    for(int i = list.size()-1; i >= 0; i--){
      if(list.get(i).size() != 0){
        for(String word : list.get(i)){
          result[counter][0] = word;
          result[counter][1] = String.valueOf(i);
          counter++;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
  String document = "Every book is a quotation; and every house is a quotation out of all forests, and mines, and stone quarries; and every man is a quotation from all his ancestors. ";
    String[][] res = wordCountEngine(document);
     for(int i = 0 ; i<res.length; i++) {
       System.out.println(res[i][0] + " " + res[i][1]);
     }
  }

}
