/* Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn 
such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such 
that the container contains the most water.

Note: You may not slant the container.*/

/* It could take a long time if you check every possible container, because the time complexity is O(n2). So we need another way 
to achieve it.

We can use two pointers pointing to left and right. Calculate the area formed by left and right pointer. If height of left is 
smaller than right, we will move left pointer one step, otherwise we will move the right pointer left 1 step. The maximum area is 
saved during the processing. */

public class Solution {
    public int maxArea(int[] height) {
        if(height.length<2)
            return 0;
        int left=0,right=height.length-1;
        int max=0;
        while(left<right){
            max=Math.max(max,(right-left)*Math.min(height[left],height[right]));
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}

