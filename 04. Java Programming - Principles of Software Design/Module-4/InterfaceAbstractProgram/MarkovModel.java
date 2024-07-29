import java.util.*;

/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarkovModel extends AbstractMarkovModel {

    private int nChar;
    
    public MarkovModel(int num) {
        nChar = num;
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
    
    public String toString()
    {
        return "MarkovModel of order "+nChar;
    }
}
