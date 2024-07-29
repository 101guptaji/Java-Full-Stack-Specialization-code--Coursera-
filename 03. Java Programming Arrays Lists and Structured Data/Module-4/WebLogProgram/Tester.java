
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        //la.readFile("short-test_log");
        la.readFile("weblog2_log");
        la.printAll();
        
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("Unique IPs are: "+uniqueIPs);
        
        int num = 400;
        System.out.println("Log Entries with status code greater than "+num);
        la.printAllHigherThanNum(num);
 
    }
    
    public void testUniqueIPVisitsOnDay()
    {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        
        String someDay = "Sep 24";
        ArrayList<String> uniqueIPsDay = la.uniqueIPVisitsOnDay(someDay);
        System.out.println("Unique IPs on "+someDay+" are: "+uniqueIPsDay.size());
        for(int i=0;i<uniqueIPsDay.size();i++)
        {
            System.out.println(uniqueIPsDay.get(i));
        }
        
        int low = 400, high = 499;
        int uniqueIPsRange = la.countUniqueIPsInRange(low, high);
        System.out.println("Unique IPs in range "+low+" to "+high+" are: "+uniqueIPsRange);
    }
    
    public void testCountVisitersPerIP()
    {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        //la.readFile("short-test_log");
        
        HashMap <String, Integer> counts = la.countVisitersPerIP();
        System.out.println(counts);
        /*
        for(String ip : counts.keySet())
        {
            System.out.println(ip+"\tcounts: "+counts.get(ip));
        }
        */
       
       int maxCount = la.mostNumberVisitsByIP(counts);
       System.out.println("Most number visits by an IP: "+maxCount);
       
       ArrayList<String> ipList = la.iPsMostVisits(counts);
       System.out.println(ipList);
       
       HashMap <String, ArrayList<String>> ipMapDay = la.iPsForDays();
       System.out.println(ipMapDay);
       
       String day = la.dayWithMostIPVisits(ipMapDay);
       System.out.println("Day most visited: "+day);
       
       ArrayList<String> mostVisitedIPs = la.iPsWithMostVisitsOnDay(ipMapDay, "Sep 29");
       System.out.println(mostVisitedIPs);
    }
}
