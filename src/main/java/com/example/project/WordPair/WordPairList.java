package com.example.project.WordPair;


import java.util.ArrayList;

public class WordPairList {
    private ArrayList<WordPair> allPairs;

    public WordPairList(String[] words) 
    {
        allPairs = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++)
        {
            for (int j = i + 1; j < words.length; j++)
            {
                allPairs.add(new WordPair(words[i], words[j]));
            }
        }

    }

    public static void main(String[] args) 
    {
        String[] wordNums = {"one", "two", "three"};
        WordPairList exampleOne = new WordPairList(wordNums);
        System.out.println(exampleOne.getAllPairs());        
    }

    // The method below was added for testing;
    // it was not part of the original FRQ
    public ArrayList<WordPair> getAllPairs() {
        return allPairs;
    }

    public int numMatches() {
        int matchNum = 0;
        String word1 = "";
        String word2 = "";

        for (int i = 0; i < allPairs.size(); i++)
        {
            word1 = allPairs.get(i).getFirst();
            word2 = allPairs.get(i).getSecond();
            if (word1.equals(word2))
            {
                matchNum ++;
            }
        }
        return matchNum;

    }

    // The method below was added for testing;
    // it was not part of the original FRQ
    public String toString() {
        return allPairs.toString();
    }
}
