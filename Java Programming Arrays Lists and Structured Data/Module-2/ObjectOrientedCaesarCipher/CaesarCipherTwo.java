
/**
 * Create the CaesarCipherTwo class with the following parts:
    Include private fields for the alphabet, shiftedAlphabet1, and shiftedAlphabet2.
    Write a constructor CaesarCipherTwo that has two int parameters key1 and key2. 
    This method should initialize all the private fields.
    Write an encrypt method that has one String parameter named input. 
    This method returns a String that is the input encrypted using the two shifted alphabets.
    Write a decrypt method that has one String parameter named input. 
    This method returns a String that is the encrypted String decrypted using the key1 and key2 associated with this CaesarCipherTwo object. 
    You might want to add more private fields to the class.
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1, shiftedAlphabet2;
    public int mainKey1, mainKey2;
    
    public CaesarCipherTwo(int key1, int key2)
    {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }
    
    public String encryptTwoKeys(String input)
    {
        StringBuilder ans = new StringBuilder();
        for(int i =0;i<input.length();i++)
        {
            char a = input.charAt(i);
            char b = a;
            if(Character.isLowerCase(b))
            {
                b = Character.toUpperCase(b);
            }
            int index = alphabet.indexOf(b);
            if(index == -1)
                ans.append(b);
            else{
                //System.out.println(index);
                char shifted;
                if(i%2 == 0)
                {
                    shifted = shiftedAlphabet1.charAt(index);
                }
                else
                {
                    shifted = shiftedAlphabet2.charAt(index);
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
    
    public String decryptTwoKeys(String encrypted)
    {
        CaesarCipherTwo c2c =new CaesarCipherTwo(26-mainKey1, 26-mainKey2);
        String decrypted = c2c.encryptTwoKeys(encrypted);
        return decrypted;
    }
}
