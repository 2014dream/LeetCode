/* Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.*/

/* We neec to change upper letters to lower letters, and delete characters not alpha/number, then check palindrome using 
two pointers.*/

public class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        if(s.length()<2)
            return true;
        int start=0,end=s.length()-1;
        while(start<end){
            while(start<end && !isAlphaNumber(s.charAt(start))){start++;}
            while(start<end && !isAlphaNumber(s.charAt(end))){end--;}
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    public boolean isAlphaNumber(char c){
        if(c>='a' && c<='z')
            return true;
        if(c>='0' && c<='9')
            return true;
        return false;
    }
}
