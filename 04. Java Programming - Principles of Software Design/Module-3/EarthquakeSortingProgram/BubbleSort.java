import java.util.*;
import edu.duke.*;
/**
 * Bubble Sort Algorithm.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BubbleSort {

    private void onePassBubbleSort(ArrayList<QuakeEntry> quakes, int numSorted)
    {
        for(int i = 0;i<quakes.size()-numSorted;i++)
        {
            QuakeEntry curr = quakes.get(i);
            QuakeEntry next = quakes.get(i+1); 
            if(curr.getMagnitude() > next.getMagnitude())
            {
                quakes.set(i, next);
                quakes.set(i+1, curr);
            }
        }
    }
    
    private void  sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> quakes)
    {
        for(int i = 0;i<quakes.size()-1;i++)
        {
            onePassBubbleSort(quakes, i+1);
        }
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        for (QuakeEntry qe: list) 
        { 
            System.out.println(qe);
        } 
        System.out.println("# quakes read: " + list.size());
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
    
    private void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> quakes)
    {
        int noOfPasses = 0;
        for(int i = 0;i<quakes.size()-1;i++)
        {
            onePassBubbleSort(quakes, i+1);
            if(checkInSortedOrder(quakes))
            {
                noOfPasses = i+1;
                break;
            }
        }
        System.out.println("No of Passes used: "+noOfPasses);
    }
    
    
    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
        
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitudeWithBubbleSort (list);
        sortByMagnitudeWithBubbleSortWithCheck(list);
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
       
    }
}



