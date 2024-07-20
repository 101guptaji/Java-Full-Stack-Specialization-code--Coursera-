import edu.duke.*;
/**
 * Create the TestCaesarCipherTwo class with the following parts:
    Include the methods halfOfString, countLetters, and maxIndex that you wrote in the previous lesson.
    
    Write the void method simpleTests that has no parameters. 
    This method should read in a file as a String, create a CaesarCipherTwo object with keys 17 and 3, encrypt the String using the CaesarCipherTwo object, print the encrypted String, and decrypt the encrypted String using the decrypt method.
    
    Write the method breakCaesarCipher that has one String parameter named input. 
    This method should figure out which keys were used to encrypt this message (in a similar manner as before), then create a CaesarCipherTwo object with that key and decrypt the message.
    
    In the simpleTests method, add a call to breakCaesarCipher on the encrypted String to decrypt it automatically by determining the keys, and then print the decrypted String.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipherTwo {
    private String alpha;
    
    private String halfOfString(String msg, int start)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=start;i<msg.length();i+=2)
        {
            sb.append(msg.charAt(i));
        }
    
        return sb.toString();
    }
    
    private int[] countLetters(String msg)
    {
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] count = new int[26];
        for(int i=0;i<msg.length();i++)
        {
            char ch = Character.toUpperCase(msg.charAt(i));
            int dex = alpha.indexOf(ch);
            if(dex != -1)
            {
                count[dex]++;
            }
        }
        return count;
    }
    
    private int maxIndex(int[] value)
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
    
    public int breakCaesarCipher(String input)
    {
        int[] freq = countLetters(input);
        int maxIndex = maxIndex(freq);
        //System.out.println("maxIndex "+maxIndex); 
        int dKey = maxIndex-4;
        if(maxIndex < 4)
        {
            dKey = 26 - (4-maxIndex);
        }
        //System.out.println("dKey "+dKey);
        return dKey;
    }
    
    public void simpleTests()
    {
        FileResource fr = new FileResource();
        String msg = fr.asString();
        int key1 = 14, key2 = 24;
        CaesarCipherTwo cc = new CaesarCipherTwo(key1, key2);
        String encrypted = cc.encryptTwoKeys(msg);
        System.out.println("Key1: "+key1+" Key2: "+key2);
        System.out.println("Encrypted msg: "+encrypted);
        String decrypted = cc.decryptTwoKeys(encrypted);
        System.out.println("Decrypted msg: "+decrypted);
        
        
        String encrypt1 = halfOfString(encrypted, 0);
        int dKey1 = breakCaesarCipher(encrypt1);
        
        String encrypt2 = halfOfString(encrypted, 1);
        int dKey2 = breakCaesarCipher(encrypt2);
        //System.out.println(encrypt0+"\t"+encrypt1);
        CaesarCipherTwo cc2 = new CaesarCipherTwo(dKey1, dKey2);
        String decrypted2 = cc2.decryptTwoKeys(encrypted);
        System.out.println("dKey1: "+dKey1+"\tdKey2: "+dKey2);
        System.out.println("Decrypted msg: "+decrypted2);
        
    }
}
