# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        

        # this is the simplest method but it takes a lot of space
        # one way of not having to go through the array like this ( extra k spac)


        # arr = []

        # def dfs(node):
        #     if not node:
        #         return
        #     dfs(node.left)
        #     arr.append(node.val)
        #     dfs(node.right)

        # dfs(root)

        # return arr[k-1]

        curr = root
        stack = []

        while curr or stack:
            while curr:
                stack.append(curr)
                curr = curr.left

            curr = stack.pop()
            k-=1
            if k ==0:
                return curr.val
            curr = curr.right


