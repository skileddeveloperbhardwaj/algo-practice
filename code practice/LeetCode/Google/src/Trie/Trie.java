package Trie;

public class Trie {
    static final int ALPHABET_SIZE = 26;

    //each node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEoW;
        //variable to store prefix counts
        int count;

        TrieNode() {
            isEoW = false;
            count = 0;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    public void init() {
        root = new TrieNode();
    }

    static TrieNode root;

    public void insert(String key) {
        int len = key.length();
        TrieNode pCrawl = root;

        for (int i = 0; i < len; i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
            }

            pCrawl.count++;
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEoW = true;
    }

    public boolean search(String key) {
        int len = key.length();
        TrieNode pCrawl = root;
        for (int i = 0; i < len; i++) {
            int index = key.charAt(i) - 'a';
            if(pCrawl.children[index] ==  null)
                return false;
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.isEoW);
    }

    public int wordCount(String key) {
        int len = key.length();
        TrieNode pCrawl = root;
        for (int i = 0; i < len; i++) {
            int index = key.charAt(i) - 'a';
            if(pCrawl.children[index] ==  null)
                return 0;
            pCrawl = pCrawl.children[index];
        }
        return pCrawl.count;
    }
}
