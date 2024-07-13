import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
/**
 *1. Write the method totalBirths to print the number of girls names , the number of boys names and the total names in the file.
 *2. Write the method named getRank that has three parameters: an integer named year, a string named name, and a string named gender (F for female and M for male). 
 *  This method returns the rank of the name in the file for the given gender,  where rank 1 is the name with the largest number of births. 
 *  If the name is not in the file, then -1 is returned.  
 *3. Write the method named getName that has three parameters: an integer named year, an integer named rank, and a string named gender (F for female and M for male). 
 *  This method returns the name of the person in the file at this rank, for the given gender, where rank 1 is the name with the largest number of births. 
 *  If the rank does not exist in the file, then “NO NAME”  is returned.
 *4. Write the void method named whatIsNameInYear that has four parameters: a string name, an integer named year representing the year that name was born,  an integer named newYear and a string named gender (F for female and M for male). 
 *  This method determines what name would have been named if they were born in a different year, based on the same popularity. 
 *  That is, you should determine the rank of name in the year they were born, and then print the name born in newYear that is at the same rank and same gender. 
 *5. Write the method yearOfHighestRank that has two parameters: a string name, and a string named gender (F for female and M for male). 
 *  This method selects a range of files to process and returns an integer, the year with the highest rank for the name and gender. 
 *  If the name and gender are not in any of the selected files, it should return -1.
 *6. Write the method getAverageRank that has two parameters: a string name, and a string named gender (F for female and M for male). 
 *  This method selects a range of files to process and returns a double representing the average rank of the name and gender over the selected files. 
 *  It should return -1.0 if the name is not ranked in any of the selected files.
 *7. Write the method getTotalBirthsRankedHigher that has three parameters: an integer named year, a string named name, and a string named gender (F for female and M for male). 
 *  This method returns an integer, the total number of births of those names with the same gender and same year who are ranked higher than name.  
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnalyzingBabyNames {

    public void totalBirths(FileResource fr)
    {
        CSVParser parser = fr.getCSVParser(false);
        int girlCount = 0;
        int boyCount = 0;
        int totalNames = 0;
        for(CSVRecord rec : parser)
        {
            if(rec.get(1).equals("F"))
            {
                girlCount++;
                totalNames++;
            }
            if(rec.get(1).equals("M"))
            {
                boyCount++;
                totalNames++;
            }
        }
        System.out.println("number of girls names= "+girlCount);
        System.out.println("number of boy names= "+boyCount);
        System.out.println("total number of names= "+totalNames);
    }
    
    public void tester()
    {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    
    public int getRank(int year, String name, String gender)
    {
        int rank = 0;
        //String fileName = "testing/yob"+year+"short.csv"; 
        String fileName = "us_babynames_by_year/yob"+year+".csv";
        FileResource fr = new FileResource(fileName);
        for(CSVRecord rec : fr.getCSVParser(false))
        {
            if(rec.get(1).equals(gender))
            {
                rank++;
                if(rec.get(0).equals(name))
                {
                    return rank;
                }
            }
            
        }
        return -1;
    }
    
    public void testGetRank()
    {
        /*
        int year = 2012;
        String name = "Isabella";
        String gender = "F";
        int rank = getRank(year, name, gender);
        System.out.println("Rank of name "+name+","+gender+" in year "+year+" is "+rank);
        */
        int year = 1971;
        String name = "Frank";
        String gender = "M";
        int rank = getRank(year, name, gender);
        System.out.println("Rank of name "+name+","+gender+" in year "+year+" is "+rank);
        /*
        int year = 1960;
        String name = "Emily";
        String gender = "F";
        int rank = getRank(year, name, gender);
        System.out.println("Rank of name "+name+","+gender+" in year "+year+" is "+rank);*/
        
    }
    
    public String getName(int year, int rank, String gender)
    {
        String name="";
        String fileName = "us_babynames_by_year/yob"+year+".csv";
        FileResource fr = new FileResource(fileName);
        for(CSVRecord rec : fr.getCSVParser(false))
        {
            if(rec.get(1).equals(gender))
            {
                rank--;
                if(rank == 0)
                {
                    return rec.get(0);
                }
            }
            
        }
        return "NO NAME";
    }
    
    public void testGetName()
    {
        /*
        int year = 2012;
        int rank = 3;
        String gender = "F";
        String name= getName(year, rank, gender);
        System.out.println("Name at Rank "+rank+" for gender "+gender+" in year "+year+" is "+name);
        
        int year = 2012;
        int rank = 5;
        String gender = "M";
        String name= getName(year, rank, gender);
        System.out.println("Name at Rank "+rank+" for gender "+gender+" in year "+year+" is "+name);
        */
       
        int year = 1982;
        int rank = 450;
        String gender = "M";
        String name= getName(year, rank, gender);
        System.out.println("Name at Rank "+rank+" for gender "+gender+" in year "+year+" is "+name);
        
    }
    
    public String whatIsNameInYear(String name, int year, int newYear, String gender)
    {
        String newName = "";
        int rank = getRank(year, name, gender);
        if(rank == -1)
            return null;
        newName = getName(newYear, rank, gender);
        return newName;
    }
    
    public void testWhatIsNameInYear()
    {
        int year = 1974;
        int newYear = 2014;
        String name = "Owen";
        String gender = "M";
        String newName = whatIsNameInYear(name, year, newYear, gender);
        System.out.println(name+" born in "+year+" would be "+newName+" if he/she was born in "+newYear);
    }
    
    public int yearOfHighestRank(String name, String gender)
    {
        DirectoryResource dr = new DirectoryResource();
        int highestYear = 0;
        int highestRank = 0;
        for(File f : dr.selectedFiles())
        {
            String fileName =f.getName();
            int temp = fileName.indexOf("yob");
            String year = fileName.substring(temp+3, temp+7);
            //System.out.println(year);
            int rank = getRank(Integer.parseInt(year), name, gender);
            if(highestRank == 0){
                highestRank = rank;
                highestYear = Integer.parseInt(year);
            }
            else
            {
                if(rank < highestRank)
                {
                    highestRank = rank;
                    highestYear = Integer.parseInt(year);
                }
            }
        }
        return highestYear;
    }
    
    public void testYearOfHighestRank()
    {
        int year = yearOfHighestRank("Mich", "M");
        System.out.println(year);
    }
    
    public double getAverageRank(String name, String gender)
    {
        DirectoryResource dr = new DirectoryResource();
        double sumRank = 0.0;
        int countFiles = 0;
        for(File f : dr.selectedFiles())
        {
            String fileName =f.getName();
            int temp = fileName.indexOf("yob");
            String year = fileName.substring(temp+3, temp+7);
            //System.out.println(year);
            int rank = getRank(Integer.parseInt(year), name, gender);
            if(rank == -1)
            {
                return -1.0;
            }
            sumRank += rank;
            countFiles++;
        }
        return sumRank/countFiles;
    }
    
    public void testGetAverageRank()
    {
        /*
        double avgRank = getAverageRank("Mason", "M");
        System.out.println("Average Rank "+avgRank);
        
        double avgRank = getAverageRank("Emma", "F");
        System.out.println("Average Rank "+avgRank);*/
        
        double avgRank = getAverageRank("Robert", "M");
        System.out.println("Average Rank "+avgRank);
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender)
    {
        int totalBirth = 0;
        String fileName = "us_babynames_by_year/yob"+year+".csv";
        FileResource fr = new FileResource(fileName);
        for(CSVRecord rec : fr.getCSVParser(false))
        {
            if(rec.get(1).equals(gender))
            {
                if(rec.get(0).equals(name))
                {
                    return totalBirth;
                }
                totalBirth += Integer.parseInt(rec.get(2));
            }
            
        }
        return -1;
    }
    
    public void testGetTotalBirthsRankedHigher()
    {
        int year = 1990;
        String name = "Drew";
        String gender = "M";
        int rank = getRank(year, name, gender);
        int totalBirth = getTotalBirthsRankedHigher(year, name, gender);
        System.out.println("Total no. of births with ranked higher than "+name+" of gender "+gender+" in year "+year+" is "+totalBirth);

    }
}
