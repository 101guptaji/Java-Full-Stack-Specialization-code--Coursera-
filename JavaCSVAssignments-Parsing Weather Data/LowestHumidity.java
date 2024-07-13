import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
/**
 * 3. Write a method named lowestHumidityInFile that has one parameter, a CSVParser named parser. This method returns the CSVRecord that has the lowest humidity. 
 *  If there is a tie, then return the first such record that was found.
    Note that sometimes there is not a number in the Humidity column but instead there is the string “N/A”. This only happens very rarely. 
    You should check to make sure the value you get is not “N/A” before converting it to a number.
    Also note that the header for the time is either TimeEST or TimeEDT, depending on the time of year. 
    You will instead use the DateUTC field at the right end of the data file to  get both the date and time of a temperature reading.
    You should also write a void method named testLowestHumidityInFile() to test this method
 * 4. Write the method lowestHumidityInManyFiles that has no parameters. 
*     This method returns a CSVRecord that has the lowest humidity over all the files. 
*     If there is a tie, then return the first such record that was found. 
 *    You should also write a void method named testLowestHumidityInManyFiles() to test this method and to print the lowest humidity AND the time the lowest humidity occurred. 
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class LowestHumidity {
    
    public CSVRecord lowestHumidityInFile(CSVParser parse)
    {
        CSVRecord lowestHour = null;
        for(CSVRecord currHour : parse)
        {
            if(lowestHour == null)
            {
                lowestHour = currHour;
            }
            else{
                String currHumidity = currHour.get("Humidity");
                String lowestHumidity = lowestHour.get("Humidity");
                if(!currHumidity.equals("N/A") && !lowestHumidity.equals("N/A"))
                {
                    if(Integer.parseInt(currHumidity) < Integer.parseInt(lowestHumidity))
                        lowestHour = currHour;
                }
            }
        }
        return lowestHour;
    }
    
    public void testLowestHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHour = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity is "+lowestHour.get("Humidity")
                            +" at "+lowestHour.get("DateUTC"));
    }
    
    public CSVRecord lowestHumidityInManyFiles()
    {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestHour = null;
        File lowestFile = null;
        for(File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord currHour = lowestHumidityInFile(parser);
            if(lowestHour == null)
            {
                lowestHour = currHour;
                lowestFile = f;
            }
            else{
                String currHumidity = currHour.get("Humidity");
                String lowestHumidity = lowestHour.get("Humidity");
                if(currHumidity != "N/A" && lowestHumidity != "N/A" 
                    && Integer.parseInt(currHumidity) < Integer.parseInt(lowestHumidity))
                {
                    lowestHour = currHour;
                }
            }
        }
        return lowestHour;   
    }
    
    public void testLowestHumidityInManyFiles()
    {
        CSVRecord lowestHumidity = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was "+lowestHumidity.get("Humidity")
                            +" at "+lowestHumidity.get("DateUTC"));
    }
}
