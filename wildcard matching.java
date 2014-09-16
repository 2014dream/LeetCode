/* Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false*/

/* greedy solution. */

public class Solution {
    public boolean isMatch(String s, String p) {
        int i=0,j=0;
        int mark=-1,star=-1;
        while(i<s.length()){
            if(j<p.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')){
                i++;
                j++;
            }
            else if(j<p.length() && p.charAt(j)=='*'){
                star=j++;
                mark=i;
            }
            else if(star!=-1){
                j=star+1;
                i=++mark;
            }
            else 
                return false;
        }
        while(j<p.length()&&p.charAt(j)=='*'){
            j++;
        }
        return j==p.length();
    }
}

/* dp solution :
F(i, j) denote if s[0]…s[i-1] and p[0]…p[j-1] is matched or not
 F(i, j) = (s[i-1] == p[j-1]) && F(i-1, j-1) if  p[j-1] != ‘*’ or ‘?’
F(i, j) = F(i-1, j-1)  if  p[j] == ‘?’
F(i, j) = OR F(i-l, j-1) for l = 0, … i,  if  p[j] == ‘*’
*/

