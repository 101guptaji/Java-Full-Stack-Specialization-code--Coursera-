
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {

    public boolean twoOccurrences(String stringA, String stringB)
    {
        int index1 = stringB.indexOf(stringA);
        if(index1 == -1)
            return false;
            
        int index2 = stringB.indexOf(stringA, index1+stringA.length());
        if(index2 == -1)
            return false;
            
        return true;
    }
    
    public String lastPart(String stringA, String stringB)
    {
        int index1 = stringB.indexOf(stringA);
        if(index1 == -1)
            return stringB;
        else            
            return stringB.substring(index1+stringA.length());
    }
    
    public void testing()
    {
        String stringA;
        String stringB;
        String partOfString;
        stringA = "by";
        stringB = "A story by Abby Long";
        if(twoOccurrences(stringA, stringB))
        {
            System.out.println("'"+stringA+"' occures at least 2 times in '"+stringB+"'");
        }
        else
            System.out.println("'"+stringA+"' does not occures at least 2 times in '"+stringB+"'");
        
        partOfString = lastPart(stringA, stringB);
        System.out.println("The part of the string after '"+stringA+"' in '"+stringB+"' is '"+partOfString+"'");
            
        stringA = "atg";
        stringB = "ctgtatgta";
        if(twoOccurrences(stringA, stringB))
        {
            System.out.println("'"+stringA+"' occures at least twice in '"+stringB+"'");
        }
        else
            System.out.println("'"+stringA+"' does not occures twice in '"+stringB+"'");
            
        partOfString = lastPart(stringA, stringB);
        System.out.println("The part of the string after '"+stringA+"' in '"+stringB+"' is '"+partOfString+"'");

        stringA = "zoo";
        stringB = "FOrest";
        if(twoOccurrences(stringA, stringB))
        {
            System.out.println("'"+stringA+"' occures at least twice in '"+stringB+"'");
        }
        else
            System.out.println("'"+stringA+"' does not occures twice in '"+stringB+"'");
            
        partOfString = lastPart(stringA, stringB);
        System.out.println("The part of the string after '"+stringA+"' in '"+stringB+"' is '"+partOfString+"'");
        
    }
}
