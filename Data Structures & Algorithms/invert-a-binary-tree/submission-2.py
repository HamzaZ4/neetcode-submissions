# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        
        if not root:
            return root

        lc = self.invertTree(root.left)
        rc = self.invertTree(root.right)

        root.right = lc
        root.left = rc

        return root