import java.util.*;

/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarkovOne {
    private String myText;
    private Random myRandom;
    
    public MarkovOne() {
        myRandom = new Random();
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
        int index = myRandom.nextInt(myText.length()-1);
        String  key = myText.substring(index, index+1);
        sb.append(key);
        
        for(int k=0; k < numChars-1; k++){
            ArrayList<String> follows = getFollows(key);
            //System.out.println("Key: "+key+" "+follows);
            if(follows.size() == 0)
            {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = next;
        }
        
        return sb.toString();
    }
    
    public ArrayList<String> getFollows(String key)
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
