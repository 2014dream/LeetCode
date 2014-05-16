/* Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the 
characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE"
while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.*/

/* Use DP to solve the problem, dp[i][j] means the number of distinct subsequence for T with length of i, and S with 
length of j. If T[i] != S[j], then dp[i][j]=dp[i][j-1], other wise, dp[i][j]=dp[i][j-1]+dp[i-1][j-1]. */

public class Solution {
    public int numDistinct(String S, String T) {
        int m=S.length();
        int n=T.length();
        int[][] dp=new int[n+1][m+1];
        dp[0][0]=1;
        for(int i=1;i<=m;++i){
            dp[0][i]=1;
        }
        for(int i=1;i<=n;++i){
            dp[i][0]=0;
        }
        for(int i=1;i<=n;++i){
            for(int j=1;j<=m;++j){
                dp[i][j]=dp[i][j-1];
                if(S.charAt(j-1)==T.charAt(i-1))
                    dp[i][j]+=dp[i-1][j-1];
            }
        }
        return dp[n][m];
    }
}
