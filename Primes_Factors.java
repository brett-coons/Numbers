/*
Author: Brett Coons
 */
package funwithnumbers;
/******************************************************************************/
import java. util.*;
import java.math.*;
/******************************************************************************/
public class FunWithNumbers {
    
    public void factors(long n){
        /*
        Returns a list of factors of n
        */
        List<Long> factors = new ArrayList<Long>();
        for (long i = 1; i <= Math.floor(n/2) + 1; i++){
            if (n%i == 0){
                factors.add(i);
            }
        }
        factors.add(n);
        if (factors.size() == 2){
            System.out.println(n + " is a prime number!");
        }
        else{
            System.out.println(factors);    
        }
    }   // end of factors

    public long recursiveFactorial(int n){
        /*
        returns n! using recursion
        */
        if (n == 0){
            return (1);
        }
        return(n*recursiveFactorial(n-1));
    }   // end of factorial
    
    public long loopFactorial(int n){
        long answer = 1;
        for (int i = 1; i <= n; i++){
            answer = answer * i;
        }
        return (answer);
    }   // end of loopFactorial
       
    public void makingChange(int n){
        /*
        Consider the problem of making change for n cents (for positive integer
        n) using the fewest number of coins. So the input to the problem is a 
        positive number and as output we seek the fewest number of quarters, 
        dimes, nickels, and pennies that add up to n. Describe a greedy 
        algorithm that uses quarters, dimes, nickels, and pennies to make 
        change.
        */
        int change = n;
        int quarterCount = 0;
        int dimeCount = 0;
        int nickelCount = 0;
        int pennyCount = 0;

        while (change != 0){
            if (change/25 >= 1){            // check for quarters
                change = change - 25;
                quarterCount++;
            }
            else if (change/10 >= 1){       // check for dimes
                change = change - 10;
                dimeCount++;
            }
            else if (change/5 >= 1){        // check for nickels
                change = change - 5;
                nickelCount++;
            }
            else if (change < 5){           // check for pennies
                pennyCount = change;
                change = 0;
            }
        }
        System.out.println("Change: " + quarterCount + " quarters, "
        + dimeCount + " dimes, " + nickelCount + " nickels, " + pennyCount + 
        " pennies.");
    }   // end of makingChange

    public class MillerRabin{
        /*
        This class implements the Miller Rabin algorithm for primaility 
        testing.
        source: http://www.sanfoundry.com/java-program-miller-rabin-primality-test-algorithm/
        */
        public boolean isPrime(long n, int iteration){
            /** base case **/
            if (n == 0 || n == 1)
                return false;
            /** base case - 2 is prime **/
            if (n == 2)
                return true;
            /** an even number other than 2 is composite **/
            if (n % 2 == 0)
                return false;

            long s = n - 1;
            while (s % 2 == 0)
                s /= 2;

            Random rand = new Random();
            for (int i = 0; i < iteration; i++)
            {
                long r = Math.abs(rand.nextLong());            
                long a = r % (n - 1) + 1, temp = s;
                long mod = modPow(a, temp, n);
                while (temp != n - 1 && mod != 1 && mod != n - 1)
                {
                    mod = mulMod(mod, mod, n);
                    temp *= 2;
                }
                if (mod != n - 1 && temp % 2 == 0)
                    return false;
            }
            return true;        
        }   // end of millerRabin

        private long modPow(long a, long b, long c){
            /** Function to calculate (a ^ b) % c **/

            long res = 1;
            for (int i = 0; i < b; i++)
            {
                res *= a;
                res %= c; 
            }
            return res % c;
        }

        private long mulMod(long a, long b, long mod) {
            /** Function to calculate (a * b) % c **/
            return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue();
        }
    }
    
    public static void main(String[] args) {

    }   // end of main    
}   // end of FunWithNumbers
