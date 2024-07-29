import edu.duke.*;
/**
 * Assignment 1: Word lengths
    You will write a program to figure out the most common word length of words from a file. 
    To solve this problem you will need to keep track of how many words from a file are of each possible length. 
    You should group all words of length 30 or more together, and you should not count basic punctuation that are the first or last characters of a group of characters
 * Write a void method countWordLengths that has two parameters, a FileResource named resource and an integer array named counts. 
 * This method should read in the words from resource and count the number of words of each length for all the words in resource, storing these counts in the array counts.
     - For example, after this method executes, counts[k] should contain the number of words of length k.
 * Write a method indexOfMax that has one parameter named values that is an integer array. 
 * This method returns the index position of the largest element in values. 
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordLengths {

    public int[] countWordLengths(FileResource res, int[] count)
    {
        for(String word : res.words())
        {
            int len = word.length();         
            if (len >= count.length) {                 
                len = count.length - 1;            
            }      
            if (len > 0 ) 
            {                
                if(!Character.isLetter(word.charAt(0)))
                    len--;
                if(len>0 && !Character.isLetter(word.charAt(len-1)))
                    len--;
                count[len]++;
                
            }
        }
        return count;
    }
    
    public int indexOfMax(int[] value)
    {
        int max = 0;
        for(int i =0;i<value.length;i++)
        {
            if(value[i]>value[max])
            {
                max =i;
            }
        }
        return max;
    }
    
    public void testCountWordLengths()
    {
        FileResource fr = new FileResource();
        int[] count = new int[31];
        count = countWordLengths(fr, count);
        for(int i=0;i<count.length;i++)
        {
            if(count[i] > 0)
                System.out.println("Words of length "+(i)+": "+count[i]);       
        }
        
        int maxVal = indexOfMax(count);
        System.out.println("maximum Words of length: "+maxVal); 
    }
}
