package Trie;

public class Driver {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their", "hackerrank","hack", "hacking"};
        trie.init();

        for (int i = 0; i < keys.length; i++) {
            trie.insert(keys[i]);
        }
//        System.out.println(trie.search("ans"));
        System.out.println(trie.wordCount("hak"));
    }
}
