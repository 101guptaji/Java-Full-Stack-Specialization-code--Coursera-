import java.util.*;

/**
 * Write a description of EfficientMarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EfficientMarkovModel extends AbstractMarkovModel {

    private int nChar;
    private HashMap<String, ArrayList<String>> myMap;
    
    public EfficientMarkovModel (int num) {
        nChar = num;
        myMap = new HashMap<String, ArrayList<String>> ();
    }
    
    private void buildMap(int numChars)
    {
        if (myText != null)
        {
            for(int k=0; k <= myText.length()-nChar; k++)
            {
                String  key = myText.substring(k, k+nChar);
                if(!myMap.containsKey(key))
                {
                    ArrayList<String> follows = getFollows(key);
                    myMap.put(key, follows);
                }
                
            }
        }
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        buildMap(numChars);
        printHashMapInfo();
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-nChar);
        String  key = myText.substring(index, index+nChar);
        sb.append(key);
        
        for(int k=0; k < numChars-nChar; k++){
            ArrayList<String> follows = myMap.get(key);
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
        return "this is the EfficientMarkovModel class of order "+nChar;
    }
    
    public void printHashMapInfo()
    {
        if(myMap.keySet().size() < 100)
            { System.out.println(myMap);}
        System.out.println("No. of Keys: "+myMap.keySet().size());
        int maxSize = 0;
        ArrayList<String> maxSizeKey = new ArrayList<String>();
        for(String key : myMap.keySet())
        {
            int size = myMap.get(key).size();
            if(size > maxSize)
            {
                maxSize = size;
            }
        }
        System.out.println("Size of largest Arraylist: "+maxSize);
        for(String key : myMap.keySet())
        {
            if(myMap.get(key).size() == maxSize)
            {
                maxSizeKey.add(key);
            }
        }
        System.out.println("Key with largest size: "+maxSizeKey);
        
    }
}