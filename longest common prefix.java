/* Write a function to find the longest common prefix string amongst an array of strings.*/

/* Solution1: select first str as prefix, compare every char with second until not equals one. substring
 loop to the last one, then we will get common prefix.
 Solution2: compare first char with every str, if works, second char... 
 use j == 0 to optimize.*/
 
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(null==strs || 0==strs.length)
            return "";
        String res=strs[0];
        for(int i=1;i<strs.length;++i){
            int j=0;
            while(j<res.length() && j<strs[i].length() && res.charAt(j)==strs[i].charAt(j)){
                j++;
            }
            if(0==j)
                return "";
            res=strs[i].substring(0,j);
        }
        return res;
    }
}
