/* Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.*/

/Here are 3 ways to solve the problem, recursive, BFS and DFS.*/

/* The recursive version*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(null==root)
            return false;
        if(root.val==sum && null==root.left && null==root.right)
            return true;
        else
            return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}

/* The BFS version, the DFS version is similar, the difference is using stack or queue.*/
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(null==root)
            return false;
        Queue<TreeNode> nodes=new LinkedList<TreeNode>();
        Queue<Integer> sums=new LinkedList<Integer>();
        nodes.add(root);
        sums.add(root.val);
        while(!nodes.isEmpty()){
            TreeNode node=nodes.poll();
            int accsum=sums.poll();
            if(accsum==sum && null==node.left && null==node.right)
                return true;
            if(null!=node.left){
                nodes.add(node.left);
                sums.add(accsum+node.left.val);
            }
            if(null!=node.right){
                nodes.add(node.right);
                sums.add(accsum+node.right.val);
            }
        }
        return false;
    }
}
