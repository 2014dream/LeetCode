/* Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of 
largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3], return 10.*/

/* use a stack to store the increasing popisions until current position, then compute the rectangle area. */

public class Solution {
    public int largestRectangleArea(int[] height) {
        if(null==height || 0==height.length)
            return 0;
        int i=0, maxArea=0;
        Stack<Integer> stack=new Stack<Integer>();
        while(i<height.length){
            if(stack.isEmpty() || height[stack.peek()] <= height[i])
                stack.push(i++);
            else{
                int curHeight=height[stack.pop()];
                int width= stack.isEmpty() ? i : i-stack.peek()-1;
                maxArea=Math.max(maxArea,curHeight*width);
            }
        }
        while(!stack.isEmpty()){
            int curHeight=height[stack.pop()];
            int width= stack.isEmpty() ? i : i-stack.peek()-1;
            maxArea=Math.max(maxArea,curHeight*width);
        }
        return maxArea;
    }
}
