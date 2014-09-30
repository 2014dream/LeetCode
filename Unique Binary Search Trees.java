/* Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3 */
   
   
/* This is a one demension dynamic programming question. For more details, refer to the following link:
http://fisherlei.blogspot.com/2013/03/leetcode-unique-binary-search-trees.html    */

public class Solution {
    public int numTrees(int n) {
        int[] result=new int[n+1];
        result[0]=1;
        result[1]=1;
        for(int i=2;i<=n;++i){
            for(int j=0;j<i;++j){
                result[i]+=result[j]*result[i-1-j];
            }
        }
        return result[n];
    }
}


/* Follow up:
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n..*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }
    public ArrayList<TreeNode> generateTrees(int start, int end){
        ArrayList<TreeNode> result=new ArrayList<TreeNode>();
        if(start>end){
            result.add(null);
            return result;
        }
        for(int i=start;i<=end;++i){
            for(TreeNode left:generateTrees(start,i-1)){
                for(TreeNode right:generateTrees(i+1,end)){
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
