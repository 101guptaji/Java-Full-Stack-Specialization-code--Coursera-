import java.util.*;

/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarkovModel {

    private String myText;
    private Random myRandom;
    int nChar;
    
    public MarkovModel(int num) {
        myRandom = new Random();
        nChar = num;
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-nChar);
        String  key = myText.substring(index, index+nChar);
        sb.append(key);
        
        for(int k=0; k < numChars-nChar; k++){
            ArrayList<String> follows = getFollows(key);
            //System.out.println("Key: "+key+" "+follows);
            if(follows.size() == 0)
            {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            if(key.length() > 1)
            {
                key = key.substring(1)+next;
            }
            else
                key =  next;
        }
        
        return sb.toString();
    }
    
    public ArrayList<String> getFollows(String key)
    {
        ArrayList<String> ans = new ArrayList<String>();
        int index = myText.indexOf(key, 0);
        while(index != -1)
        {
            int len = index+key.length();
            if(len+1 < myText.length())
            {
                ans.add(myText.substring(len,len+1));
                index = myText.indexOf(key, index+1);
            }
            else
                break;
        }
        
        return ans;
    }
}
