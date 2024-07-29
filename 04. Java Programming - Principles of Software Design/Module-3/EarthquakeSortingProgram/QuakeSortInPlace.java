
/**
 * Selection Sort Algorithm
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    //Sort by Magnitude
    private int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    private void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }
    
    //Sort by Depth
    private int getLargestDepth(ArrayList<QuakeEntry> quakes, int from)
    {
        int maxDepthIndex = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getDepth() > quakes.get(maxDepthIndex).getDepth()) {
                maxDepthIndex = i;
            }
        }
        return maxDepthIndex;
    }
    
    //Highest depth first
    private void sortByLargestDepth(ArrayList<QuakeEntry> in) 
    {
       
       for (int i=0; i< in.size(); i++) {
            int maxIdx = getLargestDepth(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmax = in.get(maxIdx);
            in.set(i,qmax);
            in.set(maxIdx,qi);
        }
        
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    private void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                              qe.getLocation().getLatitude(),
                              qe.getLocation().getLongitude(),
                              qe.getMagnitude(),
                              qe.getInfo());
        }
    }
    
    private void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in)
    {
        int noOfPasses = 0;
        for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
            if(checkInSortedOrder(in))
            {
                noOfPasses = i+1;
                break;
            }
        }
        System.out.println("No of Passes used: "+noOfPasses);
    }
    
    private boolean checkInSortedOrder(ArrayList<QuakeEntry> qe)
    {
        for(int i =0;i<qe.size()-1;i++)
        {
            if(qe.get(i).getMagnitude() > qe.get(i+1).getMagnitude())
                return false;
        }
        return true;
    }
    
    //to test sorting 
    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/earthQuakeDataWeekDec6sample2.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitude(list);
        sortByLargestDepth(list);
        //sortByMagnitudeWithCheck(list);
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        
    }
    
}
