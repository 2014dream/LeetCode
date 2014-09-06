https://github.com/yxjiang/algorithms/blob/master/src/main/java/algorithm/linkedin/UpsideDownBinaryTree.java

/**
 * Given a binary tree where all the right nodes are leaves.
 * Write a function to turn the tree upside down.
 * e.g.
 *      root -> 0                    0
 *             / \                  / 
 *            1   2                1 - 2
 *           /                    /
 *          3             ===>   3
 *         / \                  /
 *        4   5                4 - 5
 *       / \                  /
 *      6   7                6 - 7
 *
 * Spcae: O(1), Time: O(n)
 */
 
 public TreeNode upsideDown(TreeNode root){
      TreeNode parent=null;
      TreeNode parentRight=null;
      return helper(root,parent,parentRight);
 }
 
 public TreeNode helper(TreeNode cur, TreeNode parent, TreeNode parentRight){
      if(null==cur)
        return parent;
      TreeNode left=cur.left;
      TreeNode right=cur.right;
      cur.left=parentRight;
      cur.right=parent;
      return helper(left,cur,right);
 }
