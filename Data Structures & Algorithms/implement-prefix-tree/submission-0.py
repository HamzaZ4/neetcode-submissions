class TrieNode:
    def __init__(self):
        self.children = {}
        self.endOfWord = False


class PrefixTree:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        parent = self.root
        for c in word:
            if c not in parent.children:
                parent.children[c] = TrieNode()
            parent = parent.children[c]
        parent.endOfWord = True


    def search(self, word: str) -> bool:
        parent = self.root
        for c in word:
            if c not in parent.children:
                return False
            parent = parent.children[c]
        
        return parent.endOfWord
        

    def startsWith(self, prefix: str) -> bool:
        parent = self.root
        for c in prefix:
            if c not in parent.children:
                return False
            parent = parent.children[c]

        return True

        
        