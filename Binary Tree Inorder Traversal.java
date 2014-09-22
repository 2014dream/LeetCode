/* Given a binary tree, return the inorder traversal of its nodes' values.*/

/* This is the recursive version, and need to add one more function to store the data; without the new function,
the resultjust contains the root value*/

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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        inorder(root,result);
        return result;
    }
    public void inorder(TreeNode root, ArrayList<Integer> result){
        if(null==root)
            return ;
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }
}

/* This is the intenative version using one stack. */

public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> nodes= new Stack<TreeNode>();
        TreeNode current=root;
        boolean done=false;
        while(!done){
            if(null!=current){
                nodes.push(current);
                current=current.left;
            }
            else{
                if(true==nodes.empty())
                    done=true;
                else{
                    current=nodes.peek();
                    nodes.pop();
                    result.add(current.val);
                    current=current.right;
                }
            }
        }
        return result;
    }
}


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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        TreeNode node=root;
        if(null==root)
            return result;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(!stack.empty() || null!=node){
            if(null!=node){
                stack.push(node);
                node=node.left;
            }
            else{
                node=stack.pop();
                result.add(node.val);
                node=node.right;
            }
        }
        return result;
    }
}
