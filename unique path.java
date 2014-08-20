/* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the 
grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?*/

public class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp=new int[m];
        for(int i=0;i<n;++i){
            dp[0]=1;
            for(int j=1;j<m;++j){
                dp[j]+=dp[j-1];
            }
        }
        return dp[m-1];
    }
}

/* Follow up:
Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.*/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(0==obstacleGrid.length || 0==obstacleGrid[0].length)
            return 0;
        int n=obstacleGrid.length,m=obstacleGrid[0].length;
        int[] dp=new int[m+1];
        dp[1]=1;
        for(int i=0;i<n;++i){
            for(int j=1;j<=m;++j){
                if(obstacleGrid[i][j-1]==1)
                    dp[j]=0;
                else
                    dp[j]+=dp[j-1];
            }
        }
        return dp[m];
    }
}

