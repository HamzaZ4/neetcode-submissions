# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        # we want to seperate the list into 2 parts
        # and then we want to reconnect

        # step 1 is to get the halfway mark

        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next


        prev = None
        curr = slow.next
        slow.next = None

        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        dummy = ListNode()
        res = dummy

        l1 = head
        l2 = prev


        while l1 and l2:
            nl1, nl2 = l1.next, l2.next
            res.next = l1
            l1.next = l2
            res = l2
            l1, l2 = nl1, nl2

        if l1:
            res.next = l1
        if l2:
            res.next = l2

        


        