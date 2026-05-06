# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        # we want to find the furthest right and the furthest right node.
        # it could be a lot tho, we start from root and then get the depth of 2 subtrees
        # then we perform dfs between all othes and get differences in heights
        res = 0;

        def dfs(root):
            nonlocal res

            if not root:
                return 0

            left = dfs(root.left)
            right = dfs(root.right)

            res = max(res, left+right)

            return 1 + max(left, right)

        dfs(root);
        return res