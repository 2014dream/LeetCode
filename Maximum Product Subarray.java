/* Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6. */

public class Solution {
    public int maxProduct(int[] A) {
        if(null==A || 0==A.length)
            return 0;
        int max_here=1,min_here=1,result=Integer.MIN_VALUE;
        for(int i=0;i<A.length;++i){
            if(A[i]>0){
                max_here*=A[i];
                min_here*=A[i];
                result=Math.max(result,max_here);
            }
            else if(A[i]<0){
                result=Math.max(result,min_here*A[i]);
                int tmp=max_here;
                max_here=Math.max(1,min_here*A[i]);
                min_here=tmp*A[i];
            }
            else{
                min_here=1;
                max_here=1;
                result=Math.max(result,0);
            }
        }
        return result;
    }
}
