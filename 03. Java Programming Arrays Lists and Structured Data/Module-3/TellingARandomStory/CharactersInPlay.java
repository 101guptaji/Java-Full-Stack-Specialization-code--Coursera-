import java.util.ArrayList;
import edu.duke.*;
/**
 * Write a program to determine the characters in one of Shakespeare’s plays that have the most speaking parts.
 * Note that each speaking part is at the beginning of the line (there may be some blanks before it) and has a period immediately following it.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharactersInPlay {
    
    private ArrayList <String> charNames;
    private ArrayList <Integer> counts;
    
    public CharactersInPlay()
    {
        charNames = new ArrayList <String>() ;
        counts = new ArrayList <Integer>() ;
    }
    
    private void update(String person)
    {
        int index = charNames.indexOf(person);
        if(index == -1)
        {
            charNames.add(person);
            counts.add(1);
        }
        else
        {
            int val = counts.get(index);
            counts.set(index,val+1);
        }
    }
    
    private void findAllCharacters()
    {
        charNames.clear();
        counts.clear();
        
        FileResource fr = new FileResource();
        for(String line : fr.lines())
        {
            int dotIndex = line.indexOf(".");
            if(dotIndex != -1)
            {
                update(line.substring(0,dotIndex));
            }
        }
    }
    
    public void tester()
    {
        findAllCharacters();
        /*
        for(int i =0;i<counts.size();i++)
        {
            if(counts.get(i) > 1)
            {
                System.out.println(charNames.get(i)+"\t"+counts.get(i));
            }
        }*/
        
        charactersWithNumParts(10,15);
    }
    
    public void charactersWithNumParts(int num1, int num2)
    {
        int count = 0;
        for(int i =0;i<counts.size();i++)
        {
            if(counts.get(i) >= num1 && counts.get(i) <= num2)
            {
                System.out.println(charNames.get(i)+"\t"+counts.get(i));
                count++;
            }
        }
        System.out.println("No. of characters: "+count);
    }
}














