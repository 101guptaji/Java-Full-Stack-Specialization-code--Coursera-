import java.util.*;
/**
 * Write a description of EfficientMarkovWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EfficientMarkovWord implements IMarkovModel{
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    private HashMap<WordGram, ArrayList<String>> myMap;
    
    public EfficientMarkovWord(int order) {
        myRandom = new Random();
        myOrder = order;
        myMap = new HashMap<WordGram, ArrayList<String>>();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
        buildMap();
        printHashMapInfo();
    }
    
    private void buildMap()
    {
        for(int i=0;i<=myText.length-myOrder;i++)
        {
            WordGram wg = new WordGram(myText, i, myOrder);
            String next ="";
            //to handle last words
            if(i+myOrder < myText.length)
            {
                next = myText[i+myOrder];
            }
                  
            if(!myMap.containsKey(wg))
            {
                ArrayList<String> follows = new ArrayList<String>();
                follows.add(next);
                myMap.put(wg, follows);
                //System.out.println(myMap);
            }
            else
            {
                myMap.get(wg).add(next);
            }
        }
    }
    
    private int indexOf(String[] words, WordGram target, int start)
    {
        for(int i = start;i<words.length-myOrder;i++)
        {
            WordGram wg = new WordGram(words, i, myOrder);
            //System.out.println(i+"\t"+wg+" \t "+target);
            if(wg.equals(target))
            {
                //System.out.println(i+"\t"+wg+" \t "+target);
                return i;
            }
        }
        return -1;
    }
    
    private ArrayList<String> getFollows(WordGram kGram) {
        return myMap.get(kGram);
    }
    
    public String getRandomText(int numWords){
        
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
        WordGram kGram = new WordGram(myText, index, myOrder);
        //System.out.println("K Gram: "+kGram);
        sb.append(kGram.toString());
        sb.append(" ");
        for(int k=0; k < numWords-myOrder; k++){
            ArrayList<String> follows = getFollows(kGram);
            //System.out.println("follows: "+follows);
            if (follows == null || follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            kGram = kGram.shiftAdd(next);
            //System.out.println("K Gram: "+kGram);
        }
        
        return sb.toString().trim();
    }
    
    public void printHashMapInfo()
    {
        if(myMap.keySet().size() < 100)
            { System.out.println(myMap);}
            
        System.out.println("No. of Keys: "+myMap.keySet().size());
        
        int maxSize = 0;
        for(WordGram key : myMap.keySet())
        {
            int size = myMap.get(key).size();
            if(size > maxSize)
            {
                maxSize = size;
            }
        }
        System.out.println("Size of largest Arraylist: "+maxSize);
        
        ArrayList<WordGram> maxSizeKey = new ArrayList<WordGram>();
        for(WordGram key : myMap.keySet())
        {
            if(myMap.get(key).size() == maxSize)
            {
                maxSizeKey.add(key);
            }
        }
        System.out.println("Key with largest size: "+maxSizeKey);
    }
    
    public String toString()
    {
        return "Efficient Markov word of order "+myOrder;
    }
}
