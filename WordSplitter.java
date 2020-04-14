package com.company;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class WordSplitter {
    private static Trie dictionary = new Trie();

    public static void main(String[] args) throws Exception {
        // Consider using the following if you haven't done Trie.java yet:
        dictionary.insertDictionary(args[0]);
        System.out.println(wordSplit(args[1]));
        //System.out.println(wordSplit("thereisareason"));
    }

    public static String wordSplit(String s) {
        //base case
        if (s.length() == 0) {
            return (" ");
        }
        //other cases
        String storedWord = "";
        while(true) {
            if (s.length() == 0) {
                return "No splitting found.";
            }
            storedWord += s.charAt(0);
            s = s.substring(1, s.length());
            if (dictionary.contains(storedWord)) {
                String stringRecursion = wordSplit(s);
                if (stringRecursion !=  "No splitting found.") {
                    return storedWord + " " + stringRecursion;
                }
            }
        }


        /*
        //First Implementation -- Failed

        int size = s.length();

        // base case
        if (size == 0)
            return ("");

        //else check for all words
        String cigar = "";
        int i = 1;
        while (i <= size) {
            // Now we will first divide the word into two parts ,
            // the prefix will have a length of i and check if it is
            // present in dictionary, if yes then we will check for
            // suffix of length size-i recursively. if both prefix and
            // suffix are present the word is found in dictionary.
            int j = 0;
            if (dictionary.contains(s.substring(j,i))) {
                cigar = cigar + s.substring(j, i);
                j++;
                i++;
                wordSplit(s.substring(j,size));
            }
                return cigar + wordSplit(s.substring(i, size));
        }

        // if all cases failed then return false
        return ("No splitting found.");
        */


/*
        //Second Implementation -- Failed
        if (s.length() == 0) {
            return ("");
        }
        //recursion -- email
        for (int i = 1; i <= s.length(); i++) {
            if (s.length() == 0) {
                return "No split";
            }

            if (dictionary.contains(s.substring(0, i))) {
                //2 decisions
                //1 - add another letter
                //2 - add a space
                String next = wordSplit(s);
                if (next != "No split") {
                    return s.substring(0,i) + next;
                }
               //return (s.substring(0, i) + " " + wordSplit(s.substring(i, s.length())));
            }
        }
        return ("No splitting found.");
*/


        //Third Implementation -- Failed
        /*
        if (s.isEmpty()) {
            return ("");
        }
        String sumOfLetters = "";
        for (int i = 1; i <= s.length(); i++) {
                sumOfLetters += s.charAt(0);
                s = s.substring(1, s.length());
                if (dictionary.contains(sumOfLetters)) {
                    String ans = wordSplit(s);
                    if (!ans.isEmpty()) {
                        return (sumOfLetters + " " + ans);
                    }
                }
        }
        return ("No splitting found.");

 */
    }


}
