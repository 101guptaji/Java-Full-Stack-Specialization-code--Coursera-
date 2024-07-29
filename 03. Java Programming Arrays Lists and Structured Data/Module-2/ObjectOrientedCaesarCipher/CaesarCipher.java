
/**
 * Create the CaesarCipher class with the following parts:
    Private fields for the alphabet and shiftedAlphabet
    Write a constructor CaesarCipher that has one int parameter key. 
    This method should initialize all the private fields of the class.
    
    Write an encrypt method that has one String parameter named input. 
    This method returns a String that is the input encrypted using shiftedAlphabet.
    
    Write a decrypt method that has one String parameter named input. 
    This method returns a String that is decrypted using the key associated with this CaesarCipher object. 
    One way to do this is to create another private field mainKey, which is initialized to be the value of key. 
    Then you can create a CaesarCipher object within decrypt: CaesarCipher cc = new CaesarCipher(26 - mainKey); and call cc.encrypt(input).
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    public int mainKey;
    
    public CaesarCipher(int key)
    {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        mainKey = key;
    }
    
    public String encrypt(String input)
    {
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<input.length();i++)
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
                char shifted = shiftedAlphabet.charAt(index);
                if(Character.isLowerCase(a))
                {
                    shifted = Character.toLowerCase(shifted);
                }
                ans.append(shifted);
            }
        }
        return ans.toString();
    }
    
    public String decrypt(String encrypted)
    {
        //Use 26-distance to decrypt using encrypt
        CaesarCipher cc =new CaesarCipher(26-mainKey);
        String decrypted = cc.encrypt(encrypted);
        return decrypted;
    }
}
