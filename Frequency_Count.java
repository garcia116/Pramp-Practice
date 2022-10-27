import java.util.*;
import java.io.*;
public class MyClass {
    public static void frequency_count(String str){
        Map<String, Integer> map = new HashMap<>();
        
        String arr[] = str.split(" ");
        
        for(int i=0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else{
                map.put(arr[i], 1);
            }
        }
        
        for(Map.Entry<String,Integer> entry:
                    map.entrySet())
        {
            System.out.println(entry.getKey()+
                    " - "+entry.getValue());
        }
    }
    public static void main(String args[]) {
      String text = "I am practicing for my interview and I really want to impress the company so I am going to work hard to get better at what I do.";
      frequency_count(text);
    }
}
