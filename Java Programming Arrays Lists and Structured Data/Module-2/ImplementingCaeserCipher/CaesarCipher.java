 
import edu.duke.*;
/**
 *1. Write the method encrypt that has two parameters, a String named input and an int named key. 
 *  This method returns a String that has been encrypted using the Caesar Cipher algorithm
 *2. Modify the encrypt method to be able to handle both uppercase and lowercase letters. 
 *  For example, encrypt(“First Legion”, 23) should return “Cfopq Ibdflk” 
 *3. Write the method encryptTwoKeys that has three parameters, a String named input, and two integers named key1 and key2. 
 *  This method returns a String that has been encrypted using the following algorithm. Parameter key1 is used to encrypt every other character with the Caesar Cipher algorithm, starting with the first character, and key2 is used to encrypt every other character, starting with the second character. 
 *  For example, the call encryptTwoKeys(“First Legion”, 23, 17) should return “Czojq Ivdzle”. 
 *  Note the ‘F’ is encrypted with key 23, the first ‘i’ with 17, the ‘r’ with 23, and the ‘s’ with 17, etc. 
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {

    public String encrypt(String input, int key)
    {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftAlpha = alpha.substring(key)+alpha.substring(0,key);
        //System.out.println(enc);
        //String in = "A BAT";
        StringBuilder ans = new StringBuilder();
        for(int i =0;i<input.length();i++)
        {
            char a = input.charAt(i);
            char b = a;
            if(Character.isLowerCase(b))
            {
                b = Character.toUpperCase(b);
            }
            int index = alpha.indexOf(b);
            if(index == -1)
                ans.append(b);
            else{
                //System.out.println(index);
                char shifted = shiftAlpha.charAt(index);
                if(Character.isLowerCase(a))
                {
                    shifted = Character.toLowerCase(shifted);
                }
                ans.append(shifted);
            }
        }
        return ans.toString();
    }
    
    public String encryptTwoKeys(String input, int key1, int key2)
    {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftAlpha1 = alpha.substring(key1)+alpha.substring(0,key1);
        String shiftAlpha2 = alpha.substring(key2)+alpha.substring(0,key2);
        //System.out.println(enc);
        //String in = "A BAT";
        StringBuilder ans = new StringBuilder();
        for(int i =0;i<input.length();i++)
        {
            char a = input.charAt(i);
            char b = a;
            if(Character.isLowerCase(b))
            {
                b = Character.toUpperCase(b);
            }
            int index = alpha.indexOf(b);
            if(index == -1)
                ans.append(b);
            else{
                //System.out.println(index);
                char shifted;
                if(i%2 == 0)
                {
                    shifted = shiftAlpha1.charAt(index);
                }
                else
                {
                    shifted = shiftAlpha2.charAt(index);
                }
                
                if(Character.isLowerCase(a))
                {
                    shifted = Character.toLowerCase(shifted);
                }
                ans.append(shifted);
            }
        }
        return ans.toString();
    }
    public void testCaeser()
    {
        /*
        int key = 15;
        FileResource fr = new FileResource();
        String msg = fr.asString();
        String encrypted = encrypt(msg, key);
        System.out.println("Key: "+key+"\n Encrypted msg: "+encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println("Decrypted msg: "+decrypted);
        */
        int key1 = 8, key2 = 21;
        FileResource fr = new FileResource();
        String msg = fr.asString();
        String encrypted = encryptTwoKeys(msg, key1, key2);
        System.out.println("Key1: "+key1+" Key2: "+key2+"\n Encrypted msg: "+encrypted);
        
    }
}
