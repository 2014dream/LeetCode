/* Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5*/

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(null==head ||null==head.next || k<2)
            return head;
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        ListNode pre=new ListNode(0);
        pre.next=head;
        head=pre;
        for(int i=0;i<len/k;++i){
            ListNode cur=pre.next;
            ListNode nex=cur.next;
            for(int j=1;j<k;++j){
                cur.next=nex.next;
                nex.next=pre.next;
                pre.next=nex;
                nex=cur.next;
            }
            pre=cur;
        }
        return head.next;
    }
}
