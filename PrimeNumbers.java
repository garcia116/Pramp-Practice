/*
Write a function find_primes(n) that returns all prime numbers less than or equal to n.

Examples
find_primes(1)  # => []
find_primes(5)  # => [2, 3, 5]
find_primes(20) # => [2, 3, 5, 7, 11, 13, 17, 19]
*/

import java.io.*;
import java.util.*;

public class MyClass {
    public static ArrayList<Integer> PrimeNumbers(int num){
        ArrayList<Integer> primes = new ArrayList<>();
        int i = 2;
        
        while(i <= num){
            boolean prime = true;
            for(int p : primes){
                System.out.println(p);
                if(i % p == 0){
                    prime = false;
                    break;
                }
            }
            if(prime){
                primes.add(i);
            }
            i += 1;
        }
        return primes;
    }
    public static void main(String args[]) {
     
     System.out.println(PrimeNumbers(5));
     
    }
}
