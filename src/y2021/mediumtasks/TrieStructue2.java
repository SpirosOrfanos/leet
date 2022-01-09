package y2021.mediumtasks;

public class TrieStructue2 {
    public static void main(String... args) {
        TrieStructue2 app = new TrieStructue2();
        MyTrie myTrie = new MyTrie();
        myTrie.insert("apple");
        myTrie.insert("apple");
        myTrie.insert("appricot");
        System.out.println();
        System.out.println(myTrie.search("qda"));
        System.out.println(myTrie.search("apple"));
        System.out.println(myTrie.search("app"));
        System.out.println(myTrie.search("appricot"));
        System.out.println(myTrie.search("applea"));
    }
}

class MyTrie {
    MyNode mn;

    public MyTrie() {
        this.mn = new MyNode();
    }

    public void insert(String word) {
        MyNode nv = this.mn;
        for (char c: word.toCharArray()) {
            int v = (int) c - 'a';
            if (nv.nodes[v] == null) {
                nv.nodes[v] = new MyNode();
                nv.nodes[v].value = c;
            }
            nv = nv.nodes[v];
        }
        nv.isWord = true;
    }

    public boolean search(String word) {
        MyNode nv = this.mn;
        for (char c: word.toCharArray()) {
            int v = (int) c - 'a';
            if (nv.nodes[v] == null) return false;
            nv = nv.nodes[v];
        }
        return nv.isWord;
    }

    public boolean startsWith(String word) {
        MyNode nv = this.mn;
        for (char c: word.toCharArray()) {
            int v = (int) c - 'a';
            if (nv.nodes[v] == null) return false;
            nv = nv.nodes[v];
        }
        return !nv.isWord;

    }
}

class MyNode {
    char value;
    MyNode[] nodes;
    boolean isWord;
    public MyNode() {
        this.nodes = new MyNode[28];
    }
}
