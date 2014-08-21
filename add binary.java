/* Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".*/

public class Solution {
    public String addBinary(String a, String b) {
        if(null==a || 0==a.length())
            return b;
        if(null==b || 0==b.length())
            return a;
        int i=a.length()-1,j=b.length()-1;
        int carry=0;
        StringBuilder s=new StringBuilder();
        while(i>=0 ||j>=0){
            int num1= i<0? 0 : (int)(a.charAt(i)-'0');
            int num2= j<0? 0 : (int)(b.charAt(j)-'0');
            int num=(num1+num2+carry)%2;
            carry=(num1+num2+carry)/2;
            s.append(num);
            i--;
            j--;
        }
        if(carry>0)
            s.append(carry);
        return s.reverse().toString();
    }
}
