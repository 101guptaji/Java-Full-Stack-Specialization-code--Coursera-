import java.util.*;

/**
 * Write a description of MarkovWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarkovWord implements IMarkovModel{
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    
    public MarkovWord(int order) {
        myRandom = new Random();
        myOrder = order;
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    
    private int indexOf(String[] words, WordGram target, int start)
    {
        for(int i = start;i<words.length-myOrder;i++)
        {
            WordGram wg = new WordGram(words, i, myOrder);
            //System.out.println(wg+" \t "+target);
            if(wg.equals(target))
            {
                //System.out.println(i+"\t"+wg+" \t "+target);
                return i;
            }
        }
        return -1;
    }
    
    private ArrayList<String> getFollows(WordGram kGram) {
        ArrayList<String> ans = new ArrayList<String>();
        int pos = 0;
        
        while(pos < myText.length)
        {
            int index = indexOf(myText, kGram, pos);
            if(index == -1)
                break;
            
            pos = index+1; //kGram.length();
            if(index+kGram.length() >= myText.length)
                break;
            
            String next = myText[index+kGram.length()];
            ans.add(next);
            
        }
        
        return ans;
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
        WordGram kGram = new WordGram(myText, index, myOrder);
        //System.out.println("K Gram: "+kGram);
        sb.append(kGram);
        sb.append(" ");
        for(int k=0; k < numWords-myOrder; k++){
            ArrayList<String> follows = getFollows(kGram);
            //System.out.println("follows: "+follows);
            if (follows.size() == 0) {
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
    
    public String toString()
    {
        return "Markov word of order "+myOrder;
    }
}
