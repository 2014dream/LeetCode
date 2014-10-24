/* A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.*/

/* DP problem. let dp[i] be the number of decode ways to the length of i. if s[i-1] is not '0', then dp[i]=dp[i-1].
if the combination of s[i-2] and s[i-1] is valid, means s[i-2] is not '0' and 11<=num<=26, then dp[i]=dp[i-1]+dp[i-2]. */


public class Solution {
    public int numDecodings(String s) {
        if(null==s || 0==s.length())
            return 0;
        int ppre=1,pre=1;
        for(int i=0;i<s.length();++i){
            int tmp=0;
            if(s.charAt(i)!='0')
                tmp+=pre;
            if(i>0){
                int num=Integer.parseInt(s.substring(i-1,i+1));
                if(s.charAt(i-1)!='0' && num>=1 && num<=26)
                    tmp+=ppre;
            }
            ppre=pre;
            pre=tmp;
        }
        return pre;
    }
}
