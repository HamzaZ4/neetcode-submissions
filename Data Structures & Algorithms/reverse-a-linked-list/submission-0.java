/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode next = head.next.next;
        ListNode current = head.next;
        ListNode prev = head;

        while(!(next==null)){
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
            
        }
        current.next = prev;
        head.next = null;
        return current;


    




    }
}
