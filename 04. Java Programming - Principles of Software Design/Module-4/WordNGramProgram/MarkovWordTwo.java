import java.util.*;

/**
 * Write a description of MarkovWordTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarkovWordTwo implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordTwo() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-2);  // random word to start with
        String key1 = myText[index];
        String key2 = myText[index+1];
        sb.append(key1);
        sb.append(" ");
        sb.append(key2);
        sb.append(" ");
        for(int k=0; k < numWords-2; k++){
            ArrayList<String> follows = getFollows(key1, key2);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key1 = key2;
            key2 = next;
        }
        
        return sb.toString().trim();
    }
    
    private ArrayList<String> getFollows(String key1, String key2) {
        ArrayList<String> ans = new ArrayList<String>();
        int pos = 0;
        
        while(pos < myText.length)
        {
            int index = indexOf(myText, key1, key2, pos);
            if(index == -1)
                break;
            
            pos = index+2;
            if(pos >= myText.length-1)
                break;
            
            String next = myText[pos];
            ans.add(next);
            
        }
        
        return ans;
    }
    
    private int indexOf(String[] words, String key1, String key2, int start)
    {
        for(int i = start;i<words.length-1;i++)
        {
            if(words[i].equals(key1) && words[i+1].equals(key2))
            {
                return i;
            }
        }
        return -1;
    }
    
     public String toString()
    {
        return "Markov of order 2";
    }
}
