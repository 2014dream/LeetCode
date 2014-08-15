/* Divide two integers without using multiplication, division and mod operator.*/

/* We can keep subtract divisor from dividend until dividend is smaller than 0, than count the subtract numbers. But it will costs 
a very long time if the divisor is very small comparing to dividend.

Shift can be used to solve this problem. We shift the divisor left until it just smaller than dividend but if we keep shifting one
more bit, it’s larger than dividend. Than we can add the shifted value to the result and subtract the shifted value from dividend.
Keep doing this until dividend is smaller than divisor. In fact, every integer can be represented by a set of base 2 so that 
shifting can be used.

One thing needs to be mentioned is that we need to convert the integer to long type. Otherwise the Math.abs() value of 
Integer.MIN_VALUE will be quite strange.*/

public class Solution {
    public int divide(int dividend, int divisor) {
        if(0==dividend || 0==divisor)
            return 0;
        long dv=Math.abs((long)dividend);
        long ds=Math.abs((long)divisor);
        int result=0;
        while(dv>=ds){
            int counter=0;
            while(dv>=(ds<<counter)){
               counter++; 
            }
            result+= 1<<(counter-1);
            dv-=ds<<(counter-1);
        }
        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0))
            return result;
        else 
            return -result;
    }
}
