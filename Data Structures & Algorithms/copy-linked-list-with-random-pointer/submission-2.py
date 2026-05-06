"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None

        oldToNew = {}

        passing = head

        while passing: 
            oldToNew[passing] = Node(passing.val, None, None)
            passing = passing.next

        passing = head

        while passing:
            if passing.next:
                oldToNew[passing].next = oldToNew[passing.next]
            if passing.random:
                oldToNew[passing].random = oldToNew[passing.random]

            passing = passing.next

        return oldToNew[head]