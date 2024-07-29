
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource fr =new FileResource(filename);
         for(String line : fr.lines())
         {
             LogEntry log = WebLogParser.parseEntry(line);
             records.add(log);
             
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs()
     {
         ArrayList<String> uniqueIPs = new ArrayList <String> ();
         
         for(LogEntry le : records)
         {
             String ipAddrs = le.getIpAddress();
             if(!uniqueIPs.contains(ipAddrs))
             {
                 uniqueIPs.add(ipAddrs);
             }
         }
         return uniqueIPs.size();
     }
     
     // write the void method printAllHigherThanNum that has one integer parameter num. This method should examine all the web log entries in records and print those LogEntrys that have a status code greater than num.
     public void printAllHigherThanNum(int num)
     {         
         for(LogEntry le : records)
         {
             int highStatus = le.getStatusCode();
             if(highStatus > num)
             {
                 System.out.println(le);
             }
         }
         
     }
     
     //In the LogAnalyzer class, write the method uniqueIPVisitsOnDay that has one String parameter named someday in the format “MMM DD”.
     //This method accesses the web logs in records and returns an ArrayList of Strings of unique IP addresses that had access on the given day. 
     public ArrayList<String> uniqueIPVisitsOnDay(String someday)
     {
         ArrayList<String> uniqueIPs = new ArrayList <String> ();
         for(LogEntry le : records)
         {
             String date = le.getAccessTime().toString();
             date = date.substring(4,10);
             String ipAddrs = le.getIpAddress();
             if(date.equals(someday) && !uniqueIPs.contains(ipAddrs))
             {
                 uniqueIPs.add(ipAddrs);
             }
         }
         return uniqueIPs;
     }
     
     //write the method countUniqueIPsInRange that has two integer parameters named low and high. This method returns the number of unique IP addresses in records that have a status code in the range from low to high, inclusive.
     public int countUniqueIPsInRange(int low, int high)
     {
         ArrayList<String> uniqueIPs = new ArrayList <String> ();
         for(LogEntry le : records)
         {
             int statusCode = le.getStatusCode();
             if(statusCode >= low && statusCode <= high)
             {
                 String ipAddrs = le.getIpAddress();
                 if(!uniqueIPs.contains(ipAddrs))
                 {
                     uniqueIPs.add(ipAddrs);
                 }
             }
         }
         return uniqueIPs.size();
     }
     
     // write the method countVisitsPerIP, which has no parameters. This method returns a HashMap<String, Integer> that maps an IP address to the number of times that IP address appears in records, meaning the number of times this IP address visited the website
     public HashMap <String, Integer> countVisitersPerIP()
     {
         HashMap <String, Integer> countsMap = new HashMap <String, Integer>();
         
         for(LogEntry le : records)
         {
             String ipAddrs = le.getIpAddress();
             if(!countsMap.containsKey(ipAddrs))
             {
                 countsMap.put(ipAddrs, 1);
             }
             else
             {
                 int val = countsMap.get(ipAddrs);
                 countsMap.put(ipAddrs, val+1);
             }
         }
         return countsMap;
     }
     
     // write the method mostNumberVisitsByIP, which has one parameter, a HashMap<String, Integer> that maps an IP address to the number of times that IP address appears in the web log file. This method returns the maximum number of visits to this website by a single IP address.
     public int mostNumberVisitsByIP(HashMap <String, Integer> countsMap)
     {
        int maxCount = 0;
        for(String ip : countsMap.keySet())
        {
            if(maxCount == 0)
            {
                maxCount = countsMap.get(ip);
            }
            if(countsMap.get(ip) > maxCount)
            {
                maxCount = countsMap.get(ip);
            }
        }
        return maxCount;
     }
     
     //write the method iPsMostVisits, which has one parameter, a HashMap<String, Integer> that maps an IP address to the number of times that IP address appears in the web log file. This method returns an ArrayList of Strings of IP addresses that all have the maximum number of visits to this website. 
     public ArrayList<String> iPsMostVisits(HashMap <String, Integer> countsMap)
     {
         ArrayList<String> ipList = new ArrayList<String> ();
         int maxCount = mostNumberVisitsByIP(countsMap);
         for(String ip : countsMap.keySet())
        {
            if(countsMap.get(ip) == maxCount)
            {
                ipList.add(ip);
            }
        }
        return ipList;
     }
     
     //write the method iPsForDays, which has no parameters. This method returns a HashMap<String, ArrayList<String>> that uses records and maps days from web logs to an ArrayList of IP addresses that occurred on that day (including repeated IP addresses). A day is in the format “MMM DD”
     public HashMap <String, ArrayList<String>> iPsForDays()
     {
         HashMap <String, ArrayList<String>> countsMap = new HashMap <String, ArrayList<String>>();
         
         for(LogEntry le : records)
         {
             ArrayList<String> ipList = new ArrayList<String>();
             String date = le.getAccessTime().toString();
             date = date.substring(4,10);
             String ipAddrs = le.getIpAddress();
             if(!countsMap.containsKey(date))
             {
                 ipList.add(ipAddrs);
                 countsMap.put(date, ipList);
             }
             else
             {
                 ipList = countsMap.get(date);
                 ipList.add(ipAddrs);
                 countsMap.put(date, ipList);
             }
         }
         return countsMap;
     }
     
     // write the method dayWithMostIPVisits, which has one parameter that is a HashMap<String, ArrayList<String>> that uses records and maps days from web logs to an ArrayList of IP addresses that occurred on that day. This method returns the day that has the most IP address visits. If there is a tie, then return any such day.
     public String dayWithMostIPVisits(HashMap <String, ArrayList<String>> ipMapDay)
     {
         int count = 0;
         String day = "";
         for(String key : ipMapDay.keySet())
         {
             if(ipMapDay.get(key).size() > count)
             {
                 count = ipMapDay.get(key).size();
                 day = key;
             }
             
         }
         return day;
     }
     
     //write the method iPsWithMostVisitsOnDay, which has two parameters—the first one is a HashMap<String, ArrayList<String>> that uses records and maps days from web logs to an ArrayList of IP addresses that occurred on that day, and the second parameter is a String representing a day in the format “MMM DD”.
     //This method returns an ArrayList<String> of IP addresses that had the most accesses on the given day.
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap <String, ArrayList<String>> ipMapDay, String day)
     {
         ArrayList<String> uniqueIPs = new ArrayList <String> ();
         HashMap <String, Integer> ipCountMap = new HashMap <String, Integer> ();
         for(String date : ipMapDay.keySet())
         {
             if(date.equals(day))
             {
                 for(String ip : ipMapDay.get(date))
                 {
                     if(!ipCountMap.containsKey(ip))
                     {
                         ipCountMap.put(ip, 1);
                     }
                     else
                     {
                         ipCountMap.put(ip, ipCountMap.get(ip)+1);
                     }
                 }
                 break;
             }
         }
         int maxCount = mostNumberVisitsByIP(ipCountMap);
         for(String ip : ipCountMap.keySet())
         {
             if(ipCountMap.get(ip) == maxCount)
             {
                 uniqueIPs.add(ip);
             }
         }
         
         return uniqueIPs;
     }
}







