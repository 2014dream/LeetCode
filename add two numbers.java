/* You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their 
nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8 */

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode cur=head;
        int curVal=0,carry=0;
        while(null!=l1 || null!=l2 ||0!=carry){
            int val1= null==l1? 0 : l1.val;
            int val2= null==l2? 0 : l2.val;
            curVal= (carry+val1+val2)%10;
            carry= (carry+val1+val2)/10;
            ListNode newNode=new ListNode(curVal);
            cur.next=newNode;
            cur=cur.next;
            l1= null==l1? null : l1.next;
            l2= null==l2? null : l2.next;
        }
        return head.next;
    }
}
