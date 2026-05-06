# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:

        #find the second half of the linked list
        fast = head;
        slow = head;

        while(fast.next and fast.next.next):
            fast = fast.next.next
            slow = slow.next


        #Reverse the second half of the linked list
        cur = slow.next;
        prev = slow.next = None; #seperating the old LL from the one we reverse and all

        while(cur):
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        
        first, second = head, prev

        while second:
            n1, n2 = first.next, second.next
            first.next = second
            second.next = n1
            first, second = n1, n2
        

        # now cur is = to the last element ( or first in the reversed LL )

        #Now reorder the original linked list
        

    
