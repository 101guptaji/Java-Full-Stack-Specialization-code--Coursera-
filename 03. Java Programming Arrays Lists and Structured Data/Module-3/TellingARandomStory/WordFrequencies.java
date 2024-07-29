import java.util.*;
import edu.duke.*;
/**
 * Write a program to determine the word that occurs the most often in a file. 
 * If more than one word occurs as the most often, then return the first such word found. You should make all words lowercase before counting them. 
 * Thus, “This” and “this” will both be counted as the lowercase version of “this”. 
 * You should not consider punctuation, so “end” and “end,” will be considered different words.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordFrequencies {
    private ArrayList <String> myWords;
    private ArrayList <Integer> myFreqs;
    
    public WordFrequencies()
    {
        myWords = new ArrayList <String>() ;
        myFreqs = new ArrayList <Integer>() ;
    }
    
    public void findUnique()
    {
        myWords.clear();
        myFreqs.clear();
        
        FileResource fr = new FileResource();
        for(String word : fr.words())
        {
            word = word.toLowerCase();
            int index = myWords.indexOf(word);
            if(index == -1)
            {
                myWords.add(word);
                myFreqs.add(1);
            }
            else
            {
                int val = myFreqs.get(index);
                myFreqs.set(index, val+1);
            }
        }
    }
    public int findIndexOfMax()
    {
        int index = 0;
        for(int i =0;i<myFreqs.size();i++)
        {
            if(myFreqs.get(i) > myFreqs.get(index))
            {
                index = i;
            }
        }
        return index;
    }
    
    public void tester()
    {
        findUnique();
        System.out.println("No. of Unique words: "+myWords.size());
        for(int i=0;i<myWords.size();i++)
        {
            System.out.println(myFreqs.get(i)+" "+myWords.get(i));
        }
        
        int maxIndex = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: "+myWords.get(maxIndex)+" "+myFreqs.get(maxIndex));
    }
}
