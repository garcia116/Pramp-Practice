/*
Flatten a Dictionary

Example:

input:  dict = {
            "Key1" : "1",
            "Key2" : {
                "a" : "2",
                "b" : "3",
                "c" : {
                    "d" : "3",
                    "e" : {
                        "" : "1"
                    }
                }
            }
        }

output: {
            "Key1" : "1",
            "Key2.a" : "2",
            "Key2.b" : "3",
            "Key2.c.d" : "3",
            "Key2.c.e" : "1"
        }
*/

import java.util.HashMap;
import java.util.Map;

public class MyClass {
    public static Map<String,String> flattenDictionary(Map<String,Object> dictionary){
        Map<String, String> result = new HashMap<>();
        helper("", dictionary, result);
        
        return result;
    }
    
   public static void helper(String initial_key, Map<String, Object> dictionary, Map<String,String> result){
        for(String key: dictionary.keySet()){
            
            Object value = dictionary.get(key);
            
            if(value instanceof String) {
                if(initial_key == null || initial_key.equals("")){
                    result.put(key, String.valueOf(value));
                }
                else{
                    if(key == null || key.equals("")){
                        result.put(initial_key, String.valueOf(value));
                    }
                    else{
                        result.put(initial_key + "." + key, String.valueOf(value));
                    }
                }
            }
            else{
                if(initial_key == null || initial_key.equals("")){
                    helper(key, (HashMap<String, Object>) value, result);
                }
                else{
                    helper(initial_key + "." + key, (HashMap<String, Object>) value, result);
                }
            }
        }
    }
    
    public static void main(String args[]) {
     Map<String, Object> dictionary = new HashMap<>();
            dictionary.put("key1", "1");
            dictionary.put("key2", new HashMap<>());
            ((Map) dictionary.get("key2")).put("a", "2");
            ((Map) dictionary.get("key2")).put("b", "3");
            ((Map) dictionary.get("key2")).put("c", new HashMap<>());
            ((Map) ((Map) dictionary.get("key2")).get("c")).put("d", "3");
            ((Map) ((Map) dictionary.get("key2")).get("c")).put("e",new HashMap<>());
            ((Map) ((Map) ((Map) dictionary.get("key2")).get("c")).get("e")).put("","1");

            for(String key : dictionary.keySet()) {
                System.out.println(key + " : " + dictionary.get(key));
            }

            Map<String, String> result = flattenDictionary(dictionary);

            System.out.println("----------------Flattened------------------");
            for(String key : result.keySet()) {
                System.out.println(key + " : " + result.get(key));
            }
    }
}

