/* Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
(each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character*/

/* This is a dp problem. We use dp[i][j] to present the edit distance of word1 and word2 with length i and j respectively.
if word1==null, dp[i][j]=j;
if word2==null, dp[i][j]=i;
if word1[i]==word2[j], dp[i][j]=dp[i-1][j-1];
else dp[i][j]=min(dp[i][j-1],dp[i-1][j-1],dp[i-1][j])+1.*/

public class Solution {
    public int minDistance(String word1, String word2) {
        if(0==word1.length() || 0==word2.length())
            return 0==word1.length() ? word2.length() : word1.length();
        int m=word1.length(),n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;++i){
            for(int j=0;j<=n;++j){
                if(0==i)
                    dp[i][j]=j;
                else if(0==j)
                    dp[i][j]=i;
                else{
                    if(word1.charAt(i-1)==word2.charAt(j-1))
                        dp[i][j]=dp[i-1][j-1];
                    else
                        dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        return dp[m][n];
    }
}
