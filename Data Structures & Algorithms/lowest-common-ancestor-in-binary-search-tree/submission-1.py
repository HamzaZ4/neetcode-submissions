# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        if q.val < p.val:
            p,q = q,p

        lca = root

        while lca:
            if q.val > lca.val and p.val > lca.val:
                lca = lca.right
            elif q.val < lca.val and p.val < lca.val:
                lca = lca.left
            else:
                return lca

        return lca