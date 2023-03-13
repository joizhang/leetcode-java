package com.joizhang.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. Word Search II
 */
public class Q212WordSearchII {

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w: words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, m, n, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int m, int n, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null;
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, m, n, i - 1, j, p, res);
        if (j > 0) dfs(board, m, n, i, j - 1, p, res);
        if (i < m - 1) dfs(board, m, n, i + 1, j, p, res);
        if (j < n - 1) dfs(board, m, n, i, j + 1, p, res);
        board[i][j] = c;
     }

    public static void main(String[] args) {
        Q212WordSearchII test = new Q212WordSearchII();
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'},
        };
        String[] words = new String[]{"oath","pea","eat","rain"};
        System.out.println(test.findWords(board, words));
        board = new char[][]{
                {'a', 'b'},
                {'c', 'd'},
        };
        words = new String[]{"abcb"};
        System.out.println(test.findWords(board, words));
    }
}
