/* Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.*/

/* use first column and first row as indicator, if current position is 0, set the corresponding position in first column 0
and the corresponding position in the first column 0; */

public class Solution {
    public void setZeroes(int[][] matrix) {
        if(null==matrix || 0==matrix.length)
            return;
        int m=matrix.length, n=matrix[0].length;
        boolean firstRow=false,firstCol=false;
        for(int i=0;i<m;++i){
            if(0==matrix[i][0]){
                firstCol=true;
                break;
            }
        }
        for(int j=0;j<n;++j){
            if(0==matrix[0][j]){
                firstRow=true;
                break;
            }
        }
        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                if(0==matrix[i][j]){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                if(0==matrix[i][0] || 0==matrix[0][j]){
                    matrix[i][j]=0;
                }
            }
        }
        if(firstRow){
            for(int j=0;j<n;++j){
                matrix[0][j]=0;
            }
        }
        if(firstCol){
            for(int i=0;i<m;++i){
                matrix[i][0]=0;
            }
        }
    }
}
