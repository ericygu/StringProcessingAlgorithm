package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Trie {
    public static class TrieNode {
        private HashMap<Character, TrieNode> charMap = new HashMap<>();
        private boolean isEnd = false;

        public boolean isEmpty(TrieNode trieNode) {
            return (trieNode == null);
        }
        public boolean isEmpty(String string) {
            return (string.length() == 0);
        }
        public void insert(String s) {
            if (s.length() == 0) {
                charMap.put('\0', null);
                isEnd = true;
                return;
            }
            char c = s.charAt(0);
            TrieNode kid = charMap.get(c);
            if (isEmpty(kid)) {
                kid = new TrieNode();
                charMap.put(c, kid);
            }
            kid.insert(s.substring(1, s.length()));
        }

        public boolean contains(String s) {
            if (s.length() == 0) {
                return isEnd;
            } else if (charMap.containsKey(s.charAt(0))) {
                return charMap.get(s.charAt(0)).contains(s.substring(1, s.length()));
            } else {
                return false;
            }
        }
    }

    public TrieNode root = new TrieNode();

    public void insert(String s) {
        root.insert(s.toLowerCase());
    }

    public boolean contains(String s) {
        return root.contains(s.toLowerCase());
    }

    public void insertDictionary(String filename) throws FileNotFoundException {
        Scanner file = new Scanner(new File(filename));
        while (file.hasNext()) {
            root.insert(file.next().toLowerCase());
        }
    }

    /*
    public static void main(String[] args) throws Exception {
        System.out.println("Print Works");
        Trie t = new Trie();
        t.insert("abcdefg");
        System.out.println(t.contains("abcdefg"));
        System.out.println(t.contains("abcd"));
        System.out.println(t);
    }
     */

}

