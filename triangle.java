/*Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row
below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

/* It is a DP problem, the tricky part is from bottom to up, not the opposite.*/

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(null==triangle || 0==triangle.size())
            return 0;
        int[] dp=new int[triangle.size()];
        for(int row=triangle.size()-1;row>=0;--row){
            int col=triangle.get(row).size();
            for(int i=0;i<col;++i){
                if(row==triangle.size()-1){
                    dp[i]=triangle.get(row).get(i);
                }
                else{
                    dp[i]=Math.min(dp[i],dp[i+1])+triangle.get(row).get(i);
                }
            }
        }
        return dp[0];
    }
}
