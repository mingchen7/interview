/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    char c;
    boolean has_word;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public TrieNode() {

    }

    public TrieNode(char c) {
        this.c = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curNode = root;
        HashMap<Character, TrieNode> curChildren = curNode.children;
        char[] array = word.toCharArray();

        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (!curChildren.containsKey(c)) {
                TrieNode node = new TrieNode(c);
                curChildren.put(c, node);
            }

            curNode = curChildren.get(c);
            curChildren = curNode.children;
        }

        curNode.has_word = true;

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (findStringNodePos(word) == null) {
            return false;
        }
        else if (findStringNodePos(word).has_word) {
            return true;
        }
        else {
            return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return findStringNodePos(prefix) == null? false: true;
    }

    // find the TrieNode given the string s
    private TrieNode findStringNodePos(String s) {
        TrieNode curNode = root;
        HashMap<Character, TrieNode> curChildren = root.children;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (curChildren.containsKey(c)) {
                curNode = curChildren.get(c);
                curChildren = curNode.children;
            }
            else {
                return null;
            }
        }

        return curNode;
    }
}
