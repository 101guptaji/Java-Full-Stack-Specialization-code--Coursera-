import edu.duke.*;
/**
 * Create the TestCaesarCipher class with the following parts:

    Include the methods countLetters and maxIndex that you wrote in the previous lesson.
    
    Write the void method simpleTests that has no parameters. 
    This method should read in a file as a String, create a CaesarCipher object with key 18, encrypt the String read in using the CaesarCipher object, print the encrypted String, and decrypt the encrypted String using the decrypt method.
    
    Write the method breakCaesarCipher that has one String parameter named input. 
    This method should figure out which key was used to encrypt this message (in a similar manner as the previous lesson), then create a CaesarCipher object with that key and decrypt the message.
    
    In the simpleTests method, add a call to breakCaesarCipher on the encrypted String to decrypt it automatically by determining the key, and print the decrypted String.
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipher {
    private String alpha;
    
    public int[] countLetters(String msg)
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
    
    public int maxIndex(int[] value)
    {
        int max = 0;
        for(int i =0;i<value.length;i++)
        {
            if(value[i]>value[max])
            {
                max = i;
            }
        }
        return max;
    }
    
    public int breakCaesarCipher(String input)
    {
        int[] freq = countLetters(input);
        int maxIndex = maxIndex(freq);
        //System.out.println("maxIndex "+maxIndex);
        //assuming 'e' is largest value, finding distance from 'e' which has index 4
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
        int key = 15;
        CaesarCipher cc = new CaesarCipher(key);
        String encrypted = cc.encrypt(msg);
        System.out.println("Key: "+key+"\nEncrypted msg: "+encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("Decrypted msg: "+decrypted);
        
        int dKey = breakCaesarCipher(encrypted);
        CaesarCipher cc2 = new CaesarCipher(dKey);
        String decrypted2 = cc2.decrypt(encrypted);
        System.out.println("dKey: "+dKey+"\tDecrypted msg: "+decrypted2);
    }
}
