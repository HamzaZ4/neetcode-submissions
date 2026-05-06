"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        # we can dfs to do this, giving the dfs the original node
        # and the replica node and we would dfs over the real one
        # creating connections with the 

        oldToNew = {}
        
        def dfs(ogNode):
            if ogNode in oldToNew:
                return oldToNew[ogNode]

            copy = Node(ogNode.val)
            oldToNew[ogNode] = copy

            for nei in ogNode.neighbors:
                copy.neighbors.append(dfs(nei))
            return copy

        
        return dfs(node) if node else None

            
            
