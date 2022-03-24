package u10pp;
import java.math.BigInteger; 

public class RecursiveMath{
    /**
     * 
     * @param base - the number that is multiplying itself
     * @param exponent - the non-negative number of times the base multiplies itself
     * @return - the base multiplied by exponent amount of times
     */
    public static double pow(double base, int exponent){
        if(exponent == 0){
            return 1;
        } else{
            return base * pow(base, exponent - 1);
        }
    }

    /**
     * 
     * @param n - the number that is going to be multiplied by its factorial
     * @return - returns the n factorial of a number
     */
    public static BigInteger getFactorial(int n){
        BigInteger number = new BigInteger("" + n);
        BigInteger one = new BigInteger("1");

        if(n == 0 || n == 1){
            return one;
        } else{
            return number.multiply(getFactorial(n - 1));
        }
    }

    /**
     * 
     * @param n - the number that is going into the fibonacci series
     * @return - returns the nth number in the fibonacci series
     */
    public static int getFibonacciNumber(int n){
        if(n == 1 || n == 2){
            return 1;
        } else{
            return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
        }
    }
}