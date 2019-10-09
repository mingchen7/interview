class TrieNode(object):

    def __init__(self, c=None):
        self.char = c
        self.children = {}
        self.is_word = False

class Trie:

    def __init__(self):        
        self.root = TrieNode()

    def insert(self, word):        
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode(c)

            node = node.children[c]

        node.is_word = True

    def search(self, word):        
        node = self.root
        for c in word:
            if c not in node.children:
                return False

            node = node.children[c]

        return node.is_word

    def startsWith(self, prefix):
        node = self.root
        for c in prefix:
            if c not in node.children:
                return False

            node = node.children[c]

        return True