/* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able 
to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.*/

/* Solution: DP 
 To calculate the total volume is to calculate volumes can hold at each position.
 To calculate how many volumes can hold at each position is to calculate it's right bound height  and right bound height 
Current position can hold water only at the situation when the low side among both sides higher than the height at current position
If so,  use the lower one minus current height as height to multiply the width 1 is how many volumes can hold at current position
How to calculate the height of both sides for each position? We can apply DP theory to record  highest height bound can get from 
left to current and highest height bound can get from right to current  
HigehstLeftSideHeight so far from giving example, should be  0,1,1,2,2,2,2,3,3,3,3,3
HighestRightSideHeight so far for given example is 1,2,2,2,3,3,3,3,3,3,3,3
Then loop through giving array for each position to calculate how many volumes can hold there and update the total volume it can 
hold. */

public class Solution {
    public int trap(int[] A) {
        if(0==A.length)
            return 0;
        int sum=0;
        int[] left = new int[A.length];
        int[] right=new int[A.length];
        left[0]=A[0];
        for(int i=1;i<A.length;++i){
            left[i]=Math.max(left[i-1],A[i]);
        }
        right[A.length-1]=A[A.length-1];
        for(int i=A.length-2;i>=0;--i){
            right[i]=Math.max(right[i+1],A[i]);
        }
        for(int i=0;i<A.length;++i){
            sum+= Math.min(left[i],right[i])-A[i];
        }
        return sum;
    }
}
