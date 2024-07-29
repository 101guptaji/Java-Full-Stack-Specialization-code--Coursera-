import java.util.*;
import edu.duke.*;
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester {
    
    public void testGetFollows()
    {
        MarkovOne markov = new MarkovOne();
        String text =  "this is a test yes this is a test.";
        markov.setTraining(text);
        ArrayList<String> ft = markov.getFollows("e");
        for(String cc : ft)
        {
            System.out.print("\""+cc+"\" ");
        }
        System.out.println("\nNo. of followed letters are: "+ft.size());
    }
    
    public void testGetFollowsWithFile()
    {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        
        MarkovOne markov = new MarkovOne();
        markov.setTraining(st);
        ArrayList<String> ft = markov.getFollows("o");
        for(String cc : ft)
        {
            System.out.print("\""+cc+"\" ");
        }
        System.out.println("\nNo. of followed letters are: "+ft.size());
    
    }
}







