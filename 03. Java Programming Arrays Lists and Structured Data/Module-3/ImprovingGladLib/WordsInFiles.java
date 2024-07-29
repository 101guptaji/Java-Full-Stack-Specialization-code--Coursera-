import java.util.*;
import java.io.File;
import edu.duke.*;
/**
 * Assignment 2: Words in Files
    Write a program to determine which words occur in the greatest number of files, and for each word, which files they occur in. 
    
    For example, consider you are given the four files: brief1.txt, brief2.txt, brief3.txt, and brief4.txt.
    brief1.txt is:  
    cats are funny and cute
    brief2.txt is: 
    dogs are silly
    brief3.txt is:
    love animals cats and dogs
    brief4.txt is:
    love birds and cats
    The greatest number of files a word appears in is three, and there are two such words: “cats” and “and”.
    “cats” appears in the files: brief1.txt, brief3.txt, brief4.txt
    “and” appears in the files: brief1.txt, brief3.txt, brief4.txt
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordsInFiles {
    //A private variable to store a HashMap that maps a word to an ArrayList of filenames.
    private HashMap <String, ArrayList<String>> wordsMap;
    //A constructor to initialize the HashMap variable.
    public WordsInFiles()
    {
        wordsMap = new HashMap <String, ArrayList<String>> ();
    }
    
    //a private void method named addWordsFromFile that has one parameter f of type File. This method should add all the words from f into the map.
    private void addWordsFromFile(File f)
    {
        
        FileResource fr =new FileResource(f);
        for(String word : fr.words())
        {
            if(!wordsMap.containsKey(word))
            {
                ArrayList<String> fileList = new ArrayList<String>();
                fileList.add(f.getName());
                wordsMap.put(word, fileList);
            }
            else
            {
                ArrayList<String> fileList  = wordsMap.get(word);
                if(!fileList.contains(f.getName()))
                {
                    fileList.add(f.getName());
                    wordsMap.put(word, fileList);
                }
            }
        }
    }
    
    //a void method named buildWordFileMap that has no parameters. This method first clears the map, and then uses a DirectoryResource to select a group of files.
    private void buildWordFileMap()
    {
        wordsMap.clear();
        DirectoryResource dr =new  DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            addWordsFromFile(f);
        }
        /*
        ArrayList <String> files;
        for(String key : wordsMap.keySet())
        {
            System.out.println(key);
            files = wordsMap.get(key);
            for(int i =0;i<files.size();i++)
            {
                System.out.print(files.get(i)+"\t");
            }
            System.out.println();
        }*/
        
    }
    
    //Write the method maxNumber that has no parameters. This method returns the maximum number of files any word appears in, considering all words from a group of files.
    private int maxNumber()
    {
        int maxSize = 0;
        for(String key : wordsMap.keySet())
        {
            int size = wordsMap.get(key).size();
            if(size > maxSize)
                maxSize = size;
        }
        return maxSize;
    }
    
    //Write the method wordsInNumFiles that has one integer parameter called number. This method returns an ArrayList of words that appear in exactly number files.
    private ArrayList<String> wordsInNumFiles(int num)
    {
        ArrayList <String> files = new ArrayList<String> ();
        for(String key : wordsMap.keySet())
        {
            int size = wordsMap.get(key).size();
            if(size == num)
                files.add(key);
        }
        return files;
    }
    
    //Write the void method printFilesIn that has one String parameter named word. This method prints the names of the files this word appears in, one filename per line. 
    private void printFilesIn(String word)
    {
        ArrayList <String> files;
        for(String key : wordsMap.keySet())
        {
            if(key.equals(word))
            {
                files = wordsMap.get(key);
                for(int i =0;i<files.size();i++)
                {
                    System.out.println(files.get(i));
                }
                break;
            }
        }
    }
    
    //Write the void method tester that has no parameters. This method should call buildWordFileMap to select a group of files and build a HashMap of words, with each word mapped to an ArrayList of the filenames this word appears in, determine the maximum number of files any word is in, considering all words, and determine all the words that are in the maximum number of files and for each such word, print the filenames of the files it is in.
    public void tester()
    {
        buildWordFileMap();
        int max = maxNumber();
        System.out.println("The greatest number of files a word appears in is: "+max);
        
        ArrayList<String> wordsList = wordsInNumFiles(max);
        System.out.println("No. of those words are: "+wordsList.size()); 
        System.out.println("and those words are: ");
        for(int i =0;i<wordsList.size();i++)
        {
            System.out.print(wordsList.get(i)+",\t");
        }
        System.out.println();
        //printFilesIn("laid");
        /*
        for(int i =0;i<wordsList.size();i++)
        {
            System.out.println("\""+wordsList.get(i)+"\" appears in the files:");
            printFilesIn(wordsList.get(i));
        }*/
    }
}














