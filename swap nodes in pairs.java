/* Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(null==head || null==head.next)
            return head;
        ListNode pre=new ListNode(0);
        pre.next=head;
        head=pre;
        ListNode cur=pre.next;
        ListNode nex=cur.next;
        while(null!=cur && null!=nex){
            cur.next=nex.next;
            nex.next=cur;
            pre.next=nex;
            pre=cur;
            cur=pre.next;
            nex= null==cur ? null :cur.next;
        }
        return head.next;
    }
}
