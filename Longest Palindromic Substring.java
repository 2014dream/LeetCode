/* Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and 
there exists one unique longest palindromic substring.*/

/* The first way to solve this problem is iterate through the string, find the longest palindrome substring centered by 
each character and update. The running time complexity is O(n2), space is O(1).*/

public class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<2)
            return s;
        String longest=s.substring(0,1);
        for(int i=0;i<s.length()-1;++i){
            String tmp=helper(s,i,i+1);
            if(tmp.length()>longest.length())
                longest=tmp;
            tmp=helper(s,i,i);
            if(tmp.length()>longest.length())
                longest=tmp;
        }
        return longest;
    }
    public String helper(String s, int start, int end){
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }
}

/*The second way to solve it is to use dynamic programming. The table dp[i][j] denote whether substring from i to j is 
palindrome. The start condition:
dp[i][i]=true; dp[i][i+1]=true if s[i]==s[i+1]
The changing condition:
dp[i][j]=true if s[i]==s[j] && dp[i+1][j-1]. 
The time complexity is O(n2), space is O(n).*/

public class Solution {
    public String longestPalindrome(String s) {
        if(null==s || 0==s.length())
            return null;
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        int start=0,maxLen=1;
        for(int i=0;i<len;++i){
            dp[i][i]=true;
            for(int j=0;j<i;++j){
                dp[j][i]=(s.charAt(j)==s.charAt(i)) &&(i-j<2 || dp[j+1][i-1]);
                if(dp[j][i] && maxLen<i-j+1){
                    maxLen=i-j+1;
                    start=j;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}
/* There is another solution with time complexity of O(n), refer below lind for details.*/
http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html 
