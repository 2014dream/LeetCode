/* Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be 
set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, 
and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
    
*/

/* The hard part is 5->6, we can use the link connection done on the upper layer. */


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(null==root)
            return ;
        if(null!=root.left)
            root.left.next=root.right;
        if(null!=root.right)
            root.right.next= (null==root.next)?null:root.next.left;
        connect(root.left);
        connect(root.right);
    }
}

/* Follow up: What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/    

/* we have to link level by level, otherwise, there may have some problem, such as below example:
Input: 2,1,3,0,7,9,1,2,#,1,0,#,#,8,8,#,#,#,#,7
Expect: 2,#,1,3,#,0,7,9,1,#,2,1,0,8,8,#,7,#
Output:  2,#,1,3,#,0,7,9,1,#,2,1,0,#,7,#
because the link 9->1 has not been connected.*/


