package org.match.data;

import java.util.*;

/**
 * Created by eugennekhai on 07/07/16.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;

        TrieNode parent = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                t.parent = parent;
                children.put(c, t);
            }

            children = t.children;
            parent = t;

            if (i == word.length() - 1)
                t.isLeaf = true;
        }
    }

    public boolean search(String word) {
        TrieNode t = searchNode(word);
        return t.c != Character.MIN_VALUE && t.isLeaf;
    }

    private TrieNode searchNode(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = new EmptyNode();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return new EmptyNode();
            }
        }

        return t;
    }


    class TrieNode {
        TrieNode parent;
        HashMap<Character, TrieNode> children = new HashMap<>();
        char c;
        boolean isLeaf;

        public TrieNode() {
        }

        public TrieNode(char c) {
            this.c = c;
        }
    }

    class EmptyNode extends TrieNode {
        EmptyNode() {
            this.c = Character.MIN_VALUE;
        }

    }
}
