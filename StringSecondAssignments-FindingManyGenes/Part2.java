
/**
 * Part 2: HowMany - Finding Multiple Occurrences
This assignment will write a method to determine how many occurrences of a string appear in another string.
 * 
 * @author HimanshuGupta 
 * @version 1.0
 */
public class Part2 {
    
    public int howMany(String stringA, String stringB)
    {
        int count = 0;
        int index1 = stringB.indexOf(stringA);
        while(index1 != -1)
        {
            count++;
            index1 = stringB.indexOf(stringA,index1+stringA.length());
        }
        
        return count;
    }
    
    public void testHowMany()
    {
        String a;
        String b;
        a = "AA";
        b = "ATAAAA";
        int cnt = howMany(a,b);
        System.out.println("Occurance of '"+a+"' in '"+b+"' :"+cnt);
        
        a = "GAA";
        b = "ATGAACGAATTGAATC";
        cnt = howMany(a,b);
        System.out.println("Occurance of '"+a+"' in '"+b+"' :"+cnt);
    }
}
