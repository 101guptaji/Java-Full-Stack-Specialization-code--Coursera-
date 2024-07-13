
/**
 * You will write a program to find the coldest day of the year and other interesting facts about the temperature and humidity in a day. 
 * 1. Write a method named coldestHourInFile that has one parameter, a CSVParser named parser. 
 * This method returns the CSVRecord with the coldest temperature in the file and thus all the information about the coldest temperature, such as the hour of the coldest temperature. 
 * You should also write a void method named testColdestHourInFile() to test this method and print out information about that coldest temperature, such as the time of its occurrence.
 * 2. Write the method fileWithColdestTemperature that has no parameters. This method should return a string that is the name of the file from selected files that has the coldest temperature. 
 * You should also write a void method named testFileWithColdestTemperature() to test this method. 
 * Note that after determining the filename, you could call the method coldestHourInFile to determine the coldest temperature on that day.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

public class ColdestDayOfYear {

    public CSVRecord coldestHourInFile(CSVParser parse)
    {
        CSVRecord coldestHour = null;
        for(CSVRecord currHour : parse)
        {
            if(coldestHour == null)
            {
                coldestHour = currHour;
            }
            else{
                double currTemp = Double.parseDouble(currHour.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestHour.get("TemperatureF"));
                if(currTemp < coldestTemp && currTemp != -9999)
                {
                    coldestHour = currHour;
                }
            }
        }
        return coldestHour;
    }
    
    public void testColdestHourInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldestHour = coldestHourInFile(parser);
        System.out.println("Coldest Temperature is "+coldestHour.get("TemperatureF")
                            +" at "+coldestHour.get("DateUTC"));
    }
    
    public void fileWithColdestTemperature()
    {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord coldestHour = null;
        File coldestFile = null;
        for(File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord currHour = coldestHourInFile(parser);
            if(coldestHour == null)
            {
                coldestHour = currHour;
                coldestFile = f;
            }
            else{
                double currTemp = Double.parseDouble(currHour.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestHour.get("TemperatureF"));
                if(currTemp < coldestTemp && currTemp != -9999)
                {
                    coldestHour = currHour;
                    coldestFile = f;
                }
            }
        }
        //return coldestFile;
        System.out.println("Coldest day was in file "+coldestFile.getName());
        FileResource fr = new FileResource(coldestFile);
        CSVParser parser = fr.getCSVParser();
        System.out.println("Coldest temperature on that day was "+coldestHour.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were:");
        for(CSVRecord currHour : parser)
        {
            System.out.println(currHour.get("DateUTC")+" "+currHour.get("TemperatureF"));
        }
    }
    
    public void testFileWithColdestTemperature()
    {
        fileWithColdestTemperature();
    }
}
