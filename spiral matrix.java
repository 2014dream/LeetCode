/* Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].*/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<Integer>();
        if(null==matrix || 0==matrix.length || 0==matrix[0].length)
            return result;
        int left=0,right=matrix[0].length-1;
        int upper=0,lower=matrix.length-1;
        while(true){
            for(int col=left;col<=right;++col){
                result.add(matrix[upper][col]);
            }
            if(++upper>lower)
                break;
            for(int row=upper;row<=lower;++row){
                result.add(matrix[row][right]);
            }
            if(--right<left)
                break;
            for(int col=right;col>=left;--col){
                result.add(matrix[lower][col]);
            }
            if(--lower<upper)
                break;
            for(int row=lower;row>=upper;--row){
                result.add(matrix[row][left]);
            }
            if(++left>right)
                break;
        }
        return result;
    }
}

/* Follow up:
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]*/

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left=0,right=n-1;
        int upper=0,lower=n-1;
        int num=1;
        while(true){
            for(int col=left;col<=right;++col){
                matrix[upper][col]=num++;
            }
            if(++upper>lower)
                break;
            for(int row=upper;row<=lower;++row){
                matrix[row][right]=num++;
            }
            if(--right<left)
                break;
            for(int col=right;col>=left;--col){
                matrix[lower][col]=num++;
            }
            if(--lower<upper)
                break;
            for(int row=lower;row>=upper;--row){
                matrix[row][left]=num++;
            }
            if(++left>right)
                break;
        }
        return matrix;
    }
}
