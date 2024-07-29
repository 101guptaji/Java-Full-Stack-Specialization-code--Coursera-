import java.util.*;
/**
 *  Finding the Largest Magnitude Earthquakes.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LargestQuakes {

    public void findLargestQuakes()
    {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";

        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("# quakes read: " + list.size());
        /*
        for (QuakeEntry qe : list) {
           System.out.println(qe); 
        }
        */
       
        //int index = indexOfLargest(list);
        //System.out.println("Largest such earthquake is at location: "+index);
        //System.out.println(list.get(index));
        
        ArrayList<QuakeEntry> close = getLargest(list, 20);
        for(QuakeEntry qe : close)
        {
                System.out.println(qe);
        }
        System.out.println("number found: " + close.size());
    }
    
    private int indexOfLargest(ArrayList<QuakeEntry> data)
    {
        int index = -1;
        double mag = 0.0;
        
        for (int i =0;i<data.size();i++) {
            if (data.get(i).getMagnitude() > mag) {
                index = i;
                mag = data.get(i).getMagnitude();
            }
        }
        return index;
    }
    
    private ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany)
    {
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        ArrayList<QuakeEntry> ans = new ArrayList<QuakeEntry>();
        for(int j=0; j < howMany; j++) {
            int minIndex = 0;
            double maxMag = 0.0;
            for(int k=1; k < copy.size(); k++){
                QuakeEntry quake = copy.get(k);
                if(quake.getMagnitude() > maxMag)
                {
                    maxMag = quake.getMagnitude();
                    minIndex = k;   
                }
            }
          
            ans.add(copy.get(minIndex));
            copy.remove(minIndex);
        }
        return ans;
    }
}
