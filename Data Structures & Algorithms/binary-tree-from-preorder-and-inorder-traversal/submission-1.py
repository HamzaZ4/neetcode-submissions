class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None

        # 1. The first element in preorder is always the root
        root_val = preorder[0]
        root = TreeNode(root_val)

        # 2. Find where this root sits in the inorder list
        # Everything to the left of this index is the left subtree
        mid = inorder.index(root_val)

        # 3. Recursively build the subtrees
        # For Left: 
        #   Preorder: Skip the root, take 'mid' number of elements
        #   Inorder: Take everything before 'mid'
        root.left = self.buildTree(preorder[1 : mid + 1], inorder[:mid])
        
        # For Right:
        #   Preorder: Take everything after the left subtree elements
        #   Inorder: Take everything after 'mid'
        root.right = self.buildTree(preorder[mid + 1 :], inorder[mid + 1 :])

        return root