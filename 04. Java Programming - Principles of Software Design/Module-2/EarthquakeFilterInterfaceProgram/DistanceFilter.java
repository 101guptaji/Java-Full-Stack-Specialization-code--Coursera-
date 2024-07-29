
/**
 * Write the class DistanceFilter that implements Filter. 
 * This class should include private instance variables for a location and a maximum distance, a constructor to initialize those variables, and a satisfies method that returns true if a QuakeEntry’s distance from the given location is less than the specified maximum distance. 
 * Otherwise it should return false..
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter
{
    private Location loc;
    private double maxDistance;
    
    public DistanceFilter(Location location, double max) { 
        loc = location;
        maxDistance = max;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return qe.getLocation().distanceTo(loc) < maxDistance; 
    } 
    
    public String getName()
    {
        return "Distance";
    }
}
