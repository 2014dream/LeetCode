/* Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.*/

public class Solution {
    public boolean canJump(int[] A) {
        int rightMost=A[0];
        for(int i=1;i<A.length;++i){
            if(i<=rightMost)
                rightMost=Math.max(rightMost,i+A[i]);
            else
                return false;
        }
        return true;
    }
}

/* Follow up:
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)*/

public class Solution {
    public int jump(int[] A) {
        int rightMost=A[0];
        int step=A[0];
        int jump=1;
        if(A.length<=1)
            return 0;
        for(int i=1;i<A.length;++i){
            if(i==A.length-1)
                return jump;
            if(i+A[i]>rightMost)
                rightMost=i+A[i];
            step--;
            if(0==step){
                jump++;
                step=rightMost-i;
            }
        }
        return jump;
    }
}
