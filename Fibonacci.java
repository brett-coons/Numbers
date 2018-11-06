package fibonacci;

import java.util.Arrays;
import java.util.HashMap;

public class Fibonacci {

 public int badFibonacci(int n){
        /*
        Returns the n'th Fibonacci number using binary recursion and executes in
        exponential time.
        
        Unfortunately, such a direct implementation of the Fibonacci formula
        results in a terribly inefficient method. Computing the n'th Fibonacci
        number requires an exponential number of calls to the method.
        Specifically, let Cn denote the number of calls prefomed in the
        execution of badFibonacci(n). Then, we have the following values for the 
        Cn's;
        c0 = 1
        c1 = 1
        c2 = 1+c0 +c1 = 1+1+1 = 3
        c3 = 1+c1 +c2 = 1+1+3 = 5
        c4 = 1+c2 +c3 = 1+3+5 = 9
        c5 = 1+c3 +c4 = 1+5+9 = 15
        c6 = 1+c4 +c5 = 1+9+15 = 25
        c7 = 1+c5 +c6 = 1+15+25 = 41
        c8 = 1+c6 +c7 = 1+25+41 = 67
        
        Source: Data Structures & Algorithms. 6 ed. page 216. 
        ISBN: 978-1-118-77133-4
        */
        if (n <= 1){
            return (n);
        }
        return (badFibonacci(n-2) + badFibonacci(n-1));
    }   // end of badFibonacci
    
    public int goodFibonacci(int n){
        /*
        Retuns the n'th Fibonacci number using linear recursion and executes in
        O(n) time.
        
        We can compute the n'th Fibonacci number much more efficiently using a
        recursion in which each invocation makes only onerecursive call. To do
        so, we need to redfine the expectations of the method. Rather than
        having the method return a single value, which is the n'th Fibonacci 
        number, we define a recursive method that returns a HashMap with two
        consecutive Fibonacci numbers <F(n), F(n-1)>.
        
        Source: Data Structures & Algorithms. 6 ed. page 217. 
        ISBN: 978-1-118-77133-4
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        
        
        if (n <= 1){
            return (n);
        }
        else if(map.containsKey(n)){
            return (map.get(n));
        }
        else{
            int value = goodFibonacci(n-2) + goodFibonacci(n-1);
            map.put(n, value);
            return (value);
        }
    }   // end of goodFibonacci
    
    public String fastFibonacci(int n){
        Integer[] array = new Integer[n];   // builds array of size n
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < n; i++){
            array[i] = array[i-1] + array[i-2];   
        }
        return (Arrays.toString(array));
    }
    public static void main(String[] args) {
        Fibonacci A = new Fibonacci();
        int n = 20;
        
        System.out.println("goodFibonacci(" + n + ") = " +  A.goodFibonacci(n));     
    }
    
}
