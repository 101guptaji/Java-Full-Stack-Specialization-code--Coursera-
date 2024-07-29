
/**
 * Write the class PhraseFilter that implements Filter. 
 * This class should include two private instance variables for 1) a String representing the type of request that indicates where to search in the title and has one of three values: (“start”, ”end”, or “any”), and 2) a String indicating the phrase to search for in the title of the earthquake (Note the title of the earthquake can be obtained through the getInfo method). 
 * This class also has a constructor to initialize those variables, and a satisfies method that returns true if the phrase is found at the requested location in the title. 
 * If the phrase is not found, this method should return false.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter
{
    private String where;
    private String phrase;
    
    public PhraseFilter(String search, String phraseTitle) { 
        where = search;
        phrase = phraseTitle;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        if(where.equals("start") && qe.getInfo().startsWith(phrase))
        {
            return true;
        }
        else if(where.equals("end") && qe.getInfo().endsWith(phrase))
        {
            return true;
        }
        else if(where.equals("any") && qe.getInfo().contains(phrase))
        {
            return true;
        }
        else
            return false;
    } 
    
    public String getName()
    {
        return "Phrase";
    }
}
