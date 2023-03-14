package com.joizhang.lc.tree;

/**
 * 208. Implement Trie (Prefix Tree)
 */
public class Q208ImplementTrie {
    static class Trie {

        static class TrieNode {
            TrieNode[] next = new TrieNode[26];
            boolean isWord = false;
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.isWord = true;
        }

        public boolean search(String word) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) {
                    return false;
                }
                p = p.next[i];
            }
            return p.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (char c : prefix.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) {
                    return false;
                }
                p = p.next[i];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // return True
        System.out.println(trie.search("app")); // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app")); // return True
    }
}
