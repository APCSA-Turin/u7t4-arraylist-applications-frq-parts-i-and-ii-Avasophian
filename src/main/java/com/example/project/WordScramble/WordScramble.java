package com.example.project.WordScramble;


import java.util.ArrayList;
import java.util.Arrays;

public class WordScramble {
  /** Scrambles a given word.
   *
   *  @param word  the word to be scrambled
   *  @return  the scrambled word (possibly equal to word)
   *
   *  Precondition: word is either an empty string or contains only uppercase letters.
   *  Postcondition: the string returned was created from word as follows:
   *  - the word was scrambled, beginning at the first letter and continuing from left to right
   *  - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
   *  - letters were swapped at most once
   */
  public static String scrambleWord(String word) 
  {
      String newString = "";
      if (word.length() == 1)
      {
        return word;
      }
      for (int i = 0; i < word.length() - 1; i++)
      {
          String w = word.substring(i, i+1);
          String wAhead =  word.substring(i+1, i+2);
          if (w.equals("A") && !(wAhead.equals("A")))
          {
             newString += wAhead;
             newString += w;
             i += 1;
             if (i == word.length() - 2)
             {
               newString += word.substring(i+1, i+2);
             }
          }
          else
          {
            newString += w;
            if (i == word.length() - 2)
            {
              newString += wAhead;
            }
          }
         
      }
      return newString;
  }
   public static void main(String[] args) 
    {
        ArrayList<String> testWordList = new ArrayList<String>(Arrays.asList("TAN", "ABRACADABRA", "WHOA", "APPLE", "EGGS"));
        testWordList = WordScramble.scrambleOrRemove(testWordList);
        ArrayList<String> expectedAfterScrambleRemove = new ArrayList<String>(Arrays.asList("TNA", "BARCADABARA", "PAPLE"));
        System.out.println(testWordList);
     }
  /** Modifies wordList by replacing each word with its scrambled
   *  version, removing any words that are unchanged as a result of scrambling.
   *
   *  @param wordList the list of words
   *
   *  Precondition: wordList contains only non-null objects
   *  Postcondition:
   *  - all words unchanged by scrambling have been removed from wordList
   *  - each of the remaining words has been replaced by its scrambled version
   *  - the relative ordering of the entries in wordList is the same as it was
   *    before the method was called
   */
  public static ArrayList<String> scrambleOrRemove(ArrayList<String> wordList) {
     ArrayList<String> newList = new ArrayList<String>();
      for (String word : wordList)
      {
        newList.add(scrambleWord(word));
      }

      
      for (int i = 0; i < newList.size(); i++)
      {
        if (newList.get(i).equals(wordList.get(i)))
        {
            newList.remove(i);
            wordList.remove(i);
            i --;
        }
      }
      wordList = newList;
      return wordList;
  }
}
