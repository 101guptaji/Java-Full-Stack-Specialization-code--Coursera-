
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);
    
    protected ArrayList<String> getFollows(String key)
    {
        ArrayList<String> ans = new ArrayList<String>();
        int pos = 0;
        int index = myText.indexOf(key, pos);
        while(index != -1)
        {
            pos = index+1;
            if(pos >= myText.length())
                break;
            int len = index+key.length();
            if(len < myText.length())
            {
                ans.add(myText.substring(len,len+1));
                index = myText.indexOf(key, pos);
            }
            else
                break;
        }
        
        return ans;
    }
}
