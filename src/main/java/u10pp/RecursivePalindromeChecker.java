package u10pp;

public class RecursivePalindromeChecker{
    /**
     * 
     * @param s - only accepts lowercase letters, the string that will be checked for if it is a palindrome
     * @return - true if the strng is a palindrome, false if it is not
     */
    public static boolean isPalindrome(String s){
        int count = 0;
        if(s.length() == 0 || s.length() == 1){
            return true;
        } else if(s.substring(0, 1).equals(s.substring(s.length() - 1, s.length()))){
            count++;
            return isPalindrome(s.substring(count, s.length() - count));
        } else{
            return false;
        }
    }
}