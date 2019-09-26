package trie;

public class InsertAndSearch {
	static TrieNode root;
	
	static void insert(String key) {
		int index;
		TrieNode temp = root;
		for(int i=0;i<key.length();i++) {
			index = key.charAt(i) - 'a';
			if(temp.children[index] == null) {
				temp.children[index] = new TrieNode();
			}
			temp = temp.children[index];
		}
		temp.endOfWord = true;
	}
	
	static boolean search(String key) {
		TrieNode temp = root;
		
		for(int i= 0;i<key.length();i++) {
			int index = key.charAt(i) - 'a';
			if(temp.children[index] == null) {
				return false;
			}
			temp = temp.children[index];
		}
		
		boolean isPresent = temp != null && temp.endOfWord == true;
		return isPresent;
	}

	public static void main(String[] args) {
		root = new TrieNode();
		insert("god");
		System.out.println(search("god"));
		System.out.print(search("go"));
	}
}


class TrieNode {
	static int ALPHABET_SIZE = 26;
	boolean endOfWord;
	TrieNode[] children = new TrieNode[ALPHABET_SIZE];
	
	public TrieNode() {
		endOfWord = false;
		for(int i = 0;i<ALPHABET_SIZE;i++) {
			children[i] = null;
		}
	}
}
