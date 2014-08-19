/* Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.*/

public class Solution {
    public int[] plusOne(int[] digits) {
        if(null==digits || 0==digits.length)
            return digits;
        int carry=1;
        for(int i=digits.length-1;i>=0;--i){
            int digit=(carry+digits[i])%10;
            carry=(carry+digits[i])/10;
            digits[i]=digit;
            if(0==carry)
                return digits;
        }
        int[] result=new int[digits.length+1];
        result[0]=1;
        return result;
    }
}
