/* You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/

public class Solution {
    public int climbStairs(int n) {
        if(n<4)
            return n;
        int fn2=2,fn1=3,fn=5;
        for(int i=5;i<=n;++i){
            fn2=fn;
            fn=fn1+fn2;
            fn1=fn2;
        }
        return fn;
    }
}
