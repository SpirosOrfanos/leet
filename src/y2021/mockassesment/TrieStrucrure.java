package y2021.mockassesment;

/*

 trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True

 */
public class TrieStrucrure {
    public static void main(String... args) {
        Trie trie = new Trie();
        trie.insert("apple");
    System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
       System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True

    //System.out.println(trie.search("appr"));
        //System.out.println(trie.search("appricot"));
        //System.out.println(trie.search("apprico"));
        //System.out.println(trie.search("fdaf"));
       System.out.println(trie.startsWith("dapp"));
        System.out.println(trie.startsWith("app"));
    }
}

class Trie {

    TNode tNode;
    public Trie() {
        this.tNode = new TNode();
    }

    public void insert(String word) {
        if (word.length() == 0) return;
        insert(word, tNode);
    }

    private void insert(String word, TNode node) {
        if (word.length() == 0) {
            node.isWord = true;
            return;
            }
            int v = word.charAt(0)-'a';
            if (node.nodes[v]==null) {
                node.nodes[v] = new TNode();
                node.nodes[v].value = word.charAt(0);
                insert(word.substring(1), node.nodes[v]);
            } else {
                insert(word.substring(1), node.nodes[v]);
            }
    }

    public boolean search(String word) {
        return search(word, tNode);
    }
    private boolean search(String word, TNode node) {
        if (node == null) return false;
        if (word.length() == 0 && node.isWord)
            return true;
        if (word.length() == 0 && !node.isWord)
            return false;
        int v = word.charAt(0)-'a';
        if (word.length() == 1 && node.nodes[v] == null)
            return false;
        if (word.length() == 1 && node.isWord)
            return true;

        if (node.nodes != null && node.nodes[v] != null) {
             return search(word.substring(1), node.nodes[v]);
        }
        else
            return false;
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, tNode);
    }

    private boolean startsWith(String word, TNode node) {
        if (word.length() == 0 && node.nodes!=null)
            return true;
        if (word.length() == 0 && node.nodes==null)
            return false;

        int v = word.charAt(0)-'a';

        if (node.nodes!=null && node.nodes[v]!=null)
            return startsWith(word.substring(1), node.nodes[v]);
        else
            return false;
    }
}

class TNode {
    Character value;
    TNode[] nodes;
    boolean isWord;

    public TNode() {
        this.nodes = new TNode[28];
    }
}

