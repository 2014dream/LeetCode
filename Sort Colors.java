/* Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and 
followed by 2's.

Could you come up with an one-pass algorithm using only constant space? */

/* we can use two pointer to record the position of red and blue, then traverse the array, when 0, swap it with the red, 
red ++, when 2, swap with the blue, blue --, when 1, do nothing.*/

public class Solution {
    public void sortColors(int[] A) {
        int red=0, blue=A.length-1;
        int i=0;
        while(red<=blue && 0==A[red]){red++;}
        while( blue>=red &&2==A[blue] ){blue--;}
        while(i<A.length){
            if(0==A[i] && i>red){
                swap(A,i,red);
                red++;
                continue;
            }
            if(2==A[i] && i<blue){
                swap(A,i,blue);
                blue--;
                continue;
            }
            i++;
        }
    }
    public void swap(int[] A, int a, int b){
        A[a]^=A[b];
        A[b]^=A[a];
        A[a]^=A[b];
    }
}
