import edu.duke.*;

/**
 * Assignment 2:  Caesar Cipher Two Keys Decrypt
    You should start by writing the decryption method explained in the lesson that decrypts a message that was encrypted with one key, using statistical letter frequencies of English text. 
    Then you will add code to be able to decrypt a message that was encrypted with two keys, using ideas from the single key decryption method and the encryption with two keys method from the program you wrote in the last lesson.
 * Write the methods countLetters, maxIndex, and decrypt. 
 * Write the method halfOfString in the CaesarBreaker class that has two parameters, a String parameter named message and an int parameter named start. 
 * This method should return a new String that is every other character from message starting with the start position.
 *Write the method getKey in the CaesarBreaker class that has one parameter, a String s. 
 *  This method should call countLetters to get an array of the letter frequencies in String s and then use maxIndex to calculate the index of the largest letter frequency, which is the location of the encrypted letter ‘e’, which leads to the key, which is returned.
 * Write the method decryptTwoKeys in the CaesarBreaker class that has one parameter, a String parameter named encrypted that represents a String that was encrypted with the two key algorithm.
 * This method attempts to determine the two keys used to encrypt the message, prints the two keys, and then returns the decrypted String with those two keys. 
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarBreaker {
    
    public int[] countLetters(String msg)
    {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] count = new int[26];
        for(int i=0;i<msg.length();i++)
        {
            char ch = Character.toLowerCase(msg.charAt(i));
            int dex = alpha.indexOf(ch);
            if(dex != -1)
            {
                count[dex]++;
            }
        }
        /*for(int i=0;i<count.length;i++)
        {
            System.out.println(alpha.charAt(i)+"'s count: "+count[i]);       
        }*/

        return count;
    }
    
    public int maxIndex(int[] value)
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
    
    public String decrypt(String encrypted)
    {
        CaesarCipher cc = new CaesarCipher();
        int[] freq = countLetters(encrypted);
        int maxIndex = maxIndex(freq);
        //System.out.println("maxIndex "+maxIndex); 
        //assuming 'e' is largest value, finding distance from 'e' which has index 4
        //for file wordsLotsOfEs.txt
        int dKey = maxIndex-4;
        if(maxIndex < 4)
        {
            dKey = 26 - (4-maxIndex);
        }
        //System.out.println("dKey "+dKey);
        //System.out.println("Key: "+(26-dKey));
        //Use 26-distance to decrypt using encrypt
        return cc.encrypt(encrypted, 26-dKey);
    }
    
    public void testDecrypt()
    {
        FileResource fr = new FileResource();
        for(String line : fr.lines())
        {
            String decrypted = decrypt(line);
            System.out.println("Encrypted data: "+line);
            System.out.println("Decrypted data: "+decrypted);
        }
    }
    
    public String halfOfString(String msg, int start)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=start;i<msg.length();i+=2)
        {
            sb.append(msg.charAt(i));
        }
    
        return sb.toString();
    }
    
    public int getKey(String encrypted)
    {
        int[] freq = countLetters(encrypted);
        int maxIndex = maxIndex(freq);
        //System.out.println("maxIndex "+maxIndex); 
        int dKey = maxIndex-4;
        if(maxIndex < 4)
        {
            dKey = 26 - (4-maxIndex);
        }
        //System.out.println("dKey "+dKey);
        //System.out.println("Key: "+(26-dKey));
        return dKey;
    }
    
    public String decryptTwoKeys(String encrypted)
    {
        CaesarCipher cc = new CaesarCipher();
        String enc1 = halfOfString(encrypted,0);
        int key1 = getKey(enc1);
        
        String enc2 = halfOfString(encrypted,1);
        int key2 = getKey(enc2);
        
        System.out.println("Key1: "+key1+"\t Key2 :"+key2);
        
        return cc.encryptTwoKeys(encrypted, 26-key1, 26-key2);
    }
    
    public void testDecryptTwoKeys()
    {
        FileResource fr = new FileResource();
        String line = fr.asString();        
        String decrypted = decryptTwoKeys(line);
        System.out.println("Encrypted data: "+line);
        System.out.println("Decrypted data: "+decrypted);
        
    }
}


























