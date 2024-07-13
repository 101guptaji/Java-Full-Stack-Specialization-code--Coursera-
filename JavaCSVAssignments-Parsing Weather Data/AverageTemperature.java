import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
/**
 * 5. Write the method averageTemperatureInFile that has one parameter, a CSVParser named parser. 
 *      This method returns a double that represents the average temperature in the file. 
 *      You should also write a void method named testAverageTemperatureInFile() to test this method.
 * 6. Write the method averageTemperatureWithHighHumidityInFile that has two parameters, a CSVParser named parser and an integer named value. 
 *      This method returns a double that represents the average temperature of only those temperatures when the humidity was greater than or equal to value. 
 *      You should also write a void method named testAverageTemperatureWithHighHumidityInFile() to test this method.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AverageTemperature {
    public double averageTemperatureInFile(CSVParser parse)
    {
        double sumTemp = 0.0;
        int count = 0;
        for(CSVRecord currHour : parse)
        {
            double currTemp = Double.parseDouble(currHour.get("TemperatureF"));
            sumTemp+=currTemp;
            count++;
        }
        return sumTemp/count;
    }
    
    public void testTemperatureInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avgTemp = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is "+avgTemp);
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parse, int value)
    {
        double sumTemp = 0.0;
        int count = 0;
        for(CSVRecord currHour : parse)
        {
            double currTemp = Double.parseDouble(currHour.get("TemperatureF"));
            String currHumidity = currHour.get("Humidity");
            if(currHumidity != "N/A" && Integer.parseInt(currHumidity) >= value)
            {
                sumTemp+=currTemp;
                count++;
            }
        }
        //System.out.print(sumTemp+" ");
        //System.out.println(count);
        return sumTemp/count;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        int value = 80;
        double avgTempWithHumidity = averageTemperatureWithHighHumidityInFile(parser, value);
        if(Double.isNaN(avgTempWithHumidity))
        {
            System.out.println("No temperatures with that humidity");
        }
        else
            System.out.println("Average temperature with Humidity >= "+value+" in file is "+avgTempWithHumidity);
    }
}
