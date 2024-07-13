import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Assignment
The CSV file exportdata.csv has information on the export products of countries; 
. In particular it has three column headers labeled Country, Exports, and Value (dollars). .
 * 1. Write a method named tester that will create your CSVParser and call each of the methods below in parts 2, 3, 4, and 5.
 * Each time you want to use the parser with another method, you will need to reset the parser by calling fr.getCSVParser() again to get a new parser.
 * 2. Write a method named countryInfo that has two parameters, parser is a CSVParser and country is a String. This method returns a string of information about the country or returns “NOT FOUND” if there is no information about the country. The format of the string returned is the country, followed by “: “, followed by a list of the countries’ exports, followed by “: “, followed by the countries export value.
 * 3. Write a void method named listExportersTwoProducts that has three parameters, parser is a CSVParser, exportItem1 is a String and exportItem2 is a String. This method prints the names of all the countries that have both exportItem1 and exportItem2 as export items.
 * 4. Write a method named numberOfExporters, which has two parameters, parser is a CSVParser, and exportItem is a String. This method returns the number of countries that export exportItem.
 * 5. Write a void method named bigExporters that has two parameters, parser is a CSVParser, and amount is a String in the format of a dollar sign, followed by an integer number with a comma separator every three digits from the right. An example of such a string might be “$400,000,000”. This method prints the names of countries and their Value amount for all countries whose Value (dollars) string is longer than the amount string. You do not need to parse either string value as an integer, just compare the lengths of the strings
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CountryExport {

    public String countryInfo(CSVParser parse, String country)
    {
        String result = "NOT FOUND";
        
        for(CSVRecord record : parse)
        {
            //System.out.println(record.get("Country"));
            if(record.get("Country").equals(country))
            {
                result = country+": "+record.get("Exports")+": "+record.get("Value (dollars)");
            }
        }
        
        return result;
    }
    
    public void listExportersTwoProducts(CSVParser parse, String export1, String export2)
    {
        for(CSVRecord record : parse)
        {
            //System.out.println("Country "+record.get("Country"));
            if(record.get("Exports").contains(export1) && record.get("Exports").contains(export2))
            {
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public int numberOfExporters(CSVParser parse, String exportItem)
    {
        int count = 0;
        for(CSVRecord record : parse)
        {
            //System.out.println(record.get("Country"));
            if(record.get("Exports").contains(exportItem))
            {
                count++;
                //System.out.println(record.get("Country"));
            }
        }
        
        return count;
    }
    
    public void bigExporters(CSVParser parse, String value)
    {
        for(CSVRecord record : parse)
        {
            //System.out.println(record.get("Country"));
            if(record.get("Value (dollars)").length() > value.length())
            {
                System.out.println(record.get("Country")+" "+record.get("Value (dollars)"));
            }
        }
    }
    
    public void tester()
    {
        FileResource fr = new FileResource();
        /*CSVParser parser1 = fr.getCSVParser();
        String countryInfo1 = countryInfo(parser1, "Germany");
        System.out.println(countryInfo1);
        
        CSVParser parser2 = fr.getCSVParser();
        String countryInfo2 = countryInfo(parser2, "Nauru");
        System.out.println(countryInfo2);
        
        CSVParser parser3 = fr.getCSVParser();
        listExportersTwoProducts(parser3, "cotton", "flowers"); 
        
        CSVParser parser4 = fr.getCSVParser();
        int num = numberOfExporters(parser4, "cocoa"); 
        System.out.println("No. of exporter of cocoa are "+num);
        */
        CSVParser parser5 = fr.getCSVParser();
        bigExporters(parser5, "$999,999,999,999"); 
    }
}
