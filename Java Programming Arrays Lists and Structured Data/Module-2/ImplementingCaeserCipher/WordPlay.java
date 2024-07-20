
/**
 * Assignment 1: Word Play 
You will write a program to transform words from a file into another form, such as replacing vowels with an asterix. 
 *1. Write a method isVowel that has one Char parameter named ch. 
 *  This method returns true if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and false otherwise. 
 *  You should write a tester method to see if this method works correctly.
 *2. Write a method replaceVowels that has two parameters, a String named phrase and a Char named ch. 
 *  This method should return a String that is the string phrase with all the vowels (uppercase or lowercase) replaced by ch. 
 *3. Write a method emphasize with two parameters, a String named phrase and a character named ch. 
 *  This method should return a String that is the string phrase but with the Char ch (upper- or lowercase) replaced by
    ‘*’ if it is in an odd number location in the string (e.g. the first character has an odd number location but an even index, it is at index 0), or
    ‘+’ if it is in an even number location in the string (e.g. the second character has an even number location but an odd index, it is at index 1).
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    
    public boolean isVowel(char ch)
    {
        String vowels = "AEIOUaeiou";
        for(int i = 0;i<vowels.length();i++) 
        {
            if(vowels.charAt(i) == ch)
            {
                return true;
            }
        }
        return false;
    }
    
    public String replaceVowels(String phrase, char ch)
    {
        StringBuilder sb = new StringBuilder(phrase);
        for(int i =0;i<phrase.length();i++)
        {
            if(isVowel(sb.charAt(i)))
            {
                sb.setCharAt(i, ch);
            }
        }
        return sb.toString();
    }
    
    public String emphasize(String phrase, char ch)
    {
        StringBuilder sb = new StringBuilder(phrase);
        for(int i =0;i<phrase.length();i++)
        {
            if(sb.charAt(i) == ch)
            {
                if(i%2 == 0)
                    sb.setCharAt(i,'*');
                else
                    sb.setCharAt(i,'+');
            }
        }
        return sb.toString();
    }
    
    public void tester()
    {
        char ch = 'f';
        System.out.println(ch+" is a vowel?"+isVowel(ch));
        
        ch = 'O';
        System.out.println(ch+" is a vowel?"+isVowel(ch));
        
        String toReplace = "Hello World!";
        String replaced = replaceVowels(toReplace,'*');
        System.out.println("Original String "+toReplace);
        System.out.println("String after replace vowels "+replaced);
        
        String toEmphasize = "dna ctgaaactga";
        String emphasized = emphasize(toEmphasize,'a');
        System.out.println("Original String "+toEmphasize);
        System.out.println("String after emphasize "+emphasized);
    }
}
