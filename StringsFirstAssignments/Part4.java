
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.URLResource;
public class Part4 {
    
    public void findYoutubeLink()
    {
        URLResource url = new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String word : url.words()) 
        {
            //System.out.println(word);
            String wordLower = word.toLowerCase();
            int index = wordLower.indexOf("youtube.com");
            if(index != -1)
            {
                int start = word.lastIndexOf("\"", index);
                int end = word.indexOf("\"", index+11);
                System.out.println(word.substring(start,end+1));
            }
        }
    }
}
