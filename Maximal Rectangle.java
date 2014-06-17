/* Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.*/

/* This is a quesiton based on the maximum histgram. we can convert maximum rectangle to maximum histgram. The first step
is generate the histgram for each row, then calculate the maximum area of each histgram. */

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(null==matrix || 0==matrix.length)
            return 0;
        int m=matrix.length, n=matrix[0].length;
        int maxArea=0;
        int[][] hists=new int[m][n];
        for(int row=0;row<m;++row){
            for(int col=0;col<n;++col){
                if('0'==matrix[row][col])
                    hists[row][col]=0;
                else
                    hists[row][col]= 0==row? 1 : hists[row-1][col]+1;
            }
        }
        for(int row=0;row<m;++row){
            maxArea = Math.max(maxArea, maxHist(hists[row]));
        }
        return maxArea;
    }
    public int maxHist(int[] heights){
        int i=0, maxRec=0;
        Stack<Integer> stack = new Stack<Integer>();
        while(i<heights.length){
            if(stack.isEmpty() || heights[stack.peek()]<=heights[i])
                stack.push(i++);
            else{
                int height=heights[stack.pop()];
                maxRec=Math.max(maxRec,height*(stack.isEmpty()? i : i-stack.peek()-1));
            }
        }
        while(!stack.isEmpty()){
            int height=heights[stack.pop()];
            maxRec=Math.max(maxRec,height*(stack.isEmpty()? i : i-stack.peek()-1));
        }
        return maxRec;
    }
}
