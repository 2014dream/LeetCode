/* Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)*/

/* Use DFS and backtracking to solve the problem. two conditions need to consider to eliminate impossible solutions:
the string is divided into 4 parts, each part should be 0--255. the left number of part is n, if 
left length is less than 4-n or greater than (4-n)*3, it is invalid.

Then we use DFS  to get all the possible results, the condition if(0==num) break; is crucial because it should be 0
if the letter is '0' and we should keep it.*/

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result=new ArrayList<String>();
        if(null==s || 0==s.length() || s.length()>12)
            return result;
        int depth=0,start=0;
        String ip="";
        restoreHelper(s,start,depth,ip,result);
        return result;
    }
    public void restoreHelper(String s, int start, int depth, String ip, ArrayList<String> result){
        if(s.length()-start<4-depth)
            return;
        if(s.length()-start>(4-depth)*3)
            return;
        if(4==depth){
            StringBuilder bf=new StringBuilder(ip);
            bf.deleteCharAt(bf.length()-1);
            result.add(bf.toString());
            return;
        }
        int num=0;
        for(int i=start;i<start+3 && i<s.length();++i){
            num=num*10+ (int)(s.charAt(i)-'0');
            if(num<256){
                ip=ip+s.charAt(i);
                restoreHelper(s,i+1,depth+1,ip+'.',result);
            }
            if(0==num)
                break;
        }
    }
}
